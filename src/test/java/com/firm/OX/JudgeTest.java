package com.firm.OX;

import org.testng.annotations.Test;

/**
 * @author Ola Podorska
 */

@Test
public class JudgeTest {

    @Test
    public void testIfJudgeDoesNotSeekNeighbours() {
        Judge judge = new Judge(new GameOptions());
        Field field = new NotEmptyField(new Position(1,1));
        Positions positions = new Positions(10, new PositionComparator());
        positions.add(field.getPosition());
        Player player = new Player();
        positions.linkPlayerWithPositions(player, field.getPosition());
        //assert (!judge.checkNeighbours(field, positions)) : "Judge saw neighbours";
    }

    @Test
    public void testIfJudgeSeeNeighbours() {
        Judge judge = new Judge(new GameOptions());
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
        Judge judge = new Judge(new GameOptions());
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
    public void testIfJudgeFindTheSameNeighbourSearchItNeighbours() {
        Judge judge = new Judge(new GameOptions());
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
        assert (judge.isWinningSequence(field3, positions)) : "Judge doesn't find sequence with the same characters";
    }
}
