package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import org.junit.Assert;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlackTest extends TestCase {

    public void testPosition() {

        BishopBlack b = new BishopBlack(Cell.A4);
        Assert.assertEquals(Cell.A4, b.position());

    }

    public void testCopy() {

        BishopBlack b = new BishopBlack(Cell.A4);
        Figure n = b.copy(Cell.A5);
        Assert.assertEquals(Cell.A5, n.position());

    }

    public void testWay() {

        BishopBlack b = new BishopBlack(Cell.C1);
        Cell[] way = b.way(Cell.G5);
        Cell[] expected = new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Assert.assertArrayEquals(expected, way);

    }

    public void testIsNotDiagonal() {

        BishopBlack b = new BishopBlack(Cell.C1);
        boolean expected =  b.isDiagonal(Cell.C1, Cell.A5);
        Assert.assertEquals(expected, false);
    }

    public void testIsDiagonal() {

        BishopBlack b = new BishopBlack(Cell.C1);
        boolean expected =  b.isDiagonal(Cell.C1, Cell.G5);
        Assert.assertEquals(expected, true);
    }
}