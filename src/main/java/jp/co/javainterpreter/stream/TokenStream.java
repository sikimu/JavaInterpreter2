package jp.co.javainterpreter.stream;

import jp.co.javainterpreter.token.Token;

public class TokenStream {

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
     * 次のトークンを取得する
     * @return トークン
     */
    public Token next() {
        position = position + calculateSkipLength(source.substring(position));
        
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

        StringBuilder word = new StringBuilder();
        for (char c : source.toCharArray()) {
            if (!Character.isWhitespace(c)) {
                word.append(c);
            } else {
                break;
            }
        }
        return word.toString();
    }

}
