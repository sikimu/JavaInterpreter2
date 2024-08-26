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

        List<Token> methodSignatureTokens = new ArrayList<>();
        methodSignatureTokens.add(Token.create("int"));
        methodSignatureTokens.add(Token.create("test"));

        List<Token> parameterTokens = new ArrayList<>();
        parameterTokens.add(Token.create("int"));
        parameterTokens.add(Token.create("i"));

        List<Token> methodBodyTokens = new ArrayList<>();
        methodBodyTokens.add(Token.create("return"));
        methodBodyTokens.add(Token.create("1"));
        methodBodyTokens.add(Token.create(";"));

        JiMethod jiMethod = JiMethod.create(methodSignatureTokens, parameterTokens, methodBodyTokens);

        assertEquals("test", jiMethod.name);
        assertEquals(Token.Type.INT, jiMethod.returnType.type);
        // メソッドのステートメントが正しく作成されているか確認
        assertEquals(1, jiMethod.statements.size());
        assertInstanceOf(JiReturnStatement.class, jiMethod.statements.get(0));
    }

    @Test
    void testメソッド作成成功2(){

        List<Token> methodSignatureTokens = new ArrayList<>();
        methodSignatureTokens.add(Token.create("String"));
        methodSignatureTokens.add(Token.create("test"));

        List<Token> parameterTokens = new ArrayList<>();
        parameterTokens.add(Token.create("String"));
        parameterTokens.add(Token.create("string"));

        List<Token> methodBodyTokens = new ArrayList<>();
        methodBodyTokens.add(Token.create("return"));
        methodBodyTokens.add(Token.create("\"Hello, World!\""));
        methodBodyTokens.add(Token.create(";"));

        JiMethod jiMethod = JiMethod.create(methodSignatureTokens, parameterTokens, methodBodyTokens);

        assertEquals("test", jiMethod.name);
        assertEquals(Token.Type.STRING, jiMethod.returnType.type);
        // メソッドのステートメントが正しく作成されているか確認
        assertEquals(1, jiMethod.statements.size());
        assertInstanceOf(JiReturnStatement.class, jiMethod.statements.get(0));
    }
}
