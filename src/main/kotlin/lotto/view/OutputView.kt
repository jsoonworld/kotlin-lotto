package lotto.view

interface OutputView {
    fun printPurchaseMessage()
    fun printPurchasedTicketCountMessage(count: Int)
    fun printWinningNumbersInputMessage()
}