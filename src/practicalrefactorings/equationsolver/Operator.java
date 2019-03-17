package practicalrefactorings.equationsolver;

public class Operator extends Node {
    private char operator;
    private Node left;
    private Node right;

    public Operator(char operator) {
        this.operator=operator;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public int evaluate() {
        Operation operation = OperationFactory
                .getOperation(operator)
                .orElseThrow(() -> new IllegalStateException("Unknown operator: " + operator));
        return operation.calculate(left.evaluate(), right.evaluate());
    }

    @Override
    public String representation() {
        return "(" + left.representation() + " " + operator + " " + right.representation() + ")";
    }
}
