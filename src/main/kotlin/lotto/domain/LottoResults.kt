package lotto.domain

data class LottoResultRow(val description: String, val count: Int)

class LottoResults(
    private val results: List<WinningRank>
) {
    fun statistics(): Map<WinningRank, Int> =
        results.groupingBy { it }.eachCount()

    fun totalPrize(): Long =
        results.sumOf { it.prize.toLong() }

    fun formattedStatistics(): List<LottoResultRow> =
        WinningRank.displayRanks().map { rank ->
            val count = statistics().getOrDefault(rank, 0)
            LottoResultRow(rank.toKoreanString(), count)
        }
}