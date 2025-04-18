package lotto

import lotto.domain.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {

    @Nested
    inner class SuccessCase {

        @Test
        fun `should create Lotto with 6 unique numbers`() {
            val lotto = Lotto(listOf(8, 3, 1, 15, 9, 2))
            assertThat(lotto.numbers()).containsExactly(1, 2, 3, 8, 9, 15)
        }
    }

    @Nested
    inner class FailCase {

        @Test
        fun `should throw when more than 6 numbers are given`() {
            val exception = assertThrows<IllegalArgumentException> {
                Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
            }

            assertThat(exception.message).isEqualTo(Lotto.ERROR_INVALID_SIZE)
        }

        @Test
        fun `should throw when duplicate numbers are given`() {
            val exception = assertThrows<IllegalArgumentException> {
                Lotto(listOf(1, 2, 3, 4, 5, 5))
            }

            assertThat(exception.message).isEqualTo(Lotto.ERROR_DUPLICATE_NUMBERS)
        }
    }
}
