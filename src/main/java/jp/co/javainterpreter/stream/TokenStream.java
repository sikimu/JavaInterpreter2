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

    public Token getNext() {
        String word = seekWord(position);
        position += word.length();

        return Token.create(word);
    }

    /**
     * 次の単語を取得する
     */
    private String seekWord(int position) {
        // 空白をスキップ
        while (position < source.length() && Character.isWhitespace(source.charAt(position))) {
            position++;
        }

        StringBuilder word = new StringBuilder();
        for (int i = position; i < source.length(); i++) {
            char c = source.charAt(i);
            if (!Character.isWhitespace(c)) {
            word.append(c);
            } else {
            break;
            }
        }
        return word.toString();
    }
}
