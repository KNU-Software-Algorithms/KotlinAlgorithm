package me.algo.kakao.blind2021;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/09/12.
 * 문제 출처 :
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class Main_3b {
    private static final int CONDITIONS_COUNT = 5;
    private static String[][] tables;

    public int[] solution(String[] info, String[] query) {
        final int LENGTH = query.length;
        int[] answer = new int[LENGTH];

        tables = new String[info.length][CONDITIONS_COUNT];
        for (int i = 0; i < info.length; i++) {
            tables[i] = info[i].split(" ");
        }

        Stack<Integer>[] stacks = new Stack[2];
        stacks[0] = new Stack<>();
        stacks[1] = new Stack<>();

        for (int i = 0; i < LENGTH; i++) {
            String q = query[i].replaceAll(" and", "");
            StringTokenizer conditions = new StringTokenizer(q);

            for (int j = 0; j < info.length; j++) {
                stacks[0].push(j);
            }

            while (conditions.hasMoreTokens()) {
                int index = CONDITIONS_COUNT - conditions.countTokens();
                String condition = conditions.nextToken();

                int stackIndex = index % 2;
                if (condition.equals("-")) {
                    movedData(stacks[stackIndex], stacks[(stackIndex + 1) % 2]);
                    continue;
                }
                if (index < CONDITIONS_COUNT - 1) {
                    checkData(stacks[stackIndex], stacks[(stackIndex + 1) % 2], index, condition);
                } else {
                    checkData(stacks[stackIndex], stacks[(stackIndex + 1) % 2], index, Integer.parseInt(condition));
                }
            }
            answer[i] = stacks[CONDITIONS_COUNT % 2].size();
            stacks[CONDITIONS_COUNT % 2].clear();
        }
        return answer;
    }

    private void movedData(Stack<Integer> from, Stack<Integer> to) {
        while (!from.isEmpty()) {
            to.push(from.pop());
        }
    }

    private void checkData(Stack<Integer> from, Stack<Integer> to, int conditionIndex, String condition) {
        while (!from.isEmpty()) {
            int tableIndex = from.pop();
            if (!tables[tableIndex][conditionIndex].equals(condition))
                continue;
            to.push(tableIndex);
        }
    }

    private void checkData(Stack<Integer> from, Stack<Integer> to, int conditionIndex, int condition) {
        while (!from.isEmpty()) {
            int tableIndex = from.pop();
            int score = Integer.parseInt(tables[tableIndex][conditionIndex]);
            if (score < condition)
                continue;
            to.push(tableIndex);
        }
    }
}