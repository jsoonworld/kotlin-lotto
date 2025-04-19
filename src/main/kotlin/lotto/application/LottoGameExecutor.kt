package lotto.application

import lotto.domain.*
import lotto.parser.DefaultLottoInputParser
import lotto.util.runCatchingRepeatedly
import lotto.view.ConsoleOutputView
import lotto.view.InputView
import lotto.view.OutputView

class LottoGameExecutor(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun run() {
        val purchaseAmount = requestPurchaseAmount()
        val lottos = generateLottos(purchaseAmount.toTicketCount())
        printLottos(lottos)

        val winningLotto = requestWinningLotto()
        val inputParser = DefaultLottoInputParser { winningLotto }
        val winningBonusNumber = requestBonusNumber(inputParser)
        val winningNumbers = WinningNumbers.of(winningLotto, winningBonusNumber)

        val lottoResults = evaluateResults(lottos, winningNumbers)
        printResults(lottoResults, purchaseAmount)
    }

    private fun requestPurchaseAmount(): PurchaseAmount {
        return runCatchingRepeatedly {
            outputView.printPurchaseMessage()
            DefaultLottoInputParser { Lotto.of(emptyList()) }.parsePurchaseAmount(inputView.readPurchaseAmount())
        }
    }

    private fun generateLottos(ticketCount: Int): List<Lotto> {
        outputView.printPurchasedTicketCountMessage(ticketCount)
        val generator = RandomNumberGenerator()
        return List(ticketCount) { generator.generateLotto() }
    }

    private fun printLottos(lottos: List<Lotto>) {
        lottos.forEach { println(it.numbers()) }
        println()
    }

    private fun requestWinningLotto(): Lotto {
        return runCatchingRepeatedly {
            outputView.printWinningLottoNumbersInputMessage()
            DefaultLottoInputParser { Lotto.of(emptyList()) }.parseWinningLotto(inputView.readWinningLottoNumbers())
        }
    }

    private fun requestBonusNumber(parser: DefaultLottoInputParser): BonusNumber {
        return runCatchingRepeatedly {
            outputView.printWinningBonusNumberInputMessage()
            parser.parseBonusNumber(inputView.readWinningBonusNumber())
        }
    }

    private fun evaluateResults(lottos: List<Lotto>, winningNumbers: WinningNumbers): LottoResults {
        val results = lottos.map { it.match(winningNumbers) }
        return LottoResults(results)
    }

    private fun printResults(lottoResults: LottoResults, purchaseAmount: PurchaseAmount) {
        outputView.printWinningStatisticsMessage()
        lottoResults.formattedStatistics().forEach {
            outputView.printWinningResult(it.description, it.count)
        }
        printYield(lottoResults, purchaseAmount)
    }

    private fun printYield(lottoResults: LottoResults, purchaseAmount: PurchaseAmount) {
        val totalPrize = lottoResults.totalPrize()
        val yieldRate = totalPrize.toDouble() / purchaseAmount.value * 100
        println(ConsoleOutputView.TOTAL_YIELD_MESSAGE.format(yieldRate))
    }
}