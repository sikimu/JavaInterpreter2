package jp.co.javainterpreter;

import jp.co.javainterpreter.token.JiTokenCreator;

import java.util.ArrayList;

public class JavaInterpreter {

    public JavaInterpreter(String sourceCode) {

        JiTokenCreator tokenCreator = new JiTokenCreator(sourceCode);

        ArrayList<String> tokenList = tokenCreator.create();
    }
}
