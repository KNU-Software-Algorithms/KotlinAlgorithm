package string

class Solution12925 {
    fun solution(s: String): String {
        var cnt = (s.length)/2
        return if ((s.length) % 2 == 1)
            s[cnt].toString()
        else
            s.slice(cnt-1..cnt)
    }

    fun solution0(s: String) = s.slice(((s.length - 1) / 2)..(s.length / 2))

}

fun main() {
    val answer = Solution12925()
    println(answer.solution("qwer"))
    println(answer.solution("abcde"))
}