package lotto.parser

import lotto.domain.Lotto
import lotto.domain.WinningNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class DefaultLottoInputParserTest {

    private val winningLotto = Lotto.of(listOf(1, 2, 3, 4, 5, 6))
    private val parser = DefaultLottoInputParser { winningLotto }

    @Nested
    inner class ParsePurchaseAmount {

        @Test
        fun `should parse valid numeric input into PurchaseAmount`() {
            val result = parser.parsePurchaseAmount("5000")
            assertThat(result.value).isEqualTo(5000)
        }

        @Test
        fun `should throw error on non-numeric input`() {
            val invalidInput = "abc"
            val exception = assertThrows<IllegalArgumentException> {
                parser.parsePurchaseAmount(invalidInput)
            }
            assertThat(exception.message)
                .isEqualTo(DefaultLottoInputParser.ERROR_INVALID_PURCHASE_AMOUNT.format(invalidInput))
        }
    }

    @Nested
    inner class ParseWinningLotto {

        @Test
        fun `should parse comma-separated numbers into Lotto`() {
            val result = parser.parseWinningLotto("1, 2, 3, 4, 5, 6")
            assertThat(result.numbers()).containsExactly(1, 2, 3, 4, 5, 6)
        }

        @Test
        fun `should throw error if any value is non-numeric`() {
            val invalidToken = "three"
            val exception = assertThrows<IllegalArgumentException> {
                parser.parseWinningLotto("1, 2, $invalidToken, 4, 5, 6")
            }
            assertThat(exception.message)
                .isEqualTo(DefaultLottoInputParser.ERROR_INVALID_WINNING_NUMBER.format(invalidToken))
        }
    }

    @Nested
    inner class ParseBonusNumber {

        @Test
        fun `should parse valid bonus number`() {
            val result = parser.parseBonusNumber("7")
            assertThat(result.value).isEqualTo(7)
        }

        @Test
        fun `should throw error on non-numeric bonus number`() {
            val invalidBonus = "bonus"
            val exception = assertThrows<IllegalArgumentException> {
                parser.parseBonusNumber(invalidBonus)
            }
            assertThat(exception.message)
                .isEqualTo(DefaultLottoInputParser.ERROR_INVALID_BONUS_NUMBER.format(invalidBonus))
        }

        @Test
        fun `should throw error if bonus number duplicates winning numbers`() {
            val duplicateBonus = "3"
            val exception = assertThrows<IllegalArgumentException> {
                parser.parseBonusNumber(duplicateBonus)
            }
            assertThat(exception.message)
                .isEqualTo(WinningNumbers.ERROR_DUPLICATE_WITH_LOTTO)
        }
    }
}
