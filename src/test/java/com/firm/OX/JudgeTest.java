package com.firm.OX;

import org.testng.annotations.Test;

/**
 * @author Ola Podorska
 */

@Test
class JudgeTest {

    @Test
    public void testIfJudgeSeekNeighbours() {
        Judge judge = new Judge();
        assert (judge.checkNeighbours(field, fields)) : "Judge doesn't see neighbours";
    }
}
