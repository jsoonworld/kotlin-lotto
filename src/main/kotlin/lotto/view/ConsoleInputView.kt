package lotto.view

import camp.nextstep.edu.missionutils.Console

class ConsoleInputView: InputView {
    override fun readPurchaseAmount(): String = Console.readLine()
    override fun readWinningNumbers(): String = Console.readLine()
}