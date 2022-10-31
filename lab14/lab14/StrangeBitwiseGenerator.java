package lab14;

import lab14lib.Generator;

/**
 * @author dunk
 * @date 2022/10/31 20:54
 */
public class StrangeBitwiseGenerator implements Generator {
    private int period;
    private int state;

    public StrangeBitwiseGenerator(int period) {
        this.period = period;
        this.state = state;
    }

    @Override
    public double next() {
        state += 1;
        int weirdState = state & (state >> 3) % period;
        return normalize(weirdState);
    }

    private double normalize(int state) {
        return -1 + 2 * (double)(state + 1) / period;
    }
}
