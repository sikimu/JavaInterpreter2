package jp.co.javainterpreter.stream;

import jp.co.javainterpreter.token.Token;
import jp.co.javainterpreter.token.TokenType;

public class TokenStream{

    private final String source;

    public TokenStream(String source) {
        this.source = source;
    }

    public Token getNext() {

        return switch (source) {
            case "public" -> new Token(TokenType.PUBLIC);
            default -> null;
        };
    }
}
