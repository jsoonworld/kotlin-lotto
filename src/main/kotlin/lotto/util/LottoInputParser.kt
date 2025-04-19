package lotto.parser

import lotto.domain.BonusNumber
import lotto.domain.Lotto
import lotto.domain.PurchaseAmount
import lotto.domain.WinningNumbers

interface LottoInputParser {
    fun parsePurchaseAmount(input: String): PurchaseAmount
    fun parseWinningLotto(input: String): Lotto
    fun parseBonusNumber(input: String): BonusNumber
}

class DefaultLottoInputParser(
    private val winningLottoProvider: () -> Lotto
) : LottoInputParser {

    override fun parsePurchaseAmount(input: String): PurchaseAmount {
        val amount = input.toIntOrNull()
            ?: throw IllegalArgumentException(ERROR_INVALID_PURCHASE_AMOUNT.format(input))
        return PurchaseAmount.from(amount)
    }

    override fun parseWinningLotto(input: String): Lotto {
        val numbers = input.split(",").map {
            val trimmed = it.trim()
            trimmed.toIntOrNull()
                ?: throw IllegalArgumentException(ERROR_INVALID_WINNING_NUMBER.format(trimmed))
        }
        return Lotto.of(numbers)
    }


    override fun parseBonusNumber(input: String): BonusNumber {
        val number = input.toIntOrNull()
            ?: throw IllegalArgumentException(ERROR_INVALID_BONUS_NUMBER.format(input))
        val bonus = BonusNumber.of(number)
        val winningLotto = winningLottoProvider()
        return WinningNumbers.of(winningLotto, bonus).let { bonus }
    }

    companion object {
        const val ERROR_INVALID_PURCHASE_AMOUNT = "[ERROR] 입력은 숫자여야 합니다: %s"
        const val ERROR_INVALID_WINNING_NUMBER = "[ERROR] 당첨 번호는 숫자여야 합니다: %s"
        const val ERROR_INVALID_BONUS_NUMBER = "[ERROR] 보너스 번호는 숫자여야 합니다: %s"
    }
}
