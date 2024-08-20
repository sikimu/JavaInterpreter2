package jp.co.javainterpreter.token;

public class Token {

    public final TokenType type;

    public Token(TokenType tokenType) {
        this.type = tokenType;
    }

    /**
     * トークンを作成する
     * @param string
     * @return
     */
    public static Token create(String string) {

        return switch (string) {
            case "public" -> new Token(TokenType.PUBLIC);
            case "class" -> new Token(TokenType.CLASS);
            default -> null;
        };
    }
}
