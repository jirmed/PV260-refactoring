/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicalrefactorings.equationsolver;

import java.util.EmptyStackException;
import java.util.Stack;

public class OnTheFlyRPNEquationBuilder implements RPNEquationBuilder {

    private Stack<Evaluable> stack = new Stack<>();

    @Override
    public RPNEquationBuilder push(String token) {
        Evaluable node = null;
        node = getNode(token);
        stack.push(node);
        return this;
    }

    private Evaluable getNode(String token) {
        Evaluable node;
        try {
            node = getNumberFromToken(token);
        } catch (NumberFormatException e) {
            node = getNotANumberFromToken(token);
        }
        return node;
    }

    private Evaluable getNotANumberFromToken(String token) {
        if (token.length() == 1) {
            return getOperatorFromToken(token);
        } else {
            throw new IllegalArgumentException("Dont understand token: " + token);
        }
    }

    private Evaluable getOperatorFromToken(String token) {
        try {
            Evaluable right = stack.pop();
            Evaluable left = stack.pop();
            return new Operator(token.charAt(0), left, right);
        } catch (EmptyStackException e) {
            throw new IllegalStateException("Nothing left on the stack for operand");
        }
    }

    private Evaluable getNumberFromToken(String token) {
        int value = Integer.parseInt(token);
        return new Number(value);
    }

    @Override
    public Evaluable build() {
        if (stack.size() != 1) {
            throw new IllegalStateException("More than one token left on the stack, unbalanced input.");
        }
        return stack.pop();
    }

}
