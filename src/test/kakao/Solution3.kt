package kakao

class Solution3 {
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        val size = query.size
        val answer = IntArray(size) { 0 }

        for (i in 0 until size) {
            val (languageQuery, positionQuery, careerQuery, foodQuery, scoreQuery) = query[i].split(" and ", " ")
            val scoreQueryInt = scoreQuery.toInt()

            info.forEach {
                val (language, position, career, food, score) = it.split(" ")
                val scoreInt = score.toInt()

                if (isValid(languageQuery, language)
                    && isValid(positionQuery, position)
                    && isValid(careerQuery, career)
                    && isValid(foodQuery, food)
                    && scoreQueryInt <= scoreInt
                ) answer[i]++
            }
        }
        return answer
    }

    private fun isValid(query: String, data: String): Boolean = query == "-" || query == data

}

fun main() {
    val test = Solution3().solution(
        arrayOf(
            "java backend junior pizza 150",
            "python frontend senior chicken 210",
            "python frontend senior chicken 150",
            "cpp backend senior pizza 260",
            "java backend junior chicken 80",
            "python backend senior chicken 50"
        ),
        arrayOf(
            "java and backend and junior and pizza 100",
            "python and frontend and senior and chicken 200",
            "cpp and - and senior and pizza 250",
            "- and backend and senior and - 150",
            "- and - and - and chicken 100",
            "- and - and - and - 150"
        )
    )

    test.forEach {
        print(it)
    }
}