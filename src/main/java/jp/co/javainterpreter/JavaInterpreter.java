package jp.co.javainterpreter;

import java.util.ArrayList;
import java.util.Optional;

public class JavaInterpreter {

    public JavaInterpreter(String sourceCode) {

        JiTokenCreator tokenCreator = new JiTokenCreator(sourceCode);

        ArrayList<String> tokenList = tokenCreator.create();
    }
}
