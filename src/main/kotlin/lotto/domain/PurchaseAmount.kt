package lotto.domain

class PurchaseAmount private constructor(private val purchaseAmount: Int) {

    init {
        require(purchaseAmount % TICKET_PRICE == 0) { ERROR_NOT_THOUSAND_UNIT }
    }

    val value: Int get() = purchaseAmount

    fun toTicketCount(): Int = purchaseAmount / TICKET_PRICE

    companion object {
        private const val TICKET_PRICE = 1000
        const val ERROR_NOT_THOUSAND_UNIT = "[ERROR] The purchase amount must be in units of 1,000 KRW."

        fun from(amount: Int): PurchaseAmount = PurchaseAmount(amount)
    }
}
