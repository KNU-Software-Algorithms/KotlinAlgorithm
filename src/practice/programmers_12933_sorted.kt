package practice

class Solution12933 {
    fun solution(n: Long): Long {
        var temp = arrayListOf<Char>()
        var answer = ""

        n.toString().forEach {
            temp.add(it)
        }
        temp.sorted().reversed().forEach {
            answer += it
        }

        return answer.toLong()
    }
}

fun main() {
    val answer = Solution12933()
    println(answer.solution(118372))
}