package lab11.graphs;

import edu.princeton.cs.algs4.Stack;

import java.util.Iterator;

/**
 *  @author Josh Hug
 */
public class MazeCycles extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;

    public MazeCycles(Maze m) {
        super(m);
        maze = m;
        s = maze.xyTo1D(1, 1);
        t = maze.xyTo1D(maze.N(), maze.N());
        distTo[s] = 0;
        edgeTo[s] = s;
    }

    @Override
    public void solve() {
        // TODO: Your code here!
        dfs();
    }

    // Helper methods go here
    private boolean dfs() {
        Iterator<Integer>[] adj = new Iterator[maze.V()];
        for (int i = 0; i < maze.N(); i++) {
            adj[i] = maze.adj(i).iterator();
        }

        Stack<Integer> stack = new Stack<>();
        marked[0] = true;
        stack.push(0);
        while (!stack.isEmpty()) {
            int e = stack.peek();
            if (adj[e].hasNext()) {
                int w = adj[e].next();
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = e;
                    announce();
                    if (w == t) {
                        return false;
                    }
                    distTo[w] = distTo[e] + 1;
                    stack.push(w);
                } else {
                    if (w != edgeTo[e]) {
                        return true;
                    }
                }
            } else {
                stack.pop();
            }
        }
        return false;
    }
}

