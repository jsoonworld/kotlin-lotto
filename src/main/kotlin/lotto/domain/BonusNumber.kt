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
        fun of(bonus: Int): BonusNumber {
            return BonusNumber(bonus)
        }
    }
}