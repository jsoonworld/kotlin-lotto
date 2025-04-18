package lotto.domain

class BonusNumber private constructor(private val bonusNumber: Int) {

    val value: Int get() = bonusNumber

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BonusNumber) return false
        return bonusNumber == other.bonusNumber
    }

    override fun hashCode(): Int = bonusNumber

    override fun toString(): String = bonusNumber.toString()

    companion object {
        const val ERROR_DUPLICATE_WITH_LOTTO = "[ERROR] Bonus number must not duplicate with lotto numbers."

        fun of(bonus: Int, lotto: Lotto): BonusNumber {
            require(bonus !in lotto.numbers()) { ERROR_DUPLICATE_WITH_LOTTO }
            return BonusNumber(bonus)
        }
    }
}
