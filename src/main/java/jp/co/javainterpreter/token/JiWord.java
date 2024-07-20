package jp.co.javainterpreter.token;

import java.util.Optional;

public record JiWord(String value) implements JiToken {

    public static Optional<JiWord> find(String sourceCode, int index) {

        // インデックスが文字列の長さ以上の場合は、空のOptionalを返す
        if (index >= sourceCode.length()) {
            return Optional.empty();
        }

        // 1文字目がアルファベットでない場合は、空のOptionalを返す
        if (!Character.isLetter(sourceCode.charAt(index))) {
            return Optional.empty();
        }

        // 2文字目以降がアルファベットか数字である限り、インデックスを進める
        int i = index;
        while (i < sourceCode.length() && (Character.isLetter(sourceCode.charAt(i)) || Character.isDigit(sourceCode.charAt(i)))) {
            i++;
        }

        return Optional.of(new JiWord(sourceCode.substring(index, i)));
    }
}
