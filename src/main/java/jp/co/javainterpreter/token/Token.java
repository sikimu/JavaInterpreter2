package jp.co.javainterpreter.token;

public class Token {

    public final TokenType type;

    public Token(TokenType tokenType) {
        this.type = tokenType;
    }
}
