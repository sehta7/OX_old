package com.firm.OX;

import org.testng.annotations.Test;

/**
 * @author Ola Podorska
 */

@Test
public class JudgeTest {

    @Test
    public void testIfJudgeDoesNotSeekNeighbours() {
        Judge judge = new Judge(new Size(15, 15));
        Field field = new NotEmptyField(new Position(1,1));
        Positions positions = new Positions(10, new PositionComparator());
        positions.add(field.getPosition());
        Player player = new Player();
        positions.linkPlayerWithPositions(player, field.getPosition());
        assert (!judge.checkNeighbours(field, positions)) : "Judge saw neighbours";
    }

    @Test
    public void testIfJudgeSeeNeighbours() {
        Judge judge = new Judge(new Size(15, 15));
        Field field1 = new NotEmptyField(new Position(1, 1));
        Field field2 = new NotEmptyField(new Position(0 ,0));
        Positions positions = new Positions(10, new PositionComparator());
        positions.add(field1.getPosition());
        positions.add(field2.getPosition());
        Player player = new Player();
        positions.linkPlayerWithPositions(player, field1.getPosition());
        positions.linkPlayerWithPositions(player, field2.getPosition());
        assert (judge.checkNeighbours(field1, positions)) : "Judge doesn't see neighbours";
    }

    @Test
    public void testIfJudgeDistinguishesPlayers() {
        Judge judge = new Judge(new Size(15, 15));
        Field field1 = new NotEmptyField(new Position(1, 1));
        Field field2 = new NotEmptyField(new Position(0 ,0));
        Positions positions = new Positions(10, new PositionComparator());
        positions.add(field1.getPosition());
        positions.add(field2.getPosition());
        Player playerO = new Player("O", Characters.NAUGHT);
        Player playerX = new Player("X", Characters.CROSS);
        positions.linkPlayerWithPositions(playerO, field1.getPosition());
        positions.linkPlayerWithPositions(playerX, field2.getPosition());
        assert (judge.isOtherPlayerField()) : "Judge doesn't see difference between players";
    }
}
