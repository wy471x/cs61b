import edu.princeton.cs.algs4.Picture;

/**
 * @author dunk
 * @date 2022/11/9 21:18
 */
public class SeamCarver {

    private Picture picture;

    public SeamCarver(Picture picture) {
        this.picture = picture;
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
    public double energy(int x, int y)    {
        return 0.0;
    }

    private double calcDeltaX() {
        return 0.0;
    }

    // sequence of indices for horizontal seam
    public int[] findHorizontalSeam()    {
        return null;
    }

    // sequence of indices for vertical seam
    public int[] findVerticalSeam()     {
        return null;
    }

    // remove horizontal seam from picture
    public void removeHorizontalSeam(int[] seam)   {

    }

    // remove vertical seam from picture
    public void removeVerticalSeam(int[] seam)  {

    }
}
