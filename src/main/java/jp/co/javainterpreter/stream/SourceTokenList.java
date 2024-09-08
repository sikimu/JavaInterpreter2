package jp.co.javainterpreter.stream;

import jp.co.javainterpreter.token.Token;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * ソースのトークンリスト
 */
public class SourceTokenList {

    private ArrayList<Token> tokens = new ArrayList<>();

    public SourceTokenList(String source){
        TokenStream tokenStream = new TokenStream(source);
        while(tokenStream.hasNext()){
            tokens.add(tokenStream.next());
        }
    }
}
