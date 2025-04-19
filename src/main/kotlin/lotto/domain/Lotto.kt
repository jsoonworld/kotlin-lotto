package lotto.domain

class Lotto private constructor(private val numbers: List<Int>) {

    init {
        require(numbers.size == REQUIRED_SIZE) { ERROR_INVALID_SIZE }
        require(numbers.toSet().size == REQUIRED_SIZE) { ERROR_DUPLICATE_NUMBERS }
    }

    fun numbers(): List<Int> = numbers

    fun match(winning: WinningNumbers): WinningRank {
        val matchCount = numbers.count { it in winning.numbers() }
        val matchBonus = winning.containsBonus(this)
        return WinningRank.of(matchCount, matchBonus)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Lotto) return false
        return this.numbers == other.numbers
    }

    override fun hashCode(): Int = numbers.hashCode()

    override fun toString(): String = numbers.toString()

    companion object {
        private const val REQUIRED_SIZE = 6
        const val ERROR_INVALID_SIZE = "[ERROR] Lotto must contain exactly 6 unique numbers."
        const val ERROR_DUPLICATE_NUMBERS = "[ERROR] Lotto numbers must not contain duplicates."

        fun of(numbers: List<Int>): Lotto = Lotto(numbers.sorted())
    }
}
