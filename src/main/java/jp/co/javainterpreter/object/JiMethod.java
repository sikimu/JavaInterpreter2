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
    public ArrayList<JiParameter> parameters = new ArrayList<>();
    public ArrayList<JiStatement> methodBody = new ArrayList<>();

    public JiMethod(String name, Token returnType) {
        this.name = name;
        this.returnType = returnType;
    }

    /**
     * メソッドの作成
     * @param name メソッド名
     * @param returnType 戻り値の型
     * @param parameterTokens パラメータ
     * @param methodBodyTokens メソッドボディ
     * @return JiMethod
     */
    public static JiMethod create(String name, Token returnType, List<Token> parameterTokens, List<Token> methodBodyTokens) {

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

    public void addParameter(List<Token> parameterTokens) {

        JiParameter jiParameter = new JiParameter(parameterTokens.get(0), parameterTokens.get(1));
        parameters.add(jiParameter);
    }

    public void addMethodBody(List<Token> methodBodyTokens) {

        JiReturnStatement jiReturnStatement = new JiReturnStatement(new JiString(methodBodyTokens.get(1).value));
        methodBody.add(jiReturnStatement);
    }
}
