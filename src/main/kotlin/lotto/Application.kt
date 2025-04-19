package lotto

import lotto.application.LottoGameExecutor
import lotto.view.ConsoleInputView
import lotto.view.ConsoleOutputView

fun main() {
    LottoGameExecutor(ConsoleInputView(), ConsoleOutputView()).run()
}