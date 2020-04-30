package practice

class Solution {
    fun solution(seoul: Array<String>): String {
        var cnt = 0

        seoul.iterator().forEach {
            if (it == "Kim") return "김서방은 ${cnt}에 있다"
            cnt++
        }
        return ""
    }

    fun solutionAnswer(seoul: Array<String>): String = "김서방은 ${seoul.indexOf("KIM")}에 있다"

}

fun main() {
    val answer = Solution()
    println(answer.solution(arrayOf("Jane", "Kim")))
}