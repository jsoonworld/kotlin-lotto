package lotto.view

interface OutputView {
    fun printPurchaseMessage()
    fun printPurchasedTicketCountMessage(count: Int)
    fun printWinningLottoNumbersInputMessage()
    fun printWinningBonusNumberInputMessage()
    fun printWinningStatisticsMessage()
    fun printWinningResult(rankDescription: String, count: Int)
}