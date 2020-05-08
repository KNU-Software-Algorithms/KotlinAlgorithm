package practice

class Solution12917 {
    fun solution(s: String) : String = s.toList().sorted().reversed().joinToString("")
}

fun main() {
    val answer = Solution12917()
    println(answer.solution("ZbcdWRWWefag"))
}