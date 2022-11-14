import edu.princeton.cs.algs4.Picture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author dunk
 * @date 2022/11/9 21:18
 */
public class SeamCarver {

    private Picture picture;

    private double[][] pixels;

    private Map<Double, List<Integer>> weights;

    public SeamCarver(Picture picture) {
        this.picture = picture;
        pixels = new double[picture.height()][picture.width()];
        weights = new HashMap<>();
    }

    // current picture
    public Picture picture()  {
        return picture;
    }

    // width of current picture
    public int width()  {
        return picture.width();
    }

    // height of current picture
    public int height()   {
        return picture.height();
    }

    // energy of pixel at column x and row y
    public double energy(int x, int y)  {
        if (x < 0 || y < 0 || x >= width() || y >= height()) {
            throw new IndexOutOfBoundsException("either x or y is outside its prescribed range.");
        }
        return calcDeltaX(x, y) + calcDeltaY(x, y);
    }

    private double calcDeltaX(int x, int y) {
        double rX = this.picture.get(x == 0 ? width() - 1 : x - 1, y).getRed()
                - this.picture.get((x + 1) % width(), y).getRed();
        double gX = this.picture.get(x == 0 ? width() - 1 : x - 1, y).getGreen()
                - this.picture.get((x + 1) % width(), y).getGreen();
        double bX = this.picture.get(x == 0 ? width() - 1 : x - 1, y).getBlue()
                - this.picture.get((x + 1) % width(), y).getBlue();
        return rX * rX + gX * gX + bX * bX;
    }

    private double calcDeltaY(int x, int y) {
        double rY = this.picture.get(x, (y + 1) % height()).getRed()
                - this.picture.get(x, y == 0 ? height() - 1 : y - 1).getRed();
        double gY = this.picture.get(x, (y + 1) % height()).getGreen()
                - this.picture.get(x, y == 0 ? height() - 1 : y - 1).getGreen();
        double bY = this.picture.get(x, (y + 1) % height()).getBlue()
                - this.picture.get(x, y == 0 ? height() - 1 : y - 1).getBlue();
        return rY * rY + gY * gY + bY * bY;
    }

    // sequence of indices for horizontal seam
    public int[] findHorizontalSeam() {
        calcEnegyOfPixels();
        for (int i = 0; i < height(); i++) {
            double total = pixels[i][0];
            List<Integer> seams = new ArrayList<>(Arrays.asList(i));
            for (int j = 1; j < width(); j++) {
                int start = i == 0 ? i : i - 1, end = i == height() - 1 ? i : i + 1;
                double min = Math.min(pixels[start][j], Math.min(pixels[i][j], pixels[end][j]));
                total += min;
                for (int k = start; k <= end; k++) {
                    if (pixels[k][j] == min) {
                        seams.add(k);
                        break;
                    }
                }
            }
            weights.put(total, seams);
        }

        Set<Double> weight = weights.keySet();
        double min = 0.0;
        for (Double  w : weight) {
            if (min > w) {
                min = w;
            }
        }

        Set<Map.Entry<Double, List<Integer>>> entries = weights.entrySet();
        int[] result = new int[width()];
        for (Map.Entry<Double, List<Integer>> entry : entries) {
            if (entry.getKey() == min) {
                int i = 0;
                for (Integer enegy : entry.getValue()) {
                    result[i++] = enegy;
                }
            }
        }
        return result;
    }

    // sequence of indices for vertical seam
    public int[] findVerticalSeam()     {
        calcEnegyOfPixels();
        for (int i = 0; i < width(); i++) {
            double total = pixels[0][i];
            List<Integer> seams = new ArrayList<>(Arrays.asList(i));
            for (int j = 1; j < width(); j++) {
                int start = i == 0 ? i : i - 1, end = i == width() - 1 ? i : i + 1;
                double min = Math.min(pixels[start][j], Math.min(pixels[i][j], pixels[end][j]));
                total += min;
                for (int k = start; k <= end; k++) {
                    if (pixels[k][j] == min) {
                        seams.add(k);
                        break;
                    }
                }
            }
            weights.put(total, seams);
        }

        Set<Double> weight = weights.keySet();
        double min = 0.0;
        for (Double  w : weight) {
            if (min > w) {
                min = w;
            }
        }

        Set<Map.Entry<Double, List<Integer>>> entries = weights.entrySet();
        int[] result = new int[height()];
        for (Map.Entry<Double, List<Integer>> entry : entries) {
            if (entry.getKey() == min) {
                int i = 0;
                for (Integer enegy : entry.getValue()) {
                    result[i++] = enegy;
                }
            }
        }
        return result;
    }

    private void calcEnegyOfPixels() {
        for (int i = 0; i < height(); i++) {
            for (int j = 0; j < width(); j++) {
                pixels[i][j] = energy(j, i);
            }
        }
    }

    // remove horizontal seam from picture
    public void removeHorizontalSeam(int[] seam)   {
        SeamRemover.removeHorizontalSeam(picture(), seam);
    }

    // remove vertical seam from picture
    public void removeVerticalSeam(int[] seam)  {
        SeamRemover.removeVerticalSeam(picture(), seam);
    }
}
