import synthesizer.GuitarString;

/**
 * @author dunk
 */
public class GuitarHero {
    /**
     * initial frequency.
     */
    private static final double FREQUENCY = 440.0;
    /**
     * keyboard.
     */
    private static final String KEYBOARD = "q2we4r5ty7u8i9op-"
            + "[=zxdcfvgbnjmk,.;/' ";

    /**
     * Main.
     * @param args
     */
    public static void main(String[] args) {
        GuitarString guitarString = null;
        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = KEYBOARD.indexOf(key);
                if (index != -1) {
                    double power = (double) (index - 24) / 12.0;
                    double actualFrequency = FREQUENCY * Math.pow(2, power);
                    guitarString = new GuitarString(actualFrequency);
                    guitarString.pluck();
                }
            }

            if (guitarString != null) {
                double sample = guitarString.sample();
                StdAudio.play(sample);
                guitarString.tic();
            }
        }
    }
}
