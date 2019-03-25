package com.firm.OX;

import org.testng.annotations.Test;

@Test
public class CheckerTest {

    @Test
    public void testIfJudgeFoundFieldsInRow() {
        Checker checker = new HorizontallyChecker(new GameOptions());
        Field toCheck = new NotEmptyField(new Position(2,3));
        Position one = new Position(2, 4);
        Position two = new Position(2, 5);
        Position three = new Position(2, 6);
        Position four = new Position(2, 7);
        Player player = new Player("o", Characters.NAUGHT);
        Positions positions = new Positions(5, new PositionComparator());
        positions.add(new Position(2, 3));
        positions.add(one);
        positions.add(two);
        positions.add(three);
        positions.add(four);
        positions.linkPlayerWithPositions(player, new Position(2, 3));
        positions.linkPlayerWithPositions(player, one);
        positions.linkPlayerWithPositions(player, two);
        positions.linkPlayerWithPositions(player, three);
        positions.linkPlayerWithPositions(player, four);
        assert (checker.checkSequence(toCheck, positions)) : "Judge didn't found winning sequence";
    }

    @Test
    public void testIfJudgeFoundFewFieldsInRow() {
        Checker checker = new HorizontallyChecker(new GameOptions());
        Field toCheck = new NotEmptyField(new Position(2,3));
        Position one = new Position(2, 4);
        Position two = new Position(2, 7);
        Position three = new Position(2, 8);
        Position four = new Position(2, 9);
        Player player = new Player("o", Characters.NAUGHT);
        Positions positions = new Positions(5, new PositionComparator());
        positions.add(new Position(2, 3));
        positions.add(one);
        positions.add(two);
        positions.add(three);
        positions.add(four);
        positions.linkPlayerWithPositions(player, new Position(2, 3));
        positions.linkPlayerWithPositions(player, one);
        positions.linkPlayerWithPositions(player, two);
        positions.linkPlayerWithPositions(player, three);
        positions.linkPlayerWithPositions(player, four);
        assert (checker.checkSequence(toCheck, positions)) : "Judge didn't found winning sequence";
    }

    @Test
    public void testIfJudgeDoesNotFoundFieldsInRow() {
        Checker checker = new HorizontallyChecker(new GameOptions());
        Field toCheck = new NotEmptyField(new Position(2,3));
        Position one = new Position(2, 4);
        Position two = new Position(2, 6);
        Position three = new Position(2, 7);
        Position four = new Position(2, 9);
        Player player = new Player("o", Characters.NAUGHT);
        Positions positions = new Positions(5, new PositionComparator());
        positions.add(new Position(2, 3));
        positions.add(one);
        positions.add(two);
        positions.add(three);
        positions.add(four);
        positions.linkPlayerWithPositions(player, new Position(2, 3));
        positions.linkPlayerWithPositions(player, one);
        positions.linkPlayerWithPositions(player, two);
        positions.linkPlayerWithPositions(player, three);
        positions.linkPlayerWithPositions(player, four);
        assert (!checker.checkSequence(toCheck, positions)) : "Judge found winning sequence";
    }

    @Test
    public void testIfJudgeFoundFieldsInColumn() {
        Checker checker = new VerticallyChecker(new GameOptions());
        Field toCheck = new NotEmptyField(new Position(3,2));
        Position one = new Position(4, 2);
        Position two = new Position(5, 2);
        Position three = new Position(6, 2);
        Position four = new Position(7, 2);
        Player player = new Player("o", Characters.NAUGHT);
        Positions positions = new Positions(5, new PositionComparator());
        positions.add(new Position(3, 2));
        positions.add(one);
        positions.add(two);
        positions.add(three);
        positions.add(four);
        positions.linkPlayerWithPositions(player, new Position(3, 2));
        positions.linkPlayerWithPositions(player, one);
        positions.linkPlayerWithPositions(player, two);
        positions.linkPlayerWithPositions(player, three);
        positions.linkPlayerWithPositions(player, four);
        assert (checker.checkSequence(toCheck, positions)) : "Judge didn't found winning sequence";
    }

    @Test
    public void testIfJudgeFoundFewFieldsInColumn() {
        Checker checker = new VerticallyChecker(new GameOptions());
        Field toCheck = new NotEmptyField(new Position(2,2));
        Position one = new Position(4, 2);
        Position two = new Position(5, 2);
        Position three = new Position(6, 2);
        Position four = new Position(9, 2);
        Player player = new Player("o", Characters.NAUGHT);
        Positions positions = new Positions(5, new PositionComparator());
        positions.add(new Position(2, 2));
        positions.add(one);
        positions.add(two);
        positions.add(three);
        positions.add(four);
        positions.linkPlayerWithPositions(player, new Position(2, 2));
        positions.linkPlayerWithPositions(player, one);
        positions.linkPlayerWithPositions(player, two);
        positions.linkPlayerWithPositions(player, three);
        positions.linkPlayerWithPositions(player, four);
        assert (checker.checkSequence(toCheck, positions)) : "Judge didn't found winning sequence";
    }

    @Test
    public void testIfJudgeDoesNotFoundFieldsInColumn() {
        Checker checker = new VerticallyChecker(new GameOptions());
        Field toCheck = new NotEmptyField(new Position(2,2));
        Position one = new Position(3, 2);
        Position two = new Position(5, 2);
        Position three = new Position(7, 2);
        Position four = new Position(9, 2);
        Player player = new Player("o", Characters.NAUGHT);
        Positions positions = new Positions(5, new PositionComparator());
        positions.add(new Position(2, 2));
        positions.add(one);
        positions.add(two);
        positions.add(three);
        positions.add(four);
        positions.linkPlayerWithPositions(player, new Position(2, 2));
        positions.linkPlayerWithPositions(player, one);
        positions.linkPlayerWithPositions(player, two);
        positions.linkPlayerWithPositions(player, three);
        positions.linkPlayerWithPositions(player, four);
        assert (!checker.checkSequence(toCheck, positions)) : "Judge found winning sequence";
    }

    @Test
    public void testIfJudgeFoundFieldsInDiagonalRight() {
        Checker checker = new DiagonalChecker(new GameOptions());
        Position zero = new Position(3, 2);
        Position one = new Position(4, 1);
        Position two = new Position(2, 3);
        Position three = new Position(1, 4);
        Position four = new Position(0, 5);
        Player player = new Player("o", Characters.NAUGHT);
        Field toCheck = new NotEmptyField(zero);
        Positions positions = new Positions(5, new PositionComparator());
        positions.add(zero);
        positions.add(one);
        positions.add(two);
        positions.add(three);
        positions.add(four);
        positions.linkPlayerWithPositions(player, zero);
        positions.linkPlayerWithPositions(player, one);
        positions.linkPlayerWithPositions(player, two);
        positions.linkPlayerWithPositions(player, three);
        positions.linkPlayerWithPositions(player, four);
        assert (checker.checkSequence(toCheck, positions)) : "Judge didn't found winning sequence";
    }

    @Test
    public void testIfJudgeFoundFewFieldsInRight() {
        Checker checker = new DiagonalChecker(new GameOptions());
        Position zero = new Position(2, 4);
        Position one = new Position(4, 2);
        Position two = new Position(3, 3);
        Position three = new Position(5, 2);
        Position four = new Position(0, 6);
        Player player = new Player("o", Characters.NAUGHT);
        Field toCheck = new NotEmptyField(zero);
        Positions positions = new Positions(5, new PositionComparator());
        positions.add(zero);
        positions.add(one);
        positions.add(two);
        positions.add(three);
        positions.add(four);
        positions.linkPlayerWithPositions(player, zero);
        positions.linkPlayerWithPositions(player, one);
        positions.linkPlayerWithPositions(player, two);
        positions.linkPlayerWithPositions(player, three);
        positions.linkPlayerWithPositions(player, four);
        assert (checker.checkSequence(toCheck, positions)) : "Judge didn't found winning sequence";
    }

    @Test
    public void testIfJudgeDoesNotFoundFieldsInRight() {
        Checker checker = new DiagonalChecker(new GameOptions());
        Position zero = new Position(2, 4);
        Position one = new Position(4, 2);
        Position two = new Position(3, 3);
        Position three = new Position(5, 2);
        Position four = new Position(0, 6);
        Player player = new Player("o", Characters.NAUGHT);
        Field toCheck = new NotEmptyField(zero);
        Positions positions = new Positions(5, new PositionComparator());
        positions.add(zero);
        positions.add(one);
        positions.add(two);
        positions.add(three);
        positions.add(four);
        positions.linkPlayerWithPositions(player, zero);
        positions.linkPlayerWithPositions(player, one);
        positions.linkPlayerWithPositions(player, two);
        positions.linkPlayerWithPositions(player, three);
        positions.linkPlayerWithPositions(player, four);
        assert (!checker.checkSequence(toCheck, positions)) : "Judge found winning sequence";
    }

    @Test
    public void testIfJudgeFoundFieldsInDiagonalLeft() {
        Checker checker = new AntiDiagonalChecker(new GameOptions());
        Position zero = new Position(3, 2);
        Position one = new Position(4, 3);
        Position three = new Position(1, 0);
        Position four = new Position(2, 1);
        Player player = new Player("o", Characters.NAUGHT);
        Field toCheck = new NotEmptyField(zero);
        Positions positions = new Positions(5, new PositionComparator());
        positions.add(zero);
        positions.add(one);
        positions.add(three);
        positions.add(four);
        positions.linkPlayerWithPositions(player, zero);
        positions.linkPlayerWithPositions(player, one);
        positions.linkPlayerWithPositions(player, three);
        positions.linkPlayerWithPositions(player, four);
        assert (checker.checkSequence(toCheck, positions)) : "Judge didn't found winning sequence";
    }

    @Test
    public void testIfJudgeFoundFewFieldsInLeft() {
        Checker checker = new AntiDiagonalChecker(new GameOptions());
        Position zero = new Position(2, 2);
        Position one = new Position(3, 3);
        Position three = new Position(1, 1);
        Position four = new Position(2, 1);
        Player player = new Player("o", Characters.NAUGHT);
        Field toCheck = new NotEmptyField(zero);
        Positions positions = new Positions(5, new PositionComparator());
        positions.add(zero);
        positions.add(one);
        positions.add(three);
        positions.add(four);
        positions.linkPlayerWithPositions(player, zero);
        positions.linkPlayerWithPositions(player, one);
        positions.linkPlayerWithPositions(player, three);
        positions.linkPlayerWithPositions(player, four);
        assert (checker.checkSequence(toCheck, positions)) : "Judge didn't found winning sequence";
    }

    @Test
    public void testIfJudgeDoesNotFoundFieldsInLeft() {
        Checker checker = new AntiDiagonalChecker(new GameOptions());
        Position zero = new Position(1, 2);
        Position one = new Position(3, 3);
        Position three = new Position(1, 3);
        Position four = new Position(2, 4);
        Player player = new Player("o", Characters.NAUGHT);
        Field toCheck = new NotEmptyField(zero);
        Positions positions = new Positions(5, new PositionComparator());
        positions.add(zero);
        positions.add(one);
        positions.add(three);
        positions.add(four);
        positions.linkPlayerWithPositions(player, zero);
        positions.linkPlayerWithPositions(player, one);
        positions.linkPlayerWithPositions(player, three);
        positions.linkPlayerWithPositions(player, four);
        assert (!checker.checkSequence(toCheck, positions)) : "Judge found winning sequence";
    }
}
