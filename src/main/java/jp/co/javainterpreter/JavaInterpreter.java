package jp.co.javainterpreter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaInterpreter {

    /**
     * 演算子
     */
    private static final String[] OPERATORS = {
        "+", "-", "*", "/", "%", "++", "--", "==", "!=", ">", "<", ">=", "<=", "&&", "||", "!",
        "&", "|", "^", "~", "<<", ">>", ">>>", "+=", "-=", "*=", "/=", "%=", "&=", "|=", "^=",
        "<<=", ">>=", ">>>="
    };
    /**
     * 区切り文字
     */
    private static final String[] DELIMITERS = {
        "(", ")", "{", "}", "[", "]", ".", ",", ";", ":", "=", "?", "@"
    };

    /**
     * コンストラクタ
     * @param lines Javaのコードを1行ずつ格納した配列
     */
    public JavaInterpreter(String[] lines) {
        // コマンドライン引数を解析
        if (lines == null || lines.length == 0) {
            throw new IllegalArgumentException("引数が不正です");
        }


    }

    /**
     * 演算子と区切り文字で分割する
     * @param word　文字列
     * @return 分割された文字列のリスト
     */
    public static ArrayList<String> splitByOperatorsAndDelimiters(String word) {
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> operatorsAndDelimiters = getOperatorsAndDelimiters();
        int start = 0;
        for (int i = 0; i < word.length(); i++) {
            for (String operatorOrDelimiter : operatorsAndDelimiters) {
                if (word.startsWith(operatorOrDelimiter, i)) {
                    if (start != i) {
                        list.add(word.substring(start, i));
                    }
                    list.add(operatorOrDelimiter);
                    i += operatorOrDelimiter.length() - 1;
                    start = i + 1;
                    break;
                }
            }
        }
        if (start != word.length()) {
            list.add(word.substring(start));
        }
        return list;
    }

    /**
     * 演算子と区切り文字を取得する(長い順にソート)
     * @return 演算子と区切り文字のリスト
     */
    private static ArrayList<String> getOperatorsAndDelimiters() {
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(OPERATORS));
        list.addAll(Arrays.asList(DELIMITERS));
        list.sort((a, b) -> b.length() - a.length());
        return list;
    }

    /**
     * 空白文字で分割する
     * @param word 1行の文字列
     * @return 分割された文字列のリスト
     */
    static ArrayList<String> splitByWhitespace(String word) {

        return new ArrayList<String>(List.of(word.split("[ \t\n\r]")));
    }
}
