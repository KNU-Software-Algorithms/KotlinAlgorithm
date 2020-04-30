package sort

class Solution42748 {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = IntArray(commands.size) {0}
        var cnt = 0

        commands.forEach {
            answer[cnt] = array.slice(it[0]-1 until it[1]).sorted()[it[2]-1]
            cnt++
        }
        return answer
    }
}

fun main() {
    val answer = Solution42748()
    println(answer.solution(intArrayOf(1, 5, 2, 6, 3, 7, 4), arrayOf(intArrayOf(2, 5, 3),intArrayOf(4, 4, 1),intArrayOf(1, 7, 3))).toList())
}