package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PurchaseAmountTest {

    @Nested
    inner class SuccessCase {

        @Test
        fun `should create PurchaseAmount when input is multiple of 1000`() {
            val amount = PurchaseAmount.from(3000)
            assertThat(amount.value).isEqualTo(3000)
        }
    }

    @Nested
    inner class FailCase {

        @Test
        fun `should throw exception when input is not multiple of 1000`() {
            val exception = assertThrows<IllegalArgumentException> {
                PurchaseAmount.from(2500)
            }

            assertThat(exception.message).isEqualTo(PurchaseAmount.ERROR_NOT_THOUSAND_UNIT)
        }
    }
}