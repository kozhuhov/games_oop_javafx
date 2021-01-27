package ru.job4j.chess;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import java.io.IOException;

public class LogicTest {

    @Test
    public void move()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        try {
            logic.move(Cell.C1, Cell.H6);
        } catch (Exception exp) {
            System.out.println("Баг!");
        }

    }

    @Test
    public void moveWhenFigureNotFound()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        boolean rsl = false;
        try {
            logic.move(Cell.C1, Cell.H6);
        } catch (FigureNotFoundException exp) {
            rsl = true;
        }
        Assert.assertEquals(true, rsl);
    }

    @Test
    public void moveWhenOccupiedCellException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.D2));
        boolean rsl = false;
        try {
            logic.move(Cell.C1, Cell.H6);
        } catch (OccupiedCellException exp) {
            rsl = true;
        }
        Assert.assertEquals(true, rsl);
    }

    @Test
    public void moveWhenImpossibleMoveException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        boolean rsl = false;
        try {
            logic.move(Cell.C1, Cell.H5);
        } catch (ImpossibleMoveException exp) {
            rsl = true;
        }
        Assert.assertEquals(true, rsl);
    }
}