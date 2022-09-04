import java.util.*;

public class PacificAtlanticWaterFlow {

    //https://leetcode.com/problems/pacific-atlantic-water-flow/

    public static void main(String[] args) {
        System.out.println("Pacific Atlantic Water Flow");

        List<List<Integer>> heights = new ArrayList<>(List.of(
                List.of(1, 2, 2, 3, 5),
                List.of(3, 2, 3, 4, 4),
                List.of(2, 4, 5, 3, 1),
                List.of(6, 7, 1, 4, 5),
                List.of(5, 1, 1, 2, 4)
        ));

        System.out.println(pacificAtlantic(heights.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new)));
        System.out.println();
        System.out.println(alternativeSolution(heights));
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];

        for (int col = 0; col< cols; col++){
            dfs(0, col, rows, cols, pac, heights[0][col], heights);
            dfs(rows-1, col,rows, cols, atl, heights[rows-1][col], heights);
        }

        for (int row = 0; row<rows; row++){
            dfs(row, 0,rows, cols, pac, heights[row][0], heights);
            dfs(row, cols-1,rows, cols, atl, heights[row][cols-1], heights);
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++){
                if (pac[i][j] && atl[i][j])
                    result.add(Arrays.asList(i,j));
            }
        return result;
    }

    private static void dfs(int row, int col, int rows, int cols, boolean[][] visited, int prevHeight, int[][] heights){
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || prevHeight > heights[row][col])
            return;
        visited[row][col]= true;
        dfs(row+1, col, rows, cols, visited, heights[row][col], heights);
        dfs(row-1, col, rows, cols, visited, heights[row][col], heights);
        dfs(row, col+1, rows, cols, visited, heights[row][col], heights);
        dfs(row, col-1, rows, cols, visited, heights[row][col], heights);

    }

    public static List<List<Integer>>  alternativeSolution(List<List<Integer>> heights) {
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < heights.size(); i++) {
            int max = heights.get(i).stream().max(Integer::compareTo).orElse(0);
            for (int j = 0; j < heights.get(i).size(); j++) {
                int current = heights.get(i).get(j);
                int north = i > 0 ? heights.get(i - 1).get(j) : 0;
                int south = i + 1 < heights.size() ? heights.get(i + 1).get(j) : 0;
                int west = j > 0 ? heights.get(i).get(j - 1) : 0;
                int east = j + 1 < heights.get(i).size() ? heights.get(i).get(j + 1) : 0;

                if (current == max && (current >= north || current >= south || current >= west || current >= east)) {
                    result.add(List.of(i, j));
                }
            }
        }

        int t = 0;
        //System.out.println(temp);

        for (int i = 0; i < heights.size(); i++) {
            for (int j = 0; j < heights.get(i).size(); j++) {
                int max = heights.get(j).stream().max(Integer::compareTo).orElse(0);
                int current = heights.get(j).get(i);
                int north = j > 0 ? heights.get(j - 1).get(j) : 0;
                int south = j + 1 < heights.size() ? heights.get(j + 1).get(i) : 0;
                int west = i > 0 ? heights.get(j).get(i - 1) : 0;
                int east = i + 1 < heights.get(j).size() ? heights.get(j).get(i + 1) : 0;

                if (current == max && (current > north || current > south || current > west || current > east)) {
                    result.add(List.of(i, j));
                }
            }
        }

        return result.stream().toList();
    }
}
