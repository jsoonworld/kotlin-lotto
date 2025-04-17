package lotto.domain

class PurchaseAmount private constructor(private val purchaseAmount: Int) {

    init {
        require(purchaseAmount % 1000 == 0) { ERROR_NOT_THOUSAND_UNIT }
    }

    val value: Int get() = purchaseAmount

    companion object {
        const val ERROR_NOT_THOUSAND_UNIT = "[ERROR] The purchase amount must be in units of 1,000 KRW."

        fun from(amount: Int): PurchaseAmount = PurchaseAmount(amount)
    }
}
