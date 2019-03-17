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
		try {
			addNumber(token);
		} catch (NumberFormatException e) {
			addNotANumberToken(token);
		}
		return this;
	}

	private void addNotANumberToken(String token) {
		if (token.length() == 1) {
			addOperator(token);
		} else {
			throw new IllegalArgumentException("Dont understand token: " + token);
		}
	}

	private void addOperator(String token) {
		try {
			Evaluable right = stack.pop();
			Evaluable left = stack.pop();
			Evaluable operator = new Operator(token.charAt(0),left ,right );
			stack.push(operator);
		}
		catch (EmptyStackException e) {
			throw new IllegalStateException("Nothing left on the stack for operand");
		}
	}

	private void addNumber(String token) {
		int value = Integer.parseInt(token);
		Evaluable number = new Number(value);
		stack.push(number);
	}

	@Override
	public Evaluable build() {
		if (stack.size() != 1) {
			throw new IllegalStateException("More than one token left on the stack, unbalanced input.");
		}
		return stack.pop();
	}

}
