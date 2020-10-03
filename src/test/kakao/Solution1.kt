package kakao

class Solution1 {
    fun solution(new_id: String): String {
        var answer: String = ""

        // step1
        answer = new_id.toLowerCase()

        // step2
        var reg = Regex("[^a-z0-9._-]")
        answer = answer.replace(reg, "")

        // step3
        reg = Regex("\\.+")
        answer = answer.replace(reg, ".")

        // step4
        reg = Regex("\\.$")
        answer = answer.replace(reg, "")

        reg = Regex("^\\.")
        answer = answer.replace(reg, "")

        // step5
        if (answer.isEmpty()) answer = "a"

        // step6
        if (answer.length > 15)
            answer = answer.substring(0, 15)

        reg = Regex("\\.$")
        answer = answer.replace(reg, "")

        // step7
        if (answer.length < 3) {
            val last = answer.last()
            (answer.length until 3).forEach { _ ->
                answer += last
            }
        }
            return answer
    }
}

fun main() {
    val test = Solution1().solution("...!@BaT#*..y.abcdefghijklm")
    val test1 = Solution1().solution("z-+.^.")
    val test2 = Solution1().solution("=.=")
    val test3 = Solution1().solution("123_.def")
    val test4 = Solution1().solution("abcdefghijklmn.p")

    println(test)
    println(test1)
    println(test2)
    println(test3)
    println(test4)
}