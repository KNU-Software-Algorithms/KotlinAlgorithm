package kakao

import java.util.*
import kotlin.Comparator

class Solution {
    var map = HashMap<String, Int>()

    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        val answer = ArrayList<String>()

        for (cnt in course) {
            orders.forEach { dfs(it, "", 0, it.length, cnt, 0) }

            val keySetList = ArrayList(map.keys)
            keySetList.sortWith(Comparator { o1, o2 -> map[o2]!!.compareTo(map[o1]!!) })

            if (keySetList.size > 0) {
                val max = map[keySetList[0]]
                if (max != null) {
                    if (max >= 2) {
                        for (key in keySetList) {
                            val value = map[key]
                            if (max == value)
                                answer.add(key)
                            else
                                break
                        }
                    }
                }
            }
            map.clear()
        }
        answer.sort()
        return answer.toTypedArray()
    }

    private fun dfs(arr: String, result: String, index: Int, length: Int, cnt: Int, depth: Int) {
        if (cnt == depth) {
            val chars = result.toCharArray()
            Arrays.sort(chars)
            val key = String(chars)

            if (map.containsKey(key)) {
                map[key] = map[key]!! + 1
            } else {
                map[key] = 1
            }
            return
        }

        (index until length).forEach {
            dfs(arr, result + arr[it], it + 1, length, cnt, depth + 1)
        }
    }

//    private fun comb(arr: Array<String>, result: ArrayList<String>, index: Int, n: Int, r: Int) {
//
//        if (r == 0) {
//            var key = ""
//            result.forEach { key += it }
//
//            println(key)
//            if (map.containsKey(key)) {
//                map[key] = map[key]!! + 1
//            } else {
//                map[key] = 1
//            }
//            return
//        }
//
//        for (i in index until n) {
//            result.add(arr[i])
//            comb(arr, result, i + 1, n, r - 1)
//            result.removeAt(result.size - 1)
//        }
//
//    }
}

fun main() {
    val test = Solution().solution(arrayOf("ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"), intArrayOf(2, 3, 4))
/*    val test1 = Solution2().solution(arrayOf("ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"), intArrayOf(2, 3, 5))
    val test2 = Solution2().solution(arrayOf("XYZ", "XWY", "WXA"), intArrayOf(2, 3, 4))*/
    test.forEach {
        print("$it ")
    }
/*    println(test1)
    println(test2)*/
}