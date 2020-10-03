package brute_forse

class Programmers12951 {
    fun solution(s: String): String {
        var answer = ""
        val sentence = s.toLowerCase()
        sentence.split(" ").forEach { word ->
            answer += " " + word[0].toUpperCase() + word.substring(1)
        }
        return answer.substring(1)
    }
}

fun main() {
    val test = Programmers12951().solution("3people unFollowed me")
    println(test.toString())
}