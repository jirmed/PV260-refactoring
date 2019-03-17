package practicalrefactorings.equationsolver;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OperationFactory {
    private static Map<Character, Operation> operationMap = new HashMap<>();
    static {
        operationMap.put('+', (a,b) -> a+b);
        operationMap.put('-', (a,b) -> a-b);
        operationMap.put('*', (a,b) -> a*b);
        operationMap.put('/', (a,b) -> a/b);
    }

    public static Optional<Operation> getOperation(char symbol) {
        return Optional.ofNullable(operationMap.get(symbol));
    }

}
