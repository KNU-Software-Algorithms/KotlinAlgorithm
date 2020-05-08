package practice

class Solution12932 {
    fun solution(n: Long): IntArray {
        val answer = ArrayList<Int>()

        n.toString().forEach{
            answer.add(it.toInt() - 48)
        }

        return answer.reversed().toIntArray()
    }
}

fun main() {
    val answer = Solution12932()
    println(answer.solution(118372).toList())
}