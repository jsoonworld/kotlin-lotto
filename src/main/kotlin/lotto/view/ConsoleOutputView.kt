package lotto.view

class ConsoleOutputView : OutputView{
    override fun printPurchasePrompt() {
        println(PURCHASE_AMOUNT_PROMPT)
    }

    companion object {
        const val PURCHASE_AMOUNT_PROMPT = "Please enter the purchase amount."
    }
}