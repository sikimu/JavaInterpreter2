package jp.co.javainterpreter.object;

import jp.co.javainterpreter.statement.JiStatement;
import jp.co.javainterpreter.token.Token;

import java.util.ArrayList;

public class JiMethod {
    public final String name;
    public final Token returnType;

    /** ステートメントリスト */
    private final ArrayList<JiStatement> statements = new ArrayList<>();

    public JiMethod(String name, Token returnType) {
        this.name = name;
        this.returnType = returnType;
    }

    public void addStatement(JiStatement statement) {

        statements.add(statement);
    }

    public JiObject execute() {

        return statements.get(0).execute();
    }
}
