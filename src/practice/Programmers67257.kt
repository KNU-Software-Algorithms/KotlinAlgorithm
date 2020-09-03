package practice

import java.time.LocalDate

class Programmers12901 {
    fun solution(a: Int, b: Int): String = LocalDate.of(2016, a,b).dayOfWeek.toString().substring(0,3)
}

fun main() {
    val test = Programmers12901().solution(5, 24)
}