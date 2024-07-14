package jp.co.javainterpreter;

import java.util.ArrayList;

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

    public JavaInterpreter(String sourceCode) {

        sourceCode = removeMultiComment(removeSingleComment(sourceCode));

        ArrayList<String> tokenList = createTokenList(sourceCode);
    }

    /**
     * トークンリストを作成する
     */
    static ArrayList<String> createTokenList(String sourceCode) {

        ArrayList<String> tokenList = new ArrayList<>();

        for (int i = 0; i < sourceCode.length(); i++) {
            int skip = skipWhiteSpace(sourceCode, i);
            i += skip;

            if (i >= sourceCode.length()) {
                break;
            }

            char c = sourceCode.charAt(i);
            String token = switch (c) {
                case '\'' -> getCharacterLiteral(sourceCode, i);
                case '"' -> getStringLiteral(sourceCode, i);
                // 演算子
                case '+', '-', '*', '/', '%', '!', '&', '|', '^', '~', '<', '>', '=', '?', ':', '@' -> getOperator(sourceCode, i);
                default -> {
                    if (Character.isDigit(c)) {
                        yield getNumber(sourceCode, i);
                    } else {
                        yield getWord(sourceCode, i);
                    }
                }
            };
        }

        return tokenList;
    }

    /**
     * startから文字列が終わる位置までをトークンとして返す
     */
    static String getWord(String sourceCode, int start) {

        for (int i = start; i < sourceCode.length(); i++) {
            if (!Character.isJavaIdentifierPart(sourceCode.charAt(i))) {
                return sourceCode.substring(start, i);
            }
        }
        return sourceCode.substring(start);
    }

    /**
     * startから数字が終わる位置までをトークンとして返す
     */
    static String getNumber(String sourceCode, int start) {

        for (int i = start; i < sourceCode.length(); i++) {
            if (!Character.isDigit(sourceCode.charAt(i))) {
                return sourceCode.substring(start, i);
            }
        }
        return sourceCode.substring(start);
    }

    /**
     * startから演算子が終わる位置までをトークンとして返す
     */
    static String getOperator(String sourceCode, int start) {

        for (String operator : OPERATORS) {
            if (sourceCode.startsWith(operator, start)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("不正な演算子です");
    }

    /**
     * startから'で囲まれた文字列をトークンとして返す
     */
    static String getCharacterLiteral(String sourceCode, int start) {

        for (int i = start + 1; i < sourceCode.length(); i++) {
            if (sourceCode.charAt(i) == '\'') {
                return sourceCode.substring(start, i + 1);
            }
        }
        throw new IllegalArgumentException("文字列が閉じられていません");
    }

    /**
     * startから"で囲まれた文字列をトークンとして返す
     */
    static String getStringLiteral(String sourceCode, int start) {

        for (int i = start + 1; i < sourceCode.length(); i++) {
            if (sourceCode.charAt(i) == '"') {
                return sourceCode.substring(start, i + 1);
            }
        }
        throw new IllegalArgumentException("文字列が閉じられていません");
    }

    /**
     * startから空白文字をスキップして、次のトークンの開始位置までの文字数を返す
     */
    static int skipWhiteSpace(String sourceCode, int start) {
        for (int i = start; i < sourceCode.length(); i++) {
            if (!Character.isWhitespace(sourceCode.charAt(i))) {
                return i - start;
            }
        }
        return sourceCode.length() - start;
    }

    /**
     * シングルコメントの除去
     */
    static String removeSingleComment(String sourceCode) {
        return sourceCode.replaceAll("//.*", "");
    }

    /**
     * マルチコメントの除去
     */
    static String removeMultiComment(String sourceCode) {

        return sourceCode.replaceAll("/\\*[^*]*\\*+(?:[^/*][^*]*\\*+)*/", "");
    }
}
