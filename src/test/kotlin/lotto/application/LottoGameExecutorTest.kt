package lotto.application

import lotto.view.InputView
import lotto.view.OutputView
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGameExecutorTest {

    private val stubInputView = object : InputView {
        private val inputs = listOf(
            "2000",
            "1, 2, 3, 4, 5, 6",
            "7"
        )
        private var index = 0

        override fun readPurchaseAmount(): String = inputs[index++]
        override fun readWinningLottoNumbers(): String = inputs[index++]
        override fun readWinningBonusNumber(): String = inputs[index++]
    }

    private class CollectingOutputView : OutputView {
        val messages = mutableListOf<String>()

        override fun printPurchaseMessage() {
            messages.add("printPurchaseMessage()")
        }

        override fun printPurchasedTicketCountMessage(count: Int) {
            messages.add("Ticket Count: $count")
        }

        override fun printWinningLottoNumbersInputMessage() {
            messages.add("printWinningLottoNumbersInputMessage()")
        }

        override fun printWinningBonusNumberInputMessage() {
            messages.add("printWinningBonusNumberInputMessage()")
        }

        override fun printWinningStatisticsMessage() {
            messages.add("=== Statistics ===")
        }

        override fun printWinningResult(rankDescription: String, count: Int) {
            messages.add("$rankDescription - ${count}개")
        }
    }

    @Test
    fun `should run full lotto game flow`() {
        val outputView = CollectingOutputView()
        val executor = LottoGameExecutor(stubInputView, outputView)

        executor.run()

        assertThat(outputView.messages).contains(
            "printPurchaseMessage()",
            "Ticket Count: 2",
            "printWinningLottoNumbersInputMessage()",
            "printWinningBonusNumberInputMessage()",
            "=== Statistics ==="
        )

        val resultLine = outputView.messages.find { it.contains("개 일치") }
        assertThat(resultLine).isNotBlank()
    }
}
