package lotto.view

interface InputView {
    fun readPurchaseAmount(): String
    fun readWinningLottoNumbers(): String
    fun readWinningBonusNumber(): String
}