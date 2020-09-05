package queue

import java.util.*

fun main() {
    (0 until readLine()!!.toInt()).forEach {
        val (size, location) = readLine()!!.split(" ").map { it.toInt() }
        val queue: Queue<Pair<Int, Boolean>> =
            readLine()!!.split(" ").mapIndexed { index, it -> Pair(it.toInt(), location == index) }
                .toCollection(LinkedList())

        var cnt = 0
        while (queue.isNotEmpty()) {
            val (current, want) = queue.poll()

            if (queue.any { it.first > current }) {
                queue.add(Pair(current, want))
            } else {
                cnt++
                if (want) {
                    println(cnt)
                    break
                }
            }
        }
    }
}