package jp.co.javainterpreter.token;

public class Token {

    public enum Type {
        /** class */
        CLASS,
        /** public */
        PUBLIC,
        /** void */
        VOID,
        /** int */
        INT,
        /** String */
        STRING,
        /** { */
        L_BRACE,
        /** } */
        R_BRACE,
        /** ( */
        L_PAREN,
        /** ) */
        R_PAREN,
        /** identifier */
        IDENTIFIER,
        /** semicolon */
        SEMICOLON,
        /** equal */
        EQUAL,
    }

    public final Token.Type type;
    public final String value;

    public Token(Token.Type tokenType, String string) {
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
            case "class" -> new Token(Token.Type.CLASS, string);
            case "public", "private" -> new Token(Token.Type.PUBLIC, string);
            case "int" -> new Token(Token.Type.INT, string);
            case "String" -> new Token(Token.Type.STRING, string);
            case "{" -> new Token(Token.Type.L_BRACE, string);
            case "}" -> new Token(Token.Type.R_BRACE, string);
            case "(" -> new Token(Token.Type.L_PAREN, string);
            case ")" -> new Token(Token.Type.R_PAREN, string);
            default -> new Token(Token.Type.IDENTIFIER, string);
        };
    }
}
