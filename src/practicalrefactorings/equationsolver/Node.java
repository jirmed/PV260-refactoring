/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicalrefactorings.equationsolver;

public abstract class Node implements Evaluable {

	@Override
	public abstract int evaluate();

	@Override
	public abstract String representation();

}
