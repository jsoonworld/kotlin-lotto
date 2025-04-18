package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusNumberTest {

    private val lotto = Lotto.of(listOf(1, 2, 3, 4, 5, 6))

    @Nested
    inner class SuccessCase {

        @Test
        fun `should create BonusNumber when not in Lotto numbers`() {
            val bonus = BonusNumber.of(7, lotto)
            assertThat(bonus.value).isEqualTo(7)
        }

        @Test
        fun `should consider two BonusNumbers with same value as equal`() {
            val bonus1 = BonusNumber.of(9, lotto)
            val bonus2 = BonusNumber.of(9, lotto)
            assertThat(bonus1).isEqualTo(bonus2)
            assertThat(bonus1.hashCode()).isEqualTo(bonus2.hashCode())
        }

        @Test
        fun `toString should return bonus number as string`() {
            val bonus = BonusNumber.of(13, lotto)
            assertThat(bonus.toString()).isEqualTo("13")
        }
    }

    @Nested
    inner class FailCase {

        @Test
        fun `should throw when bonus number is included in Lotto numbers`() {
            val exception = assertThrows<IllegalArgumentException> {
                BonusNumber.of(3, lotto)
            }

            assertThat(exception.message).isEqualTo(BonusNumber.ERROR_DUPLICATE_WITH_LOTTO)
        }
    }
}
