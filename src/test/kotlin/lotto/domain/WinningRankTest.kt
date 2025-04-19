package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class WinningRankTest {

    @Nested
    inner class OfFunction {

        @Test
        fun `should return FIRST for 6 matches`() {
            val result = WinningRank.of(6, false)
            assertThat(result).isEqualTo(WinningRank.FIRST)
        }

        @Test
        fun `should return SECOND for 5 matches with bonus`() {
            val result = WinningRank.of(5, true)
            assertThat(result).isEqualTo(WinningRank.SECOND)
        }

        @Test
        fun `should return THIRD for 5 matches without bonus`() {
            val result = WinningRank.of(5, false)
            assertThat(result).isEqualTo(WinningRank.THIRD)
        }

        @Test
        fun `should return MISS for 2 or fewer matches`() {
            val result = WinningRank.of(2, false)
            assertThat(result).isEqualTo(WinningRank.MISS)
        }
    }

    @Nested
    inner class DisplayRanksFunction {

        @Test
        fun `should not include MISS in displayRanks`() {
            val displayRanks = WinningRank.displayRanks()
            assertThat(displayRanks).doesNotContain(WinningRank.MISS)
        }

        @Test
        fun `should include all ranks except MISS`() {
            val expectedRanks = listOf(
                WinningRank.FIRST,
                WinningRank.SECOND,
                WinningRank.THIRD,
                WinningRank.FOURTH,
                WinningRank.FIFTH
            )
            assertThat(WinningRank.displayRanks()).containsExactlyElementsOf(expectedRanks)
        }
    }

    @Nested
    inner class ToKoreanString {

        @Test
        fun `should format SECOND correctly`() {
            assertThat(WinningRank.SECOND.toKoreanString())
                .isEqualTo("5개 일치, 보너스 볼 일치 (30,000,000원)")
        }

        @Test
        fun `should format FIRST correctly`() {
            assertThat(WinningRank.FIRST.toKoreanString())
                .isEqualTo("6개 일치 (2,000,000,000원)")
        }

        @Test
        fun `should return empty string for MISS`() {
            assertThat(WinningRank.MISS.toKoreanString()).isEqualTo("")
        }
    }
}
