package practice

class Solution12928 {
    fun solution(n: Int): Int {
        var answer = 0

        for (i in 1..n) {
            if (n % i == 0) {
                answer += i
            }
        }

        //answer = (1..n).filter { n % it == 0 }.sum()

        return answer
    }
}

fun main() {
    val answer = Solution12928()
    println(answer.solution(4))
}