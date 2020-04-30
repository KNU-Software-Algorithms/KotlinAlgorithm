package string

class Solution12912 {
    fun solution(a: Int, b: Int): Long {
        return when {
            a > b -> sum(b.toLong(), a.toLong())
            a == b -> a.toLong()
            else -> sum(a.toLong(), b.toLong())
        }
    }

    fun sum(start: Long, end: Long): Long {
        var sum = 0.0

        for (i in start..end) {
            sum += i
        }
        return sum.toLong()
    }
}

fun main() {
    val answer = Solution12912()
    println(answer.solution(1, 7))
    println(answer.solution(3, 3))
    println(answer.solution(5, 3))
}