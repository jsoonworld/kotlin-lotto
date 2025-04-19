package lotto.domain

class WinningNumbers private constructor(
    private val winningLotto: Lotto,
    private val bonusNumber: BonusNumber
) {
    fun numbers(): List<Int> = winningLotto.numbers()

    fun containsBonus(userLotto: Lotto): Boolean = bonusNumber.value in userLotto.numbers()

    companion object {
        const val ERROR_DUPLICATE_WITH_LOTTO = "[ERROR] Bonus number must not duplicate with lotto numbers."

        fun of(lotto: Lotto, bonusNumber: BonusNumber): WinningNumbers {
            require(bonusNumber.value !in lotto.numbers()) { ERROR_DUPLICATE_WITH_LOTTO }
            return WinningNumbers(lotto, bonusNumber)
        }
    }
}