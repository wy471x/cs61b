package creatures;

import huglife.*;
import org.junit.Test;

import java.awt.*;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

/**
 * @author dunk
 * @date 2022/11/1 22:32
 */
public class TestClorus {
    @Test
    public void testBasics() {
        Clorus c = new Clorus(2);
        assertEquals(2, c.energy(), 0.01);
        assertEquals(new Color(34, 0, 231), c.color());
        c.move();
        assertEquals(1.97, c.energy(), 0.01);
        c.move();
        assertEquals(1.94, c.energy(), 0.01);
        c.stay();
        assertEquals(1.93, c.energy(), 0.01);
        c.stay();
        assertEquals(1.92, c.energy(), 0.01);
    }

    @Test
    public void testReplicate() {
        Clorus c = new Clorus(2);
        assertNotSame(c, c.replicate());
        assertEquals(1, c.energy(), 0.01);
    }

    @Test
    public void testChoose() {
        // test for rule 1
        Clorus clorus = new Clorus(1.2);
        HashMap<Direction, Occupant> surrounded = new HashMap<Direction, Occupant>();
        surrounded.put(Direction.TOP, new Impassible());
        surrounded.put(Direction.BOTTOM, new Plip(2));
        surrounded.put(Direction.LEFT, new Impassible());
        surrounded.put(Direction.RIGHT, new Impassible());

        Action actual = clorus.chooseAction(surrounded);
        Action expected = new Action(Action.ActionType.STAY);

        assertEquals(expected, actual);

        // test for rule 2

        // test for rule 3

        // test for rule 4

    }

    public static void main(String[] args) {
        System.exit(jh61b.junit.textui.runClasses(TestClorus.class));
    }

}
