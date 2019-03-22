package com.firm.OX;

import org.testng.annotations.Test;

/**
 * @author Ola Podorska
 */

@Test
public class JudgeTest {

    @Test
    public void testIfJudgeDoesNotSeekNeighbours() {
        Judge judge = new Judge(new Size(15, 15), 3);
        Field field = new NotEmptyField(new Position(1,1));
        Positions positions = new Positions(10, new PositionComparator());
        positions.add(field.getPosition());
        Player player = new Player();
        positions.linkPlayerWithPositions(player, field.getPosition());
        //assert (!judge.checkNeighbours(field, positions)) : "Judge saw neighbours";
    }

    @Test
    public void testIfJudgeSeeNeighbours() {
        Judge judge = new Judge(new Size(15, 15), 3);
        Field field1 = new NotEmptyField(new Position(1, 1));
        Field field2 = new NotEmptyField(new Position(0 ,0));
        Positions positions = new Positions(10, new PositionComparator());
        positions.add(field1.getPosition());
        positions.add(field2.getPosition());
        Player player = new Player();
        positions.linkPlayerWithPositions(player, field1.getPosition());
        positions.linkPlayerWithPositions(player, field2.getPosition());
        //assert (judge.checkNeighbours(field1, positions)) : "Judge doesn't see neighbours";
    }

    @Test
    public void testIfJudgeDistinguishesPlayers() {
        Judge judge = new Judge(new Size(15, 15), 3);
        Field field1 = new NotEmptyField(new Position(1, 1));
        Field field2 = new NotEmptyField(new Position(0 ,0));
        Positions positions = new Positions(10, new PositionComparator());
        positions.add(field1.getPosition());
        positions.add(field2.getPosition());
        Player playerO = new Player("O", Characters.NAUGHT);
        Player playerX = new Player("X", Characters.CROSS);
        positions.linkPlayerWithPositions(playerO, field1.getPosition());
        positions.linkPlayerWithPositions(playerX, field2.getPosition());
        assert (judge.isOtherPlayerField(field1, field2, positions)) : "Judge doesn't see difference between players";
    }

    @Test
    public void testIfJudgeCheckOnlyTheSameCharacters() {
        Judge judge = new Judge(new Size(15, 15), 3);
        Field field1 = new NotEmptyField(new Position(1, 1));
        Field field2 = new NotEmptyField(new Position(0 ,0));
        Field field3 = new NotEmptyField(new Position(0, 1));
        Positions positions = new Positions(10, new PositionComparator());
        positions.add(field1.getPosition());
        positions.add(field2.getPosition());
        positions.add(field3.getPosition());
        Player playerO = new Player("O", Characters.NAUGHT);
        Player playerX = new Player("X", Characters.CROSS);
        positions.linkPlayerWithPositions(playerO, field1.getPosition());
        positions.linkPlayerWithPositions(playerX, field2.getPosition());
        positions.linkPlayerWithPositions(playerO, field3.getPosition());
        int neighbours = judge.howManyNeighbours(field1, positions);
        assert (neighbours == 1) : "Judge count all characters";
    }

    @Test
    public void testIfJudgeFindTheSameNeighbourSearchItNeighbours() {
        Judge judge = new Judge(new Size(15, 15), 3);
        Field field1 = new NotEmptyField(new Position(1, 1));
        Field field2 = new NotEmptyField(new Position(0 ,0));
        Field field3 = new NotEmptyField(new Position(2, 2));
        Positions positions = new Positions(10, new PositionComparator());
        positions.add(field1.getPosition());
        positions.add(field2.getPosition());
        positions.add(field3.getPosition());
        Player playerO = new Player("O", Characters.NAUGHT);
        positions.linkPlayerWithPositions(playerO, field1.getPosition());
        positions.linkPlayerWithPositions(playerO, field2.getPosition());
        positions.linkPlayerWithPositions(playerO, field3.getPosition());
        assert (judge.foundSequence(field3, positions)) : "Judge doesn't find sequence with the same characters";
    }

    @Test
    public void testIfJudgeFoundFieldsInRow() {
        Judge judge = new Judge(new Size(10, 10), 5);
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
        assert (judge.checkHorizontally(toCheck, positions)) : "Judge didn't found winning sequence";
    }

    @Test
    public void testIfJudgeFoundFewFieldsInRow() {
        Judge judge = new Judge(new Size(10, 10), 3);
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
        assert (judge.checkHorizontally(toCheck, positions)) : "Judge didn't found winning sequence";
    }

    @Test
    public void testIfJudgeDoesNotFoundFieldsInRow() {
        Judge judge = new Judge(new Size(10, 10), 5);
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
        assert (!judge.checkHorizontally(toCheck, positions)) : "Judge found winning sequence";
    }

    @Test
    public void testIfJudgeFoundFieldsInColumn() {
        Judge judge = new Judge(new Size(10, 10), 5);
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
        assert (judge.checkVertically(toCheck, positions)) : "Judge didn't found winning sequence";
    }

    @Test
    public void testIfJudgeFoundFewFieldsInColumn() {
        Judge judge = new Judge(new Size(10, 10), 3);
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
        assert (judge.checkVertically(toCheck, positions)) : "Judge didn't found winning sequence";
    }

    @Test
    public void testIfJudgeDoesNotFoundFieldsInColumn() {
        Judge judge = new Judge(new Size(10, 10), 5);
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
        assert (!judge.checkHorizontally(toCheck, positions)) : "Judge found winning sequence";
    }

    @Test
    public void testIfJudgeFoundFieldsInDiagonalRight() {
        Judge judge = new Judge(new Size(5, 5), 5);
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
        assert (judge.checkDiagonalUpToRight(toCheck, positions)) : "Judge didn't found winning sequence";
    }

    @Test
    public void testIfJudgeFoundFewFieldsInRight() {
        Judge judge = new Judge(new Size(10, 10), 3);
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
        assert (judge.checkDiagonalUpToRight(toCheck, positions)) : "Judge didn't found winning sequence";
    }

    @Test
    public void testIfJudgeDoesNotFoundFieldsInRight() {
        Judge judge = new Judge(new Size(10, 10), 5);
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
        assert (!judge.checkDiagonalUpToRight(toCheck, positions)) : "Judge found winning sequence";
    }

    @Test
    public void testIfJudgeFoundFieldsInDiagonalLeft() {
        Judge judge = new Judge(new Size(5, 5), 4);
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
        assert (judge.checkDiagonalDownToRight(toCheck, positions)) : "Judge didn't found winning sequence";
    }

    @Test
    public void testIfJudgeFoundFewFieldsInLeft() {
        Judge judge = new Judge(new Size(10, 10), 3);
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
        assert (judge.checkDiagonalDownToRight(toCheck, positions)) : "Judge didn't found winning sequence";
    }

    @Test
    public void testIfJudgeDoesNotFoundFieldsInLeft() {
        Judge judge = new Judge(new Size(10, 10), 5);
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
        assert (!judge.checkDiagonalDownToRight(toCheck, positions)) : "Judge found winning sequence";
    }
}
