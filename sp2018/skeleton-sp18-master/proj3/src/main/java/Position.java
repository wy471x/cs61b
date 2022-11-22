/**
 * @author yongwan
 * @date 2022/11/21
 * @desc
 */
public class Position {
    private double ullon;
    private double lrlon;
    private double ullat;
    private double lrlat;

    private int depth;

    private int x;

    private int y;

    public Position(int depth, int x, int y, double ullon, double lrlon, double ullat, double lrlat) {
        this.ullon = ullon;
        this.lrlon = lrlon;
        this.ullat = ullat;
        this.lrlat = lrlat;
        this.depth = depth;
        this.x = x;
        this.y = y;
    }

    public Position(double ullon, double lrlon, double ullat, double lrlat) {
        this.ullon = ullon;
        this.lrlon = lrlon;
        this.ullat = ullat;
        this.lrlat = lrlat;
    }

    public double getUllon() {
        return ullon;
    }

    public void setUllon(double ullon) {
        this.ullon = ullon;
    }

    public double getLrlon() {
        return lrlon;
    }

    public void setLrlon(double lrlon) {
        this.lrlon = lrlon;
    }

    public double getUllat() {
        return ullat;
    }

    public void setUllat(double ullat) {
        this.ullat = ullat;
    }

    public double getLrlat() {
        return lrlat;
    }

    @Override
    public String toString() {
        return "d" + depth + "_x" + x + "_y" + y;
    }

    public void setLrlat(double lrlat) {
        this.lrlat = lrlat;
    }


}
