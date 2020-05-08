package practice

class Solution12948 {
    fun solution(phone_number: String): String =
        "********************".subSequence(0,phone_number.length-4).toString() + phone_number.subSequence(phone_number.length-4,phone_number.length).toString()

}

fun main() {
    val answer = Solution12948()
    println(answer.solution("01033334444"))
}