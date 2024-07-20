package jp.co.javainterpreter.token;

import java.util.ArrayList;

/**
 * トークンを作成するクラス
 */
public class JiTokenCreator {

    private String sourceCode;

    private int index = 0;

    private final ArrayList<String> list = new ArrayList<>();

    public JiTokenCreator(String sourceCode) {

        this.sourceCode = sourceCode;

        while (index < sourceCode.length()) {


        }
    }

    /**
     * トークンを作成する
     *
     * @return トークンリスト
     */
    public ArrayList<String> create() {

        // コピーしてlistを返す
        return new ArrayList<>(list);
    }
}
