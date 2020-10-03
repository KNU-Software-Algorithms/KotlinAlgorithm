package kakao


class Solution2 {
    val map = HashMap<String, Int>()

    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        var answer: ArrayList<String> = arrayListOf()

        var arr: ArrayList<String> = arrayListOf()
        orders.forEach { item ->
            arr.clear()
            item.split("").toTypedArray().forEach {
                if (it.isNotEmpty()) arr.add(it)
            }

            for (i in 0 until course.size) {
                if (course[i] > arr.size) continue
                println(course[i])
                comb(arr.toList().toTypedArray(), arrayListOf(), 0, arr.size, course[i])
                println()
            }
        }

        map.forEach { t, u ->
            if (u > 1){
                answer.add(t)
            }
        }

        answer.forEach {
            println(it)
        }

        return answer.toList().toTypedArray()
    }

    private fun comb(arr: Array<String>, result: ArrayList<String>, index: Int, n: Int, r: Int) {

        if (r == 0) {
            var key = ""
            result.forEach { key += it }

            println(key)
            if (map.containsKey(key)) {
                map[key] = map[key]!! + 1
            } else {
                map[key] = 1
            }
            return
        }

        for (i in index until n) {
            result.add(arr[i])
            comb(arr, result, i + 1, n, r - 1)
            result.removeAt(result.size - 1)
        }

    }
}

fun main() {
    val test = Solution2().solution(arrayOf("ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"), intArrayOf(2, 3, 4))
/*    val test1 = Solution2().solution(arrayOf("ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"), intArrayOf(2, 3, 5))
    val test2 = Solution2().solution(arrayOf("XYZ", "XWY", "WXA"), intArrayOf(2, 3, 4))*/

    println(test)
/*    println(test1)
    println(test2)*/
}