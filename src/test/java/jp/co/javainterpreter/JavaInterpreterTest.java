package jp.co.javainterpreter;

import jp.co.javainterpreter.instance.JiInstance;
import jp.co.javainterpreter.object.JiClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JavaInterpreterTest {

    @Test
    void testソース読み込み成功() {
        JavaInterpreter javaInterpreter = new JavaInterpreter();
        javaInterpreter.loadSource("jp.co.javainterpreter.token", "class Token { }");
        JiClass jiClass = javaInterpreter.getJiClass("jp.co.javainterpreter.token", "Token");

        assertEquals("jp.co.javainterpreter.token.Token", jiClass.getFullName());
    }

    @Test
    void testクラスインスタンス作成成功() {
        JavaInterpreter javaInterpreter = new JavaInterpreter();
        javaInterpreter.loadSource("jp.co.javainterpreter.instance", "class JiClassInstance { }");
        JiInstance jiClassInstance = javaInterpreter.createInstance("jp.co.javainterpreter.instance.JiClassInstance");

        assertNotNull(jiClassInstance);
        assertEquals("jp.co.javainterpreter.instance.JiClassInstance", jiClassInstance.getClassName());
    }

    @Test
    void testクラスインスタンス作成失敗(){
        JavaInterpreter javaInterpreter = new JavaInterpreter();

        // クラス名が存在しない場合、exceptionが発生することを確認
        assertThrows(RuntimeException.class, () -> javaInterpreter.createInstance("jp.co.javainterpreter.instance.JiClassInstance2"));
    }
}