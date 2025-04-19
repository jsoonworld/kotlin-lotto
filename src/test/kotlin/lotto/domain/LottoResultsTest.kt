package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class LottoResultsTest {

    @Nested
    inner class StatisticsFunction {

        @Test
        fun `should return correct count of each WinningRank`() {
            val results = listOf(
                WinningRank.FIRST,
                WinningRank.SECOND,
                WinningRank.SECOND,
                WinningRank.FIFTH,
                WinningRank.FIFTH,
                WinningRank.FIFTH
            )

            val lottoResults = LottoResults(results)
            val statistics = lottoResults.statistics()

            assertThat(statistics[WinningRank.FIRST]).isEqualTo(1)
            assertThat(statistics[WinningRank.SECOND]).isEqualTo(2)
            assertThat(statistics[WinningRank.FIFTH]).isEqualTo(3)
            assertThat(statistics[WinningRank.THIRD]).isNull()
        }
    }

    @Nested
    inner class TotalPrizeFunction {

        @Test
        fun `should return sum of all prize money`() {
            val results = listOf(
                WinningRank.FIRST,   // 2,000,000,000
                WinningRank.FIFTH,   // 5,000
                WinningRank.FIFTH    // 5,000
            )

            val lottoResults = LottoResults(results)
            val totalPrize = lottoResults.totalPrize()

            assertThat(totalPrize).isEqualTo(2_000_000_000L + 5_000L + 5_000L)
        }
    }

    @Nested
    inner class FormattedStatisticsFunction {

        @Test
        fun `should return formatted rows with Korean description and count`() {
            val results = listOf(
                WinningRank.FIFTH,
                WinningRank.FIFTH,
                WinningRank.FOURTH
            )

            val lottoResults = LottoResults(results)
            val formatted = lottoResults.formattedStatistics()

            val fifth = formatted.find { it.description.contains("3개 일치") }
            val fourth = formatted.find { it.description.contains("4개 일치") }
            val second = formatted.find { it.description.contains("보너스 볼 일치") }

            assertThat(fifth?.count).isEqualTo(2)
            assertThat(fourth?.count).isEqualTo(1)
            assertThat(second?.count).isEqualTo(0)
        }
    }
}
