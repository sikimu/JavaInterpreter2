package jp.co.javainterpreter.stream;

import jp.co.javainterpreter.token.TokenType;

public class TokenStream{

    public static TokenType analyze(char c) {
        if (c == ' ' || c == '\n' || c == '\t') {
            return TokenType.SPACE;
        } else if (c >= '0' && c <= '9') {
            return TokenType.NUMBER;
        } else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            return TokenType.CHARACTER;
        } else if (c == '>' || c == '<' || c == '=' || c == '!' || c == '&' || c == '|' || c == '^' || c == '~') {
            return TokenType.COMPARISON_OPERATOR;
        } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%') {
            return TokenType.ARITHMETIC_OPERATOR;
        } else if (c == '(' || c == ')' || c == '[' || c == ']' || c == '{' || c == '}') {
            return TokenType.BRACKET;
        } else if (c == ',' || c == ';' || c == '.' || c == ':') {
            return TokenType.DELIMITER;
        } else if (c == '"' || c == '\'') {
            return TokenType.QUOTATION;
        }

        throw new IllegalArgumentException("Illegal character: " + c);
    }
}
