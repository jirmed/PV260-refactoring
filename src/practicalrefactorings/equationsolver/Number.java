package practicalrefactorings.equationsolver;

public class Number implements Evaluable {
    private int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    public int evaluate() {
        return value;
    }

    @Override
    public String representation() {
        return String.valueOf(value);
    }
}
