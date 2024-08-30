package jp.co.javainterpreter.object;

import jp.co.javainterpreter.statement.JiReturnStatement;
import jp.co.javainterpreter.token.Token;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JiMethodTest {

    @Test
    void testメソッド作成成功(){

        Token returnType = Token.create("int");
        JiMethod jiMethod = new JiMethod("test", returnType);

        assertEquals("test", jiMethod.name);
        assertEquals(Token.Type.INT, jiMethod.returnType.type);
    }

    @Test
    void test引数設定成功(){

        Token returnType = Token.create("int");
        JiMethod jiMethod = new JiMethod("test", returnType);

        List<Token> parameterTokens = new ArrayList<>();
        parameterTokens.add(Token.create("int"));
        parameterTokens.add(Token.create("i"));

        jiMethod.addParameter(parameterTokens);

        assertEquals(1, jiMethod.parameters.size());
    }

    @Test
    void testメソッドボディ設定成功(){

        Token returnType = Token.create("int");
        JiMethod jiMethod = new JiMethod("test", returnType);

        List<Token> methodBodyTokens = new ArrayList<>();
        methodBodyTokens.add(Token.create("return"));
        methodBodyTokens.add(Token.create("1"));
        methodBodyTokens.add(Token.create(";"));

        jiMethod.addMethodBody(methodBodyTokens);

        assertEquals(1, jiMethod.methodBody.size());
    }

    @Test
    void test旧メソッド作成成功(){

        Token returnType = Token.create("int");

        List<Token> parameterTokens = new ArrayList<>();
        parameterTokens.add(Token.create("int"));
        parameterTokens.add(Token.create("i"));

        List<Token> methodBodyTokens = new ArrayList<>();
        methodBodyTokens.add(Token.create("return"));
        methodBodyTokens.add(Token.create("1"));
        methodBodyTokens.add(Token.create(";"));

        JiMethod jiMethod = JiMethod.create("test", returnType, parameterTokens, methodBodyTokens);

        assertEquals("test", jiMethod.name);
        assertEquals(Token.Type.INT, jiMethod.returnType.type);
        // メソッドのステートメントが正しく作成されているか確認
        assertEquals(1, jiMethod.statements.size());
        assertInstanceOf(JiReturnStatement.class, jiMethod.statements.get(0));
    }
}
