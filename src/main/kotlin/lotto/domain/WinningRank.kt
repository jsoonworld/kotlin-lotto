package lotto.domain

enum class WinningRank(
    val matchCount: Int,
    val matchBonus: Boolean,
    val prize: Int
) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0);

    companion object {
        private val RANK_MAP: Map<Pair<Int, Boolean>, WinningRank> = values()
            .associateBy { it.matchCount to it.matchBonus }

        fun of(matchCount: Int, matchBonus: Boolean): WinningRank {
            return RANK_MAP[matchCount to matchBonus]
                ?: RANK_MAP[matchCount to false]
                ?: MISS
        }

        fun displayRanks(): List<WinningRank> {
            return values().filter { it != MISS }
        }
    }

    fun toKoreanString(): String {
        return when (this) {
            SECOND -> "5개 일치, 보너스 볼 일치 (${formatPrizeKorean()})"
            FIRST, THIRD, FOURTH, FIFTH -> "${matchCount}개 일치 (${formatPrizeKorean()})"
            MISS -> ""
        }
    }

    private fun formatPrizeKorean(): String = "%,d원".format(prize)
}