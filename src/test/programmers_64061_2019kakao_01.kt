package test

import java.util.*
import kotlin.collections.ArrayList

class Solution01 {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        val stack = arrayListOf<Int>()

        moves.forEach {
            for (i in 0 until board.size) {
                if (board[i][it - 1] == 0)
                    continue
                else {
                    stack.add(board[i][it - 1])
                    board[i][it - 1] = 0
                    break
                }
            }
        }

        return stack.size - pop(stack).size
    }

    private fun pop(stack: ArrayList<Int>): ArrayList<Int> {
        for (i in 0 until stack.size) {

            if ( stack.size <= i)
                return stack

            if (i == 0)
                continue

            if (stack[i - 1] == stack[i]) {
                stack.removeAt(i)
                stack.removeAt(i-1)
                pop(stack)
            }
        }
        return stack
    }

/*    fun testQueue(){
        var test = Queue

    }*/
}

fun main() {
    val answer = Solution01()
    println(
        answer.solution(
            arrayOf(
                intArrayOf(0, 0, 0, 0, 0),
                intArrayOf(0, 0, 1, 0, 3),
                intArrayOf(0, 2, 5, 0, 1),
                intArrayOf(4, 2, 4, 4, 2),
                intArrayOf(3, 5, 1, 3, 1)
            ), intArrayOf(1, 5, 3, 5, 1, 2, 1, 4)
        )
    )
}