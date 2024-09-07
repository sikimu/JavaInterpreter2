package jp.co.javainterpreter.expression;

import jp.co.javainterpreter.object.JiObject;

/**
 * 計算式を表すクラス
 */
public class JiExpression {

    final JiObject[] jiObjects;

    public JiExpression(JiObject... jiObject) {
        this.jiObjects = jiObject;
    }

    public JiObject evaluate() {

        return jiObjects[0];
    }
}
