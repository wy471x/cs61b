package byog.lab5;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {

    /**
     * Random generator.
     */
    private static final Random RANDOM = new Random(1000);

    /**
     * The width of screen.
     */
    private static final int WIDTH = 28;

    /**
     * The height of screen.
     */
    private static final int HEIGHT = 30;

    /**
     * Computes the width of row i for a size s hexagon.
     * @param s The size of the hex.
     * @param i The row number where i = 0 is the bottom row.
     * @return
     */
    public static int hexRowWidth(int s, int i) {
        int effectiveI = i;
        if (i >= s) {
            effectiveI = 2 * s - 1 - effectiveI;
        }

        return s + 2 * effectiveI;
    }

    /**
     * Computesrelative x coordinate of the leftmost tile in the ith
     * row of a hexagon, assuming that the bottom row has an x-coordinate
     * of zero. For example, if s = 3, and i = 2, this function
     * returns -2, because the row 2 up from the bottom starts 2 to the left
     * of the start position, e.g.
     *   xxxx
     *  xxxxxx
     * xxxxxxxx
     * xxxxxxxx <-- i = 2, starts 2 spots to the left of the bottom of the hex
     *  xxxxxx
     *   xxxx
     *
     * @param s size of the hexagon
     * @param i row num of the hexagon, where i = 0 is the bottom
     * @return
     */
    public static int hexRowOffset(int s, int i) {
        int effectiveI = i;
        if (i >= s) {
            effectiveI = 2 * s - 1 - effectiveI;
        }

        return -effectiveI;
    }

    /** Adds a row of the same tile.
     * @param world the world to draw on
     * @param p the leftmost position of the row
     * @param width the number of tiles wide to draw
     * @param t the tile to draw
     */
    public static void addRow(TETile[][] world, Position p, int width, TETile t) {
        for (int xi = 0; xi < width; xi += 1) {
            int xCoord = p.x + xi;
            int yCoord = p.y;
            world[xCoord][yCoord] = TETile.colorVariant(t, 32, 32, 32, RANDOM);
        }
    }

    /**
     * Adds a hexagon to the world.
     * @param world the world to draw on
     * @param p the bottom left coordinate of the hexagon
     * @param s the size of the hexagon
     * @param t the tile to draw
     */
    public static void addHexagon(TETile[][] world, Position p, int s, TETile t) {

        if (s < 2) {
            throw new IllegalArgumentException("Hexagon must be at least size 2.");
        }

        // hexagons have 2*s rows. this code iterates up from the bottom row,
        // which we call row 0.
        for (int yi = 0; yi < 2 * s; yi += 1) {
            int thisRowY = p.y + yi;

            int xRowStart = p.x + hexRowOffset(s, yi);
            Position rowStartP = new Position(xRowStart, thisRowY);

            int rowWidth = hexRowWidth(s, yi);

            addRow(world, rowStartP, rowWidth, t);

        }
    }

    /**
     * Drawing single hexagon.
     * @param world
     */
    public static void drawSingleHexagon(TETile[][] world) {
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }
        Position p = new Position(3, 24);
        addHexagon(world, p, 3, Tileset.LETTER);

        p = new Position(12, 22);
        addHexagon(world, p, 4, Tileset.LETTER);

        p = new Position(24, 20);
        addHexagon(world, p, 5, Tileset.LETTER);
    }

    /**
     * Drawing tesselation hexagon.
     * @param world
     */
    public static void drawTesselationHexagons(TETile[][] world) {
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }

        // tree
        Position[] treePositions = new Position[3];
        treePositions[0] = new Position(12, 24);
        treePositions[1] = new Position(22, 12);
        treePositions[2] = new Position(17, 9);
        for (Position position : treePositions) {
            addHexagon(world, position, 3, Tileset.TREE);
        }

        // sand
        Position[] sandPositions = new Position[2];
        sandPositions[0] = new Position(22, 6);
        sandPositions[1] = new Position(17, 15);
        for (Position position : sandPositions) {
            addHexagon(world, position, 3, Tileset.SAND);
        }

        // flower
        Position[] flowerPosition = new Position[3];
        flowerPosition[0] = new Position(17, 21);
        flowerPosition[1] = new Position(22, 18);
        flowerPosition[2] = new Position(7, 3);
        for (Position position : flowerPosition) {
            addHexagon(world, position, 3, Tileset.FLOWER);
        }

        // mountain
        Position[] mountainPositions = new Position[8];
        mountainPositions[0] = new Position(12, 18);
        mountainPositions[1] = new Position(12, 12);
        mountainPositions[2] = new Position(12, 6);
        mountainPositions[3] = new Position(12, 0);
        mountainPositions[4] = new Position(17, 3);
        mountainPositions[5] = new Position(2, 18);
        mountainPositions[6] = new Position(7, 15);
        mountainPositions[7] = new Position(7, 9);
        for (Position position : mountainPositions) {
            addHexagon(world, position, 3, Tileset.MOUNTAIN);
        }

        // grass
        Position[] grassPositions = new Position[3];
        grassPositions[0] = new Position(2, 12);
        grassPositions[1] = new Position(2, 6);
        grassPositions[2] = new Position(7, 21);
        for (Position position : grassPositions) {
            addHexagon(world, position, 3, Tileset.GRASS);
        }
    }

    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        TETile[][] world = new TETile[WIDTH][HEIGHT];
        drawTesselationHexagons(world);

        ter.renderFrame(world);
    }

}
