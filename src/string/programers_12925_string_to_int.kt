package string

class Solution {
    fun solution(s: String): Int {
        val cnt = s.length

        //return s.toInt()

        return if (s[0] == '-')
            -s.slice(1 until cnt).toInt()
        else
            s.toInt()

    }
}

fun main() {
    val answer = Solution()
    println(answer.solution("-3332323"))
}