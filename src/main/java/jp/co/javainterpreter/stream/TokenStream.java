package jp.co.javainterpreter.stream;

import jp.co.javainterpreter.token.Token;

public class TokenStream {

    /**
     * 現在の位置
     */
    int position = 0;

    private final String source;

    public TokenStream(String source) {
        this.source = source;
    }

    public Token getNext() {
        skip();
        
        String word = seekWord();

        return Token.create(word);
    }

    /**
     * 次の単語を取得する
     */
    String seekWord() {
        StringBuilder word = new StringBuilder();
        for (; position < source.length(); position++) {
            char c = source.charAt(position);
            if (!Character.isWhitespace(c)) {
                word.append(c);
            } else {
                break;
            }
        }
        return word.toString();
    }

    /**
     * 空白やコメントをスキップする
     */
    void skip() {

        while(position < source.length()){
            if(Character.isWhitespace(source.charAt(position))){
                position++;
            } else if(position < source.length() - 1 && source.charAt(position) == '/' && source.charAt(position + 1) == '/'){
                while (position < source.length() && source.charAt(position) != '\n') {
                    position++;
                }
            } else if(position < source.length() - 1 && source.charAt(position) == '/' && source.charAt(position + 1) == '*'){
                while (position < source.length() - 1 && !(source.charAt(position) == '*' && source.charAt(position + 1) == '/')) {
                    position++;
                }
                position += 2;
            } else {
                break;
            }
        }
    }
}
