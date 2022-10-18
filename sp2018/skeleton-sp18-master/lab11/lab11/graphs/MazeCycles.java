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
    private Maze maze;
    private int[] nodeTo;
    private boolean isFound = false;

    public MazeCycles(Maze m) {
        super(m);
        maze = m;
        nodeTo = new int[maze.V()];
    }

    @Override
    public void solve() {
        // TODO: Your code here!
        dfsRecursive(-1, 0);
//        dfsNonRecursive(0);
    }

    // Helper methods go here
    private void dfsRecursive(int u, int v) {
        marked[v] = true;
        announce();
        for (int w : maze.adj(v)) {
            if (!marked[w]) {
                nodeTo[w] = v;
                dfsRecursive(v, w);
            } else if (w != u) {
                edgeTo[w] = v;
                announce();
                for (int x = v; x != w; x = nodeTo[x]) {
                    edgeTo[x] = nodeTo[x];
                    announce();
                }
                isFound = true;
            }
            if (isFound) return;
        }
    }

    private void dfsNonRecursive(int s) {
        Iterator<Integer>[] adj = new Iterator[maze.V()];
        for (int i = 0; i < maze.V(); i++) {
            adj[i] = maze.adj(i).iterator();
        }

        Stack<Integer> stack = new Stack<>();
        marked[s] = true;
        stack.push(s);
        int p = -1;
        while (!stack.isEmpty()) {
            int v = stack.peek();
            if (adj[v].hasNext()) {
                int w = adj[v].next();
                if (!marked[w]) {
                    marked[w] = true;
                    nodeTo[w] = v;
                    p = v;
                    stack.push(w);
                } else if (w != p) {
                    edgeTo[w] = v;
                    announce();
                    for (int x = v; x != w; x = nodeTo[x]) {
                        edgeTo[x] = nodeTo[x];
                        announce();
                    }
                    isFound = true;
                }
            } else {
                stack.pop();
            }
            if (isFound) return;
        }
    }
}

