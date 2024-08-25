package jp.co.javainterpreter.object;

import jp.co.javainterpreter.statement.JiStatement;
import jp.co.javainterpreter.stream.TokenStream;
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

    /**
     * メソッド作成
     */
    public static JiMethod create(String name, Token returnType,TokenStream tokenStream) {

        JiMethod method = new JiMethod(name, returnType);

        return method;
    }

    /**
     * ステートメントを追加する
     * @param statement
     */
    public void addStatement(JiStatement statement) {

        statements.add(statement);
    }

    public JiObject execute() {

        return statements.get(0).execute();
    }
}
