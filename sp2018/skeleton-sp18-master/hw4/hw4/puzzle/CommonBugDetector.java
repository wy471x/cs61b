package hw4.puzzle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by hug. See https://goo.gl/MVL8up for details on these puzzles.
 */
public class CommonBugDetector {
    public static class CommonBugPuzzleState implements WorldState {
        private char name;

        public CommonBugPuzzleState() {
            name = 's';
        }

        private CommonBugPuzzleState(char n) {
            name = n;
        }

        @Override
        public int estimatedDistanceToGoal() {
            if (name == 'g') {
                return 0;
            }
            if (name == 'x') {
                return 4;
            }
            return 1;
        }
//        List.of() supported by java 9
//        @Override
//        public Iterable<WorldState> neighbors() {
//            switch (name) {
//                case('s'): return createWorldStateList(List.of('a', 'x'));
//                case('a'): return createWorldStateList(List.of('b'));
//                case('b'): return createWorldStateList(List.of('c'));
//                case('c'): return createWorldStateList(List.of('d'));
//                case('d'): return createWorldStateList(List.of('e'));
//                case('e'): return createWorldStateList(List.of('g'));
//                case('x'): return createWorldStateList(List.of('c'));
//                default: return null;
//            }
//        }

        @Override
        public Iterable<WorldState> neighbors() {
            switch (name) {
                case ('s'):
                    return createWorldStateList(Stream.of('a', 'x').collect(Collectors.toList()));
                case ('a'):
                    return createWorldStateList(Stream.of('b').collect(Collectors.toList()));
                case ('c'):
                    return createWorldStateList(Stream.of('d').collect(Collectors.toList()));
                case ('d'):
                    return createWorldStateList(Stream.of('e').collect(Collectors.toList()));
                case ('e'):
                    return createWorldStateList(Stream.of('g').collect(Collectors.toList()));
                case ('b'):
                case ('x'):
                    return createWorldStateList(Stream.of('c').collect(Collectors.toList()));
                default:
                    return null;
            }
        }

        private static List<WorldState> createWorldStateList(List<Character> lc) {
            List<WorldState> lws = new ArrayList<>();
            for (char c : lc) {
                lws.add(new CommonBugPuzzleState(c));
            }
            return lws;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            CommonBugPuzzleState that = (CommonBugPuzzleState) o;
            return name == that.name;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }


    public static void main(String[] args) {
        CommonBugPuzzleState cbps = new CommonBugPuzzleState();
        Solver s = new Solver(cbps);

        // s.moves() should be 5
        System.out.println("s.moves() should be 5, and your s.moves() is: " + s.moves());

        AlphabetEasyPuzzle aep = new AlphabetEasyPuzzle('a');
        Solver s3 = new Solver(aep);
        System.out.println("TODO: Print out the number of total things ever"
                + " enqueued in your MinPQ and compare to the comments.");
        // if you print out the total number of items enqueued by s3
        // it should be approximately 25, not approximately 50.
    }
}
