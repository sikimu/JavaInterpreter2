package jp.co.javainterpreter;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 式
 */
public class JiExpression {

    private final String[] elements;

    public JiExpression(String... elements) {
        this.elements = elements;
    }

    public int calculate() {

        ArrayList<String> elementList = new ArrayList<>();
        Collections.addAll(elementList, elements);

        calculate(elementList);

        return Integer.parseInt(elementList.getFirst());
    }

    private static void calculate(ArrayList<String> elementList){

        bucketSort(elementList);
        multiplyAndDivide(elementList);
        addAndSubtract(elementList);
    }

    static void bucketSort(ArrayList<String> elementList) {
        // 括弧を計算
        while (elementList.contains("(")) {
            int start = elementList.indexOf("(");
            int end = elementList.indexOf(")");
            ArrayList<String> subList = new ArrayList<>(elementList.subList(start + 1, end));
            calculate(subList);
            elementList.subList(start, end).clear();
            elementList.set(start, subList.getFirst());
        }
    }

    static void multiplyAndDivide(ArrayList<String> elementList) {
        // *と/を計算
        for (int i = 0; i < elementList.size(); i++) {
            if (elementList.get(i).equals("*")) {
                int result = Integer.parseInt(elementList.get(i - 1)) * Integer.parseInt(elementList.get(i + 1));
                elementList.set(i - 1, String.valueOf(result));
                elementList.remove(i);
                elementList.remove(i);
                i--;
            } else if (elementList.get(i).equals("/")) {
                int result = Integer.parseInt(elementList.get(i - 1)) / Integer.parseInt(elementList.get(i + 1));
                elementList.set(i - 1, String.valueOf(result));
                elementList.remove(i);
                elementList.remove(i);
                i--;
            }
        }
    }

    static void addAndSubtract(ArrayList<String> elementList) {
        // +と-を計算
        for (int i = 0; i < elementList.size(); i++) {
            if (elementList.get(i).equals("+")) {
                int result = Integer.parseInt(elementList.get(i - 1)) + Integer.parseInt(elementList.get(i + 1));
                elementList.set(i - 1, String.valueOf(result));
                elementList.remove(i);
                elementList.remove(i);
                i--;
            } else if (elementList.get(i).equals("-")) {
                int result = Integer.parseInt(elementList.get(i - 1)) - Integer.parseInt(elementList.get(i + 1));
                elementList.set(i - 1, String.valueOf(result));
                elementList.remove(i);
                elementList.remove(i);
                i--;
            }
        }
    }
}
