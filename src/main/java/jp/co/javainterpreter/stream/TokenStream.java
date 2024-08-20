package jp.co.javainterpreter.stream;

import jp.co.javainterpreter.token.Token;
import jp.co.javainterpreter.token.TokenType;

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

        return switch (word) {
            case "public" -> new Token(TokenType.PUBLIC);
            case "class" -> new Token(TokenType.CLASS);
            default -> null;
        };
    }

    /**
     * 次の単語を取得する
     */
    private String seekWord(int position) {
        StringBuilder word = new StringBuilder();
        for (int i = position; i < source.length(); i++) {
            char c = source.charAt(i);
            if (c == ' ') {
                break;
            }
            word.append(c);
        }
        return word.toString();
    }
}
