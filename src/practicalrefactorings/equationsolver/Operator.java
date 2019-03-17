package practicalrefactorings.equationsolver;

public class Operator implements Evaluable {
    private char symbol;
    private Evaluable left;
    private Evaluable right;

    public Operator(char symbol, Evaluable left, Evaluable right) {
        this.symbol = symbol;
        this.left = left;
        this.right =right;
    }

    @Override
    public int evaluate() {
        Operation operation = OperationFactory
                .getOperation(symbol)
                .orElseThrow(() -> new IllegalStateException("Unknown symbol: " + symbol));
        return operation.calculate(left.evaluate(), right.evaluate());
    }

    @Override
    public String representation() {
        return "(" + left.representation() + " " + symbol + " " + right.representation() + ")";
    }
}
