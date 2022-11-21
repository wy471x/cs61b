import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class provides all code necessary to take a query box and produce
 * a query result. The getMapRaster method must return a Map containing all
 * seven of the required fields, otherwise the front end code will probably
 * not draw the output correctly.
 */
public class Rasterer {

    private static final int EACH_DEGREE_OF_LON_MAP_DISTANCE = 288200;

    public Rasterer() {
        // YOUR CODE HERE
    }

    /**
     * Takes a user query and finds the grid of images that best matches the query. These
     * images will be combined into one big image (rastered) by the front end. <br>
     *
     *     The grid of images must obey the following properties, where image in the
     *     grid is referred to as a "tile".
     *     <ul>
     *         <li>The tiles collected must cover the most longitudinal distance per pixel
     *         (LonDPP) possible, while still covering less than or equal to the amount of
     *         longitudinal distance per pixel in the query box for the user viewport size. </li>
     *         <li>Contains all tiles that intersect the query bounding box that fulfill the
     *         above condition.</li>
     *         <li>The tiles must be arranged in-order to reconstruct the full image.</li>
     *     </ul>
     *
     * @param params Map of the HTTP GET request's query parameters - the query box and
     *               the user viewport width and height.
     *
     * @return A map of results for the front end as specified: <br>
     * "render_grid"   : String[][], the files to display. <br>
     * "raster_ul_lon" : Number, the bounding upper left longitude of the rastered image. <br>
     * "raster_ul_lat" : Number, the bounding upper left latitude of the rastered image. <br>
     * "raster_lr_lon" : Number, the bounding lower right longitude of the rastered image. <br>
     * "raster_lr_lat" : Number, the bounding lower right latitude of the rastered image. <br>
     * "depth"         : Number, the depth of the nodes of the rastered image <br>
     * "query_success" : Boolean, whether the query was able to successfully complete; don't
     *                    forget to set this to true on success! <br>
     */
    public Map<String, Object> getMapRaster(Map<String, Double> params) {
        System.out.println(params);

        // input calc
        double queryResolution = Math.abs(params.get("lrlon") - params.get("ullon"))
                * EACH_DEGREE_OF_LON_MAP_DISTANCE / params.get("w");
        double queryLonDPP = Math.abs(params.get("lrlon") - params.get("ullon")) / params.get("w");

        double initResolution = Math.abs(MapServer.ROOT_LRLON - MapServer.ROOT_ULLON)
                * EACH_DEGREE_OF_LON_MAP_DISTANCE / params.get("w");
        double initLonDPP = Math.abs(MapServer.ROOT_LRLON - MapServer.ROOT_ULLON) / params.get("w");

        // calc depth
        int depth = calcDepth(queryLonDPP, queryResolution, initLonDPP, initResolution);


        Map<String, Object> results = new HashMap<>();
        System.out.println("Since you haven't implemented getMapRaster, nothing is displayed in "
                           + "your browser.");
        results.put("depth", depth);

        // search raster grid
        int queryWidth = (int) Math.pow(2, depth), queryHeight = (int) Math.pow(2, depth);
        List<ArrayList<String>> grids = new ArrayList<>();
        Position queryPosition = new Position(params.get("ullon"), params.get("lrlon"), params.get("ullat"), params.get("lrlat"));
        for (int i = 0; i < queryWidth; i++) {
            ArrayList<String> grid = new ArrayList<>();
            for (int j = 0; j < queryHeight; j++) {
                // todo: get all grid
                Position searchPosition = new Position(MapServer.ROOT_ULLON + i * (MapServer.ROOT_LRLON - MapServer.ROOT_ULLON) / queryWidth,
                        MapServer.ROOT_ULLON + (i + 1) * (MapServer.ROOT_LRLON - MapServer.ROOT_ULLON) / queryWidth,
                        MapServer.ROOT_ULLAT + j * (MapServer.ROOT_ULLAT - MapServer.ROOT_LRLAT) / queryHeight,
                        MapServer.ROOT_ULLAT + (j + 1) * (MapServer.ROOT_ULLAT - MapServer.ROOT_LRLAT) / queryHeight);
                if (checkPositionInRange(queryPosition, searchPosition)) {
                    grid.add("d" + "x" + i + "_" + "y" + j);
                }
            }
            grids.add(grid);
        }
        String[][] strGrids = new String[grids.size()][grids.get(0).size()];
        int i = 0;
        for (ArrayList arrayList : grids) {
            strGrids[i++] = (String[]) arrayList.toArray();
        }
        results.put("render_grid", strGrids);




//        results.put("raster_ul_lon", -122.24212646484375);
//        results.put("raster_lr_lon", -122.24006652832031);
//        results.put("raster_lr_lat", 37.87538940251607);
//        results.put("raster_ul_lat", 37.87701580361881);
//        results.put("query_success", true);
//        results.put("depth", 7);
//        String[][] grids = new String[][]{{"d7_x84_y28.png", "d7_x85_y28.png", "d7_x86_y28.png"}, {"d7_x84_y29.png", "d7_x85_y29.png", "d7_x86_y29.png"}, {"d7_x84_y30.png", "d7_x85_y30.png", "d7_x86_y30.png"}};
//        results.put("render_grid", grids);
        return results;
    }

    private int calcDepth(double queryLonDPP, double queryResolution, double initLonDPP, double initResolution) {
        int i = 0;
        while (i < 8) {
            double depthLonDPP = initLonDPP / Math.pow(2 , i), depthResolution = initResolution / Math.pow(2, i);
            if (depthLonDPP <= queryLonDPP && depthResolution <= queryResolution) {
                return i;
            }
            i++;
        }
        return i;
    }

    private boolean checkPositionInRange(Position queryPosition, Position searchPosition) {
        // up
        if (searchPosition.getUllat() >= queryPosition.getUllat()
                && searchPosition.getLrlat() <= queryPosition.getUllat()) {
            return true;
        }

        // left
        if (searchPosition.getUllon() <= queryPosition.getUllon()
                && searchPosition.getLrlon() >= queryPosition.getUllon()) {
            return true;
        }

        // right
        if (searchPosition.getUllon() <= queryPosition.getLrlon()
                && searchPosition.getLrlon() >= queryPosition.getLrlon()) {
            return true;
        }

        // down
        if (searchPosition.getUllat() >= queryPosition.getLrlat()
                && searchPosition.getLrlat() <= queryPosition.getUllat()) {
            return true;
        }

        // otherwise
        return false;
    }

}
