package line

import java.util.HashSet


class Solution1 {
    fun solution(boxes: Array<IntArray>): Int {
        var answer: Int = -1
        val items = HashSet<Int>()

        boxes.forEach { it ->
            var box = it[0]
            if (items.contains(box)) items.remove(box)
            else items.add(box)

            box = it[1]
            if (items.contains(box)) items.remove(box)
            else items.add(box)
        }

        answer = items.size / 2
        return answer
    }
}

fun main() {
/*    val test = Solution1().solution()

    println(test)*/
}