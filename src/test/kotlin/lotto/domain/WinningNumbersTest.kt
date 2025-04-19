package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumbersTest {

    private val winningLotto = Lotto.of(listOf(1, 2, 3, 4, 5, 6))

    @Nested
    inner class SuccessCase {

        @Test
        fun `should create WinningNumbers when bonus number is not duplicated`() {
            val bonusNumber = BonusNumber.of(7)
            val winningNumbers = WinningNumbers.of(winningLotto, bonusNumber)

            assertThat(winningNumbers.numbers()).containsExactly(1, 2, 3, 4, 5, 6)
        }

        @Test
        fun `should return true if user Lotto contains bonus number`() {
            val bonusNumber = BonusNumber.of(7)
            val winningNumbers = WinningNumbers.of(winningLotto, bonusNumber)

            val userLotto = Lotto.of(listOf(7, 11, 22, 33, 44, 45))
            assertThat(winningNumbers.containsBonus(userLotto)).isTrue()
        }

        @Test
        fun `should return false if user Lotto does not contain bonus number`() {
            val bonusNumber = BonusNumber.of(7)
            val winningNumbers = WinningNumbers.of(winningLotto, bonusNumber)

            val userLotto = Lotto.of(listOf(8, 9, 10, 11, 12, 13))
            assertThat(winningNumbers.containsBonus(userLotto)).isFalse()
        }
    }

    @Nested
    inner class FailCase {

        @Test
        fun `should throw an error if bonus number is duplicated with winning numbers`() {
            val duplicatedBonus = BonusNumber.of(3)

            val exception = assertThrows<IllegalArgumentException> {
                WinningNumbers.of(winningLotto, duplicatedBonus)
            }

            assertThat(exception.message).isEqualTo(WinningNumbers.ERROR_DUPLICATE_WITH_LOTTO)
        }
    }
}
