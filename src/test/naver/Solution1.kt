package naver

import kotlin.math.roundToInt

class Solution1 {
    fun solution(n: Int, p: IntArray, c: IntArray): String {
        var answer: String = ""

        var day = 0
        var lastDay = 0
        val price = intArrayOf(100, 50, 25)
        val remain = arrayListOf(0)

        var total = 0.00

        for (idx in 0 until n) {
            val pItem = p[idx]
            if (pItem + remain[idx] < c[idx]) {
                //생산 불가능

                if (day == 2) {
                    lastDay = idx + 1
                    break
                }

                remain.add(pItem + remain[idx])
                day++
            } else {
                //생산 가능

                remain.add((pItem + remain[idx]) - c[idx])
                total += c[idx] * price[day]
                day = 0

                lastDay = idx + 1
            }

        }
        answer = String.format("%.2f", total / lastDay)
        println(((total / lastDay) * 100).roundToInt())
        answer = (((total / lastDay) * 100).roundToInt() / 100f).toString()
        println(answer)

        return answer
    }
}

fun main() {
    val test = Solution1().solution(6, intArrayOf(5, 4, 7, 2, 0, 6), intArrayOf(4, 6, 4, 9, 2, 3))
    val test0 = Solution1().solution(7, intArrayOf(6, 2, 1, 0, 2, 4, 3), intArrayOf(3, 6, 6, 2, 3, 7, 6))

//    val test1 = Solution1().solution(3,1)

    println(test.toString())
    println()
    println(test0.toString())
//    println(test1.toString())
}