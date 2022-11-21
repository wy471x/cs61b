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

    public void setLrlat(double lrlat) {
        this.lrlat = lrlat;
    }
}
