package jp.co.javainterpreter;

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
