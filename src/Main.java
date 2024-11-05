import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] maze;
    static boolean[][] visited;
    static int n, m;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }

    public static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { x, y });
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currX = current[0];
            int currY = current[1];

            for (int i = 0; i < 4; i++) {
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) {
                    if (!visited[nextX][nextY] && maze[nextX][nextY] == 1) {
                        queue.add(new int[] { nextX, nextY });
                        visited[nextX][nextY] = true;
                        maze[nextX][nextY] = maze[currX][currY] + 1;
                    }
                }
            }
        }

        return maze[n - 1][m - 1];
    }
}
