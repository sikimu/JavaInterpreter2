package jp.co.javainterpreter;

import java.util.HashMap;
import java.util.Optional;
import java.util.Set;

public class JiMethodManager {

    private final HashMap<JiClass, Set<JiMethod>> methodMap = new HashMap<>();

    public void add(JiClass jiClass, Set<JiMethod> jiMethods) {
        methodMap.put(jiClass, jiMethods);
    }

    public Optional<JiMethod> getMethod(JiClass jiClass, String methodName) {

        return methodMap.get(jiClass).stream().filter(jiMethod -> jiMethod.name.equals(methodName)).findFirst();
    }
}
