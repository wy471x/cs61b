import edu.princeton.cs.algs4.Picture;

/**
 * @author dunk
 * @date 2022/11/9 21:18
 */
public class SeamCarver {

    private Picture picture;

    private double[][] pixels;

    public SeamCarver(Picture picture) {
        this.picture = picture;
        pixels = new double[picture.height()][picture.width()];
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
        int[] horizontalSeam = new int[picture().width()];
        for (int i = 0; i < width(); i++) {
            double minEnegy = pixels[0][i];
            int index = 0;
            for (int j = 0; j < height(); j++) {
                if (pixels[j][i] < minEnegy) {
                    minEnegy = pixels[j][i];
                    index = j;
                }
            }
            horizontalSeam[i] = index;
        }
        return horizontalSeam;
    }

    // sequence of indices for vertical seam
    public int[] findVerticalSeam()     {
        calcEnegyOfPixels();
        int[] verticalSeams = new int[picture().height()];
        for (int i = 0; i < height(); i++) {
            double minEnegy = pixels[i][0];
            int index = 0;
            for (int j = 0; j < width(); j++) {
                if (pixels[i][j] < minEnegy) {
                    minEnegy = pixels[i][j];
                    index = j;
                }
            }
            verticalSeams[i] = index;
        }
        return verticalSeams;
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
