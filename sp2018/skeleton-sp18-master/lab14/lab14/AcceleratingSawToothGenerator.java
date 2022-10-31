package lab14;

import lab14lib.Generator;

/**
 * @author dunk
 * @date 2022/10/31 12:44
 */
public class AcceleratingSawToothGenerator implements Generator {
    private int period;
    private int state;
    private int factor;

    public AcceleratingSawToothGenerator(int period, int factor) {
        this.period = period;
        this.factor = factor;
        state = 0;
    }

    @Override
    public double next() {
        return 0;
    }
}
