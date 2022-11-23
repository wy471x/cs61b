import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yongwan
 * @date 2022/11/23
 * @desc
 */
public class Graph {
    private String minLat;
    private String minLon;
    private String maxLat;
    private String maxLon;

    private Map<String, Node> nodes;

    private Map<String, Way> ways;

    public Graph(String minLat, String minLon, String maxLat, String maxLon) {
        this.minLat = minLat;
        this.minLon = minLon;
        this.maxLat = maxLat;
        this.maxLon = maxLon;
        this.nodes = new HashMap<>();
        this.ways = new HashMap<>();
    }

    public void addNode(Node node) {
        this.nodes.put(node.id, node);
    }

    public void addWay(Way way) {
        this.ways.put(way.id, way);
    }

    public class Node {
        private String id;
        private double lat;
        private double lon;

        private Map<String, String> extraInfo;

        public Node(String id, double lat, double lon) {
            this.id = id;
            this.lat = lat;
            this.lon = lon;
            this.extraInfo = new HashMap<>();
        }
    }

    public class Way {
        private String id;
        private Map<String, String> extraInfo;
        private Set<String> nodeIds;

        public Way(String id) {
            this.id = id;
            this.extraInfo = new HashMap<>();
            this.nodeIds = new HashSet<>();
        }
    }
}
