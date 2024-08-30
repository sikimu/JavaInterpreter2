package jp.co.javainterpreter.object;

import jp.co.javainterpreter.token.Token;

public class JiParameter {

    public final Token type;
    public final Token name;

    public JiParameter(Token type, Token name) {

        this.type = type;
        this.name = name;
    }
}
