package jp.co.javainterpreter.token;

public class Token {

    public final TokenType type;
    public final String value;

    public Token(TokenType tokenType, String string) {
        this.type = tokenType;
        this.value = string;
    }

    /**
     * トークンを作成する
     * @param string 文字列
     * @return トークン
     */
    public static Token create(String string) {

        return switch (string) {
            case "class" -> new Token(TokenType.CLASS, string);
            case "public", "private" -> new Token(TokenType.PUBLIC, string);
            case "{" -> new Token(TokenType.L_BRACE, string);
            case "}" -> new Token(TokenType.R_BRACE, string);
            default -> new Token(TokenType.IDENTIFIER, string);
        };
    }
}
