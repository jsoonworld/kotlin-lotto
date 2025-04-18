package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class RandomNumberGenerator: LottoNumberGenerator {
    override fun generateLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto.of(numbers)
    }

    override fun generateBonusNumber(exclude: List<Int>): Int {
        val bonusCandidates = (1..45).toSet() - exclude.toSet()
        return bonusCandidates.random()
    }
}
