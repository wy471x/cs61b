package hw3.hash;
import java.awt.Color;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdDraw;

/**
 * @author dunk
 */
public class SimpleOomage implements Oomage {
    /**
     * Red.
     */
    private int red;
    /**
     * Green.
     */
    protected int green;
    /**
     * Blue.
     */
    protected int blue;

    /**
     * Width.
     */
    private static final double WIDTH = 0.01;
    /**
     * Use perfect hash flag.
     */
    private static final boolean USE_PERFECT_HASH = true;

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        SimpleOomage t = (SimpleOomage) o;
        return (this.red == t.red)
                && (this.green == t.green)
                && (this.blue == t.blue);
    }

    @Override
    public int hashCode() {
        if (!USE_PERFECT_HASH) {
            return red + green + blue;
        } else {
            return red / 5 * 255 * 255 * 31
                    + green / 5 * 255 * 31
                    + blue / 5 * 31;
        }
    }

    /**
     * Constructor for SimpleOomage class.
     *
     * @param r
     * @param g
     * @param b
     */
    public SimpleOomage(int r, int g, int b) {
        if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
            throw new IllegalArgumentException();
        }
        if ((r % 5 != 0) || (g % 5 != 0) || (b % 5 != 0)) {
            throw new IllegalArgumentException("red/green/blue "
                    + "values must all be multiples of 5!");
        }
        red = r;
        green = g;
        blue = b;
    }

    @Override
    public void draw(double x, double y, double scalingFactor) {
        StdDraw.setPenColor(new Color(red, green, blue));
        StdDraw.filledSquare(x, y, WIDTH * scalingFactor);
    }

    /**
     * Generate random SimpleOomage objects.
     *
     * @return
     */
    public static SimpleOomage randomSimpleOomage() {
        int red = StdRandom.uniform(0, 51) * 5;
        int green = StdRandom.uniform(0, 51) * 5;
        int blue = StdRandom.uniform(0, 51) * 5;
        return new SimpleOomage(red, green, blue);
    }

    /**
     * Main.
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Drawing 4 random simple Oomages.");
        randomSimpleOomage().draw(0.25, 0.25, 1);
        randomSimpleOomage().draw(0.75, 0.75, 1);
        randomSimpleOomage().draw(0.25, 0.75, 1);
        randomSimpleOomage().draw(0.75, 0.25, 1);
    }

    /**
     * Convert to string.
     *
     * @return
     */
    public String toString() {
        return "R: " + red + ", G: " + green + ", B: " + blue;
    }
}
