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

    companion object {
        const val PURCHASE_AMOUNT_MESSAGE = "Please enter the purchase amount."
        const val PURCHASED_TICKET_COUNT_MESSAGE = "You have purchased %d tickets."
        const val WINNING_LOTTO_NUMBERS_INPUT_MESSAGE = "Please enter the winning numbers."
        const val WINNING_BONUS_NUMBER_INPUT_MESSAGE = "Please enter the bonus number."
    }
}