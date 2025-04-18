package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == REQUIRED_SIZE) { ERROR_INVALID_SIZE }
        require(numbers.toSet().size == REQUIRED_SIZE) { ERROR_DUPLICATE_NUMBERS }
    }

    fun numbers(): List<Int> = numbers.sorted()

    companion object {
        private const val REQUIRED_SIZE = 6
        const val ERROR_INVALID_SIZE = "[ERROR] Lotto must contain exactly 6 unique numbers."
        const val ERROR_DUPLICATE_NUMBERS = "[ERROR] Lotto numbers must not contain duplicates."
    }
}
