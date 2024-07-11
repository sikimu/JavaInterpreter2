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
