package string

class Solution0 {
    fun solution(n: Int): String {
        var answer = ""

        for (i in 1..n) {
            answer += if (i % 2 == 1)
                '수'
            else
                '박'
        }

        return answer
    }

    fun solution0(n: Int): String = String(CharArray(n) { i-> if(i%2==0) '수' else '박'})

}

fun main() {
    val answer = Solution0()
    println(answer.solution(7))
}