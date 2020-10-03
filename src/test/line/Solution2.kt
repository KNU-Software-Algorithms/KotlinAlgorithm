package line

import java.util.*
import kotlin.collections.HashSet

class Solution2 {
    fun solution(ball: IntArray, order: IntArray): IntArray {
        var answer = arrayListOf<Int>()
        var set: Set<Int> = HashSet<Int>()

        //ball을 deque에 담기
        val balls: Deque<Int?>
        balls = ball.toCollection(ArrayDeque<Int>())

        for (idx in 0 until order.size) {
            val delete = order[idx]

            //보류리스트에 있는 아이템 삭제 가능 할 경우
            while (true){
                if (set.contains(balls.first)) {
                    answer.add(balls.pollFirst()!!)
                } else if (set.contains(balls.last)) {
                    answer.add(balls.pollLast()!!)
                }else break
            }

            if (balls.first == delete) {
                answer.add(balls.pollFirst()!!)
            } else if (balls.last == delete) {
                answer.add(balls.pollLast()!!)
            } else {
                set = set.plusElement(delete)
            }
        }

        return answer.toIntArray()
    }
}

fun main() {
    val test = Solution2().solution(intArrayOf(1, 2, 3, 4, 5, 6), intArrayOf(6, 2, 5, 1, 4, 3))
    val test1 = Solution2().solution(intArrayOf(11, 2, 9, 13, 24), intArrayOf(9, 2, 13, 24, 11))

    test.forEach {
        print("$it ")
    }
    println()

    test1.forEach {
        print("$it ")
    }
}