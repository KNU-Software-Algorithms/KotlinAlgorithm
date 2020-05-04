package practice

class Solution12918 {
    fun solution(s: String): Boolean {
        return try {
            s.toInt()
            (s.length == 4) || (s.length == 6)
        } catch (e: NumberFormatException) {
            false
        }
    }
}

fun main() {
    val answer = Solution12918()
    println(answer.solution("a234"))
    println(answer.solution("1234"))
    println(answer.solution("12345"))
    println(answer.solution("123456"))
    println(answer.solution("1a3456"))
}