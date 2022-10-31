package lab14;

import lab14lib.Generator;

/**
 * @author dunk
 * @date 2022/10/31 12:44
 */
public class AcceleratingSawToothGenerator implements Generator {
    private double period;
    private double state;
    private double factor;

    public AcceleratingSawToothGenerator(int period, double factor) {
        this.period = period;
        this.factor = factor;
        state = 0;
    }

    @Override
    public double next() {
        if (state < period) {
            state = state + 1;
            return normalize(state);
        } else {
            state = (state + 1) % period;
            double result = normalize(state);
            period *= factor;
            return result;
        }
    }

    private double normalize(double state) {
        return -1 + 2 * (state + 1) / period;
    }
}
