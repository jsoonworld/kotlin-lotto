package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RandomNumberGeneratorTest {

    private val generator = RandomNumberGenerator()

    @Nested
    inner class SuccessCase {

        @RepeatedTest(5)
        fun `should generate 6 unique lotto numbers between 1 and 45`() {
            val lotto = generator.generateLotto()
            val numbers = lotto.numbers()

            assertThat(numbers).hasSize(6)
            assertThat(numbers.distinct()).hasSize(6)
            assertThat(numbers).allMatch { it in 1..45 }
        }

        @Test
        fun `should generate a bonus number not included in the main numbers`() {
            val mainNumbers = listOf(1, 2, 3, 4, 5, 6)
            val bonus = generator.generateBonusNumber(mainNumbers)

            assertThat(bonus).isNotIn(mainNumbers)
            assertThat(bonus).isBetween(1, 45)
        }
    }

    @Nested
    inner class FailCase {

        @Test
        fun `should throw when all numbers are excluded from bonus candidate`() {
            val allNumbers = (1..45).toList()

            val exception = assertThrows<NoSuchElementException> {
                generator.generateBonusNumber(allNumbers)
            }

            assertThat(exception).isInstanceOf(NoSuchElementException::class.java)
        }
    }
}
