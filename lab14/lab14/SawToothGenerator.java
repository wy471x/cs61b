package lab14;

import lab14lib.Generator;

/**
 * @author dunk
 * @date 2022/10/27 23:17
 */
public class SawToothGenerator implements Generator {
    private int period;
    private int state;

    public SawToothGenerator(int period) {
        this.period = period;
        state = 0;
    }

    @Override
    public double next() {
        state = state % period;
        double result = normalize(state);
        state += 1;
        return result;
    }

    private double normalize(int state) {
        return -1 + 2 * (double)state / period;
    }
}
