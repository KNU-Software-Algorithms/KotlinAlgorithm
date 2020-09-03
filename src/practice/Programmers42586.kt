package practice

class Programmers42586 {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val answer = arrayListOf<Int>()
        val dayList = Array(progresses.size) { 0 }
        var day = 0

        while (dayList.contains(0)) {
            day++
            for (i in 0 until progresses.size) {
                if (progresses[i] >= 100) continue

                progresses[i] += speeds[i]

                if (progresses[i] >= 100) dayList[i] = day
            }
        }

        var max = 0
        dayList.forEach {
            if (max < it) {
                answer.add(1)
                max = it
            } else answer[answer.size - 1] += 1
        }

        return answer.toIntArray()
    }
}

fun main() {
    val test = Programmers42586().solution(intArrayOf(95, 90, 99, 99, 80, 99), intArrayOf(1, 1, 1, 1, 1, 1))
}