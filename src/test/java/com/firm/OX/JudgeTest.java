package com.firm.OX;

import org.testng.annotations.Test;

import java.util.PriorityQueue;
import java.util.Queue;

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
        Field one = new NotEmptyField(new Position(2, 4));
        Field two = new NotEmptyField(new Position(2, 5));
        Field three = new NotEmptyField(new Position(2, 6));
        Field four = new NotEmptyField(new Position(2, 7));
        Player player = new Player("o", Characters.NAUGHT);
        Positions positions = new Positions(5, new PositionComparator());
        positions.add(new Position(2, 3));
        positions.add(new Position(2, 4));
        positions.add(new Position(2, 5));
        positions.add(new Position(2, 6));
        positions.add(new Position(2, 7));
        positions.linkPlayerWithPositions(player, new Position(2, 3));
        positions.linkPlayerWithPositions(player, new Position(2, 4));
        positions.linkPlayerWithPositions(player, new Position(2, 5));
        positions.linkPlayerWithPositions(player, new Position(2, 6));
        positions.linkPlayerWithPositions(player, new Position(2, 7));
        judge.checkHorizontally(toCheck, positions);
        assert (judge.checkHorizontally(toCheck, positions)) : "Judge didn't found winning sequence";
    }
}
