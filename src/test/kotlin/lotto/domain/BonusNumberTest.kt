package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class BonusNumberTest {

    @Nested
    inner class SuccessCase {

        @Test
        fun `should create BonusNumber successfully`() {
            val bonus = BonusNumber.of(7)
            assertThat(bonus.value).isEqualTo(7)
        }

        @Test
        fun `should consider two BonusNumbers with same value as equal`() {
            val bonus1 = BonusNumber.of(9)
            val bonus2 = BonusNumber.of(9)
            assertThat(bonus1).isEqualTo(bonus2)
            assertThat(bonus1.hashCode()).isEqualTo(bonus2.hashCode())
        }

        @Test
        fun `toString should return bonus number as string`() {
            val bonus = BonusNumber.of(13)
            assertThat(bonus.toString()).isEqualTo("13")
        }
    }
}
