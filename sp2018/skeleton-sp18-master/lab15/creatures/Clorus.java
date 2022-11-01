package creatures;

import huglife.*;

import java.awt.*;
import java.util.List;
import java.util.Map;

/**
 * @author dunk
 * @date 2022/11/1 22:32
 */
public class Clorus extends Creature {

    /**
     * red color.
     */
    private int r;
    /**
     * green color.
     */
    private int g;
    /**
     * blue color.
     */
    private int b;

    /**
     * Creates a creature with the name N. The intention is that this
     * name should be shared between all creatures of the same type.
     *
     * @param e
     */
    public Clorus(double e) {
        super("clorus");
        r = 0;
        g = 0;
        b = 0;
        energy = e;
    }

    @Override
    public void move() {
        this.energy -= 0.03;
    }

    @Override
    public void attack(Creature c) {
        this.energy += c.energy();
    }

    @Override
    public Creature replicate() {
        Clorus clorus = new Clorus(this.energy /= 2);
        clorus.r = this.r;
        clorus.g = this.g;
        clorus.b = this.b;
        return clorus;
    }

    @Override
    public void stay() {
        this.energy -= 0.01;
    }

    @Override
    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        List<Direction> empties = getNeighborsOfType(neighbors, "empty");
        // rule 1
        if (empties.size() == 0) {
            return new Action(Action.ActionType.STAY);
        }

        // rule 2
        List<Direction> plips = getNeighborsOfType(neighbors, "plip");
        if (plips.size() > 0) {
            if (plips.size() == 1) {
                Direction direction = plips.get(0);
                return new Action(Action.ActionType.ATTACK, direction);
            } else {
                Direction direction = HugLifeUtils.randomEntry(plips);
                return new Action(Action.ActionType.ATTACK, direction);
            }
        }

        // rule 3
        if (this.energy >= 1) {
            if (empties.size() == 1) {
                Direction moveDir = empties.get(0);
                return new Action(Action.ActionType.REPLICATE, moveDir);
            }

            if (empties.size() > 1) {
                Direction moveDir = HugLifeUtils.randomEntry(empties);
                return new Action(Action.ActionType.REPLICATE, moveDir);
            }
        }

        // rule 4
        return new Action(Action.ActionType.MOVE, HugLifeUtils.randomEntry(empties));
    }

    @Override
    public Color color() {
        this.r = 34;
        this.g = 0;
        this.b = 231;
        return new Color(this.r, this.g, this.b);
    }
}
