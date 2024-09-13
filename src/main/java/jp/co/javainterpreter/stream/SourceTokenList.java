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

    public SourceTokenList() {

    }

    /**
     * リストの件数を取得する
     * @return 件数
     */
    public int size() {

        return tokens.size();
    }

    /**
     * トークンを取得する
     * @param position 位置
     * @return トークン
     */
    public Token get(int position) {

        return tokens.get(position);
    }

    /**
     * {から}までのリストを作成する
     * @param position {の位置
     * @return リスト
     */
    public SourceTokenList subList(int position) {

        ArrayList<Token> subList = new ArrayList<>();
        int count = 0;
        for(int i = position; i < tokens.size(); i++) {
            Token token = tokens.get(i);
            if(token.type == Token.Type.L_BRACE) {
                count++;
            } else if(token.type == Token.Type.R_BRACE) {
                count--;
            }
            subList.add(token);
            if(count == 0) {
                break;
            }
        }

        // 最初の{と最後の}を削除
        subList.removeFirst();
        subList.removeLast();

        SourceTokenList sourceTokenList = new SourceTokenList();
        sourceTokenList.tokens = subList;
        return sourceTokenList;
    }

    /**
     * (から)までのリストを作成する
     */
    public SourceTokenList subListParen(int position) {

        ArrayList<Token> subList = new ArrayList<>();
        int count = 0;
        for (int i = position; i < tokens.size(); i++) {
            Token token = tokens.get(i);
            if (token.type == Token.Type.L_PAREN) {
                count++;
            } else if (token.type == Token.Type.R_PAREN) {
                count--;
            }
            subList.add(token);
            if (count == 0) {
                break;
            }
        }

        // 最初の(と最後の)を削除
        subList.removeFirst();
        subList.removeLast();

        SourceTokenList sourceTokenList = new SourceTokenList();
        sourceTokenList.tokens = subList;
        return sourceTokenList;
    }
}
