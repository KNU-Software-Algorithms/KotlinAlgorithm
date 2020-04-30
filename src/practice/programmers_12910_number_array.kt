package practice

class Solution12910 {
    fun solution(arr: IntArray, divisor: Int): IntArray {
        var answer = arrayListOf<Int>()

        arr.forEach {
            if ((it % divisor) == 0) answer.add(it)
        }
        if (answer.size == 0) answer.add(-1)

        return answer.sorted().toIntArray()
    }
}

fun main() {
    val answer = Solution12910()
    println(answer.solution(intArrayOf(5, 9, 7, 10), 5))
}