/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicalrefactorings.floodfill;

import java.awt.*;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

public class Position {

	private int x;
	private int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int x() {
		return x;
	}

	public int y() {
		return y;
	}

	@Override
	public String toString() {
		return "[" + x + "," + y + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Position)) {
			return false;
		}
		Position other = (Position) obj;
		return other.x == x && other.y == y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	boolean isInBounds(Grid<Color> original) {
		return x() >= 0 && x() < original.width() && y() >= 0 && y() < original.height();
	}

	List<Position> getNeighbors() {
		return asList(
				new Position(x() + 1, y()),
				new Position(x(), y() + 1),
				new Position(x() - 1, y()),
				new Position(x(), y() - 1)
		);
	}
}
