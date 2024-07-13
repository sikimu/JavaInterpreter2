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
     * 空白や改行で分割
     */
    static String[] split(String sourceCode) {
        return sourceCode.split("[\\s\\n]+");
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
