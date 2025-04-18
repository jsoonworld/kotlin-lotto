package lotto.view

import camp.nextstep.edu.missionutils.Console

class ConsoleInputView: InputView {
    override fun readPurchaseAmount(): String = Console.readLine()
    override fun readWinningLottoNumbers(): String = Console.readLine()
    override fun readWinningBonusNumber(): String = Console.readLine()
}