import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int n;
    private int m;
    private int[] arr;
    private StringBuilder answer;
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer infoToken = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(infoToken.nextToken());
        m = Integer.parseInt(infoToken.nextToken());
        arr = new int[m];
        answer = new StringBuilder();
        dfs(0, 1);
        System.out.println(answer);
    }

    // 현재 고르는 숫자의 범위를 한정시키기 위한 largestPick
    private void dfs(int level, int largestPick){
        if (level == m){
            for (int i = 0; i < m; i++) {
                answer.append(arr[i]).append(' ');
            }

        }else for (int i = largestPick; i < n + 1; i++) {
            arr[level] = i;
            dfs(level + 1, i);
        }
    }
    public static void main(String[] args) throws IOException {
        new  Main().solution();
    }
}