package naver

import java.util.LinkedList


class Solution0 {
    fun solution(k: Int): Long {
        val usedCnt = arrayListOf(6, 2, 5, 5, 4, 5, 6, 3, 7, 6)

        var answer: Long = 0

        permutation(10, 1, IntArray(10).toList() as ArrayList<Int>)
/*
        (1..22).forEach {
        }*/



        return answer
    }

    private fun permutation(n: Int, r: Int, rePerArr: ArrayList<Int>) {
        if (rePerArr.size == r) {
            for (i in rePerArr) {
                print("$i ")
            }
            println()
            return
        }

        for (i in 0 until n) {
/*            if () {

            }*/
            rePerArr.add(i)
            permutation(n, r, rePerArr)
            rePerArr.remove(rePerArr.size)
        }
    }
}

fun main() {
    val test = Solution0().solution(5)
/*
    val test0 = Solution0().solution(6)
    val test1 = Solution0().solution(11)
    val test2 = Solution0().solution(1)
*/

    println(test.toString())
/*    println(test0.toString())
    println(test1.toString())
    println(test2.toString())*/
}