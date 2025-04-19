package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {

    @Nested
    inner class SuccessCase {

        @Test
        fun `should create Lotto with 6 unique numbers`() {
            val lotto = Lotto.of(listOf(8, 3, 1, 15, 9, 2))
            assertThat(lotto.numbers()).containsExactly(1, 2, 3, 8, 9, 15)
        }

        @Test
        fun `should consider two Lotto with same numbers as equal`() {
            val lotto1 = Lotto.of(listOf(1, 2, 3, 4, 5, 6))
            val lotto2 = Lotto.of(listOf(6, 5, 4, 3, 2, 1))
            assertThat(lotto1).isEqualTo(lotto2)
            assertThat(lotto1.hashCode()).isEqualTo(lotto2.hashCode())
        }

        @Test
        fun `toString should print sorted Lotto numbers`() {
            val lotto = Lotto.of(listOf(10, 3, 7, 1, 6, 2))
            assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 6, 7, 10]")
        }

        @Test
        fun `match should return correct WinningRank`() {
            val userLotto = Lotto.of(listOf(1, 2, 3, 4, 5, 6))
            val winningLotto = Lotto.of(listOf(1, 2, 3, 4, 5, 6))
            val bonusNumber = BonusNumber.of(7)
            val winningNumbers = WinningNumbers.of(winningLotto, bonusNumber)

            val result = userLotto.match(winningNumbers)

            assertThat(result).isEqualTo(WinningRank.FIRST)
        }

        @Test
        fun `match should return SECOND if 5 numbers match and bonus matches`() {
            val userLotto = Lotto.of(listOf(1, 2, 3, 4, 5, 7))
            val winningLotto = Lotto.of(listOf(1, 2, 3, 4, 5, 6))
            val bonusNumber = BonusNumber.of(7)
            val winningNumbers = WinningNumbers.of(winningLotto, bonusNumber)

            val result = userLotto.match(winningNumbers)

            assertThat(result).isEqualTo(WinningRank.SECOND)
        }
    }

    @Nested
    inner class FailCase {

        @Test
        fun `should throw when more than 6 numbers are given`() {
            val exception = assertThrows<IllegalArgumentException> {
                Lotto.of(listOf(1, 2, 3, 4, 5, 6, 7))
            }

            assertThat(exception.message).isEqualTo(Lotto.ERROR_INVALID_SIZE)
        }

        @Test
        fun `should throw when duplicate numbers are given`() {
            val exception = assertThrows<IllegalArgumentException> {
                Lotto.of(listOf(1, 2, 3, 4, 5, 5))
            }

            assertThat(exception.message).isEqualTo(Lotto.ERROR_DUPLICATE_NUMBERS)
        }
    }
}
