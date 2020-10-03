package brute_forse

class Programmers42842 {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = intArrayOf(0, 0)
        val sum = brown + yellow


        (3..sum / 3).filter { sum % it == 0 }.forEach { n ->
            val m = sum / n
            val expression = (n - 2) * (m - 2)

            if (expression == yellow) {
                answer[0] = n
                answer[1] = m
            }
        }
        return answer

/*        return (3..sum / 3).filter { sum % it == 0 }
            .first { (it - 2) * (sum / it - 2) == yellow }
            .let { intArrayOf(it, sum / it) }*/
    }
}

fun main() {
    println(Programmers42842().solution(10, 2).toList())
    println(Programmers42842().solution(8, 1).toList())
    println(Programmers42842().solution(24, 24).toList())
}