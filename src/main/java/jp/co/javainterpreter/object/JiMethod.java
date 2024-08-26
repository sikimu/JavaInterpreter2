package jp.co.javainterpreter.object;

import jp.co.javainterpreter.statement.JiReturnStatement;
import jp.co.javainterpreter.statement.JiStatement;
import jp.co.javainterpreter.token.Token;

import java.util.ArrayList;
import java.util.List;

public class JiMethod {
    public final String name;
    public final Token returnType;

    /** ステートメントリスト */
    final ArrayList<JiStatement> statements = new ArrayList<>();

    public JiMethod(String name, Token returnType) {
        this.name = name;
        this.returnType = returnType;
    }

    /**
     * メソッドの作成
     * @param methodSignatureTokens メソッドシグネチャ
     * @param parameterTokens パラメータ
     * @param methodBodyTokens メソッドボディ
     * @return JiMethod
     */
    public static JiMethod create(List<Token> methodSignatureTokens, List<Token> parameterTokens, List<Token> methodBodyTokens) {

        Token returnType = methodSignatureTokens.get(0);
        String name = methodSignatureTokens.get(1).value;

        JiMethod jiMethod = new JiMethod(name, returnType);

        // メソッドのステートメントを作成する
        JiReturnStatement jiReturnStatement = new JiReturnStatement(new JiString(parameterTokens.get(1).value));
        jiMethod.addStatement(jiReturnStatement);

        return jiMethod;
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
