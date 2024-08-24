package jp.co.javainterpreter.object;

import jp.co.javainterpreter.statement.JiStatement;
import jp.co.javainterpreter.token.Token;

public class JiMethod {
    public final String name;
    public final Token returnType;

    public JiMethod(String name, Token returnType) {
        this.name = name;
        this.returnType = returnType;
    }

    public void addStatement(JiStatement statement) {
    }
}
