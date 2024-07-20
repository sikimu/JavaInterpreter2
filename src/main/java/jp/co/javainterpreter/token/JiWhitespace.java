package jp.co.javainterpreter.token;

import java.util.Optional;

public record JiWhitespace(String value) implements JiToken {

    public static Optional<JiWhitespace> find(String sourceCode, int index) {
        int i = index;
        while (i < sourceCode.length()) {
            if (!Character.isWhitespace(sourceCode.charAt(i))){
                break;
            }
            i++;
        }
        if(i == index){
            return Optional.empty();
        }
        return Optional.of(new JiWhitespace(sourceCode.substring(index, i)));
    }
}
