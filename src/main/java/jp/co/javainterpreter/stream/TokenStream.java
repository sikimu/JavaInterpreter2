package jp.co.javainterpreter.stream;

import jp.co.javainterpreter.token.Token;

public class TokenStream {

    /**
     * 演算子や括弧や区切り文字
     * 文字数が長いものから順に並べる
     */
    final static String[] SYMBOLS = new String[] { ">>>=", ">>=", "<<=", "==", "!=", "<=", ">=", "&&", "||", "++", "--", "+=", "-=", "*=", "/=", "&=", "|=", "^=", "%=", "<<", ">>", ">", "<", "=", "!", "~", "?", ":", "+", "-", "*", "/", "&", "|", "^", "%", "(", ")", "[", "]", "{", "}", ",", ";", "." };

    /**
     * 現在の位置
     */
    int position = 0;

    private final String source;

    public TokenStream(String source) {
        this.source = source;
    }

    /**
     * スキップできる文字数を返す
     * @param source 入力文字列
     * @return スキップできる文字数
     */
    static int calculateSkipLength(String source) {

        int length = 0;

        while(length < source.length()){
            if(Character.isWhitespace(source.charAt(length))){
                length++;
            } else if(length < source.length() - 1 && source.charAt(length) == '/' && source.charAt(length + 1) == '/'){
                while (length < source.length() && source.charAt(length) != '\n') {
                    length++;
                }
            } else if(length < source.length() - 1 && source.charAt(length) == '/' && source.charAt(length + 1) == '*'){
                while (length < source.length() - 1 && !(source.charAt(length) == '*' && source.charAt(length + 1) == '/')) {
                    length++;
                }
                length += 2;
            } else {
                break;
            }
        }

        return length;
    }

    /**
     * 数字を取得する
     * @param number 数字
     * @return 数字
     */
    static String seekNumber(String number) {

        // 数字には小数点や指数表記やLなどが含まれる
        StringBuilder word = new StringBuilder();
        for (char c : number.toCharArray()) {
            if (Character.isDigit(c) || c == '.' || c == 'e' || c == 'E' || c == 'f' || c == 'd' || c == 'l' || c == 'L') {
                word.append(c);
            } else {
                break;
            }
        }

        return word.toString();
    }

    /**
     * 演算子や括弧や区切り文字を取得する
     * @param source 入力文字列
     * @return 演算子
     */
    public static String seekSymbol(String source) {

        for (String operator : SYMBOLS) {
            if (source.startsWith(operator)) {
                return operator;
            }
        }

        return "";
    }

    public static String seekString(String source) {

        StringBuilder word = new StringBuilder();
        for (char c : source.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(c);
            } else {
                break;
            }
        }

        return word.toString();
    }

    /**
     * 次のトークンを取得する
     * @return トークン
     */
    public Token next() {
        position = position + calculateSkipLength(source.substring(position));

        if(position >= source.length()){
            throw new RuntimeException("No more token");
        }

        String word = seekWord(source.substring(position));
        position = position + word.length();

        return Token.create(word);
    }

    /**
     * 次の単語を取得する
     *
     * @param source 入力文字列
     * @return 単語
     */
    static String seekWord(String source) {

        // 演算子の場合
        if(isSymbol(source)){
            return seekSymbol(source);
        } else if(Character.isDigit(source.charAt(0))){
            return seekNumber(source);
        } else {
            return seekString(source);
        }
    }

    /**
     * 演算子や括弧や区切り文字で始まるかどうか
     * @param source 入力文字列
     * @return 演算子や括弧や区切り文字かどうか
     */
    public static boolean isSymbol(String source){
        for (String operator : SYMBOLS) {
            if (source.startsWith(operator)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasNext() {

        position = position + calculateSkipLength(source.substring(position));
        return position < source.length();
    }
}
