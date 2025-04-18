package lotto.domain

interface LottoNumberGenerator {
    fun generateLotto(): Lotto
    fun generateBonusNumber(exclude: List<Int>): Int
}