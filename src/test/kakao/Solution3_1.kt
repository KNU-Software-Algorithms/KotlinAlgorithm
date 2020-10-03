/*
package me.algo.kakao.blind2021

import java.util.Stack
import java.util.StringTokenizer

*/
/**
 * Created by Bomi on 2020/09/12.
 * 문제 출처 :
 *
 *
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 *//*


class Main_3b {

    fun solution(info: Array<String>, query: Array<String>): IntArray {
        val LENGTH = query.size
        val answer = IntArray(LENGTH)

        tables = Array(info.size) { arrayOfNulls<>(CONDITIONS_COUNT) }
        for (i in info.indices) {
            tables[i] = info[i].split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        }

        val stacks = arrayOfNulls<Stack<*>>(2)
        stacks[0] = Stack<Int>()
        stacks[1] = Stack<Int>()

        for (i in 0 until LENGTH) {
            val q = query[i].replace(" and".toRegex(), "")
            val conditions = StringTokenizer(q)

            for (j in info.indices) {
                stacks[0].push(j)
            }

            while (conditions.hasMoreTokens()) {
                val index = CONDITIONS_COUNT - conditions.countTokens()
                val condition = conditions.nextToken()

                val stackIndex = index % 2
                if (condition == "-") {
                    movedData(stacks[stackIndex], stacks[(stackIndex + 1) % 2])
                    continue
                }
                if (index < CONDITIONS_COUNT - 1) {
                    checkData(stacks[stackIndex], stacks[(stackIndex + 1) % 2], index, condition)
                } else {
                    checkData(stacks[stackIndex], stacks[(stackIndex + 1) % 2], index, Integer.parseInt(condition))
                }
            }
            answer[i] = stacks[CONDITIONS_COUNT % 2].size
            stacks[CONDITIONS_COUNT % 2].clear()
        }
        return answer
    }

    private fun movedData(from: Stack<Int>, to: Stack<Int>) {
        while (!from.isEmpty()) {
            to.push(from.pop())
        }
    }

    private fun checkData(from: Stack<Int>, to: Stack<Int>, conditionIndex: Int, condition: String) {
        while (!from.isEmpty()) {
            val tableIndex = from.pop()
            if (tables!![tableIndex][conditionIndex] != condition)
                continue
            to.push(tableIndex)
        }
    }

    private fun checkData(from: Stack<Int>, to: Stack<Int>, conditionIndex: Int, condition: Int) {
        while (!from.isEmpty()) {
            val tableIndex = from.pop()
            val score = Integer.parseInt(tables!![tableIndex][conditionIndex])
            if (score < condition)
                continue
            to.push(tableIndex)
        }
    }

    companion object {
        private val CONDITIONS_COUNT = 5
        private var tables: Array<Array<String>>? = null
    }
}*/
