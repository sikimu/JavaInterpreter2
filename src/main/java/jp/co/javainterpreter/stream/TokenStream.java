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
