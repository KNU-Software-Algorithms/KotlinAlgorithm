package queue

import java.util.*

fun main(){
    val size = readLine()!!.toInt()
    val queue : Queue<Int> = LinkedList<Int>()

    (1..size).forEach { queue.add(it) }

    while(queue.size > 1){
        print("${queue.poll()} ")
        queue.add(queue.poll())
    }

    print(queue.first())
}