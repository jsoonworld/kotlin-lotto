package lotto.view

class ConsoleOutputView : OutputView{
    override fun printPurchaseMessage() {
        println(PURCHASE_AMOUNT_MESSAGE)
    }

    override fun printPurchasedTicketCountMessage(count: Int) {
        println(PURCHASED_TICKET_COUNT_MESSAGE.format(count))
    }

    override fun printWinningLottoNumbersInputMessage() {
        println(WINNING_LOTTO_NUMBERS_INPUT_MESSAGE)
    }

    override fun printWinningBonusNumberInputMessage() {
        println(WINNING_BONUS_NUMBER_INPUT_MESSAGE)
    }

    override fun printWinningStatisticsMessage() {
        println(WINNING_STATISTICS_MESSAGE)
    }

    override fun printWinningResult(rankDescription: String, count: Int) {
        println("$rankDescription - ${count}개")
    }

    companion object {
        const val PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요."
        const val PURCHASED_TICKET_COUNT_MESSAGE = "%d개를 구매했습니다."
        const val WINNING_LOTTO_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요."
        const val WINNING_BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요."
        const val WINNING_STATISTICS_MESSAGE = "당첨 통계\n---"
        const val TOTAL_YIELD_MESSAGE = "총 수익률은 %.1f%%입니다."
    }
}