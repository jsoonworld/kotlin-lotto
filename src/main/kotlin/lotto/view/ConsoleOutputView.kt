package lotto.view

class ConsoleOutputView : OutputView{
    override fun printPurchaseMessage() {
        println(PURCHASE_AMOUNT_MESSAGE)
    }

    override fun printPurchasedTicketCountMessage(count: Int) {
        println(PURCHASED_TICKET_COUNT_MESSAGE.format(count))
    }

    companion object {
        const val PURCHASE_AMOUNT_MESSAGE = "Please enter the purchase amount."
        const val PURCHASED_TICKET_COUNT_MESSAGE = "You have purchased %d tickets."
    }
}