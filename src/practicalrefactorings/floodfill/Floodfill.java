/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicalrefactorings.floodfill;

import java.awt.Color;
import java.util.ArrayList;

import static java.util.Arrays.asList;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class Floodfill {

    public Grid<Color> fillAt(Grid<Color> original, int startX, int startY, Color color) {
        Position start = new Position(startX, startY);
        return fillAt(original, start, color);
    }

    public Grid<Color> fillAt(Grid<Color> original, Position start, Color color) {
        if (start.isInBounds(original)) {
            return fillIfInBounds(original, start, color);
        } else {
            throw new IndexOutOfBoundsException("Got " + start + " but grid is only " + original.width() + "x" + original.height());
        }
    }

    private Grid<Color> fillIfInBounds(Grid<Color> original, Position start, Color color) {
        Color replacingColor = original.get(start.x(), start.y());
        if (!replacingColor.equals(color)) {
            return fillWithDifferentColor(original, start, color, replacingColor);
        } else
            return original;
    }

    private Grid<Color> fillWithDifferentColor(Grid<Color> original, Position start, Color color, Color replacingColor) {
        Grid<Color> copy = copyGrid(original);
        Queue<Position> left = new LinkedList<>();
        left.add(start);
        while (!left.isEmpty()) {
            Position at = left.poll();
            if (at.isInBounds(copy)) {
                setColorAndAddNeighbours(color, replacingColor, copy, left, at);
            }
        }
        return copy;
    }

    private void setColorAndAddNeighbours(Color color, Color replacingColor, Grid<Color> copy, Queue<Position> left, Position at) {
        copy.set(color, at.x(), at.y());
        Collection<Position> uncoloredNeighbors = getUncoloredNeighbors(copy, replacingColor, at);
        left.addAll(uncoloredNeighbors);
    }

    private Collection<Position> getUncoloredNeighbors(Grid<Color> copy, Color replacingColor, Position at) {
        Collection<Position> uncoloredNeighbors;
        Collection<Position> neighbors = asList(
                new Position(at.x() + 1, at.y()),
                new Position(at.x(), at.y() + 1),
                new Position(at.x() - 1, at.y()),
                new Position(at.x(), at.y() - 1)
        );
        uncoloredNeighbors = new ArrayList<>();
        for (Position position : neighbors) {
            if (position.isInBounds(copy)) {
                Color colorAtPosition = copy.get(position.x(), position.y());
                if (colorAtPosition.equals(replacingColor)) {
                    uncoloredNeighbors.add(position);
                }
            }
        }
        return uncoloredNeighbors;
    }

    private Grid<Color> copyGrid(Grid<Color> original) {
        Grid<Color> copy;
        copy = new ArrayBackedGrid<>(original.width(), original.height());
        for (int x = 0; x < original.width(); x++) {
            for (int y = 0; y < original.height(); y++) {
                copy.set(original.get(x, y), x, y);
            }
        }
        return copy;
    }

}
