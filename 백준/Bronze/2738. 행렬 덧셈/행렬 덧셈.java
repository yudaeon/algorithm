
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    // 행렬의 크기 N, M이 주어진다.
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();

    // 둘째줄부터 N개의 줄에 행렬 A의 원소 M개가 차례대로 주어진다.
    int[][] arr1 = new int[n][m];
    int[][] arr2 = new int[n][m];
    // n과 m은 100보다 작거나 같고, 행렬의 원소는 절대값이 100보다 작거나 같은 정수이다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr1[i][j] = sc.nextInt();
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr2[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr1[i][j] + arr2[i][j] + " ");
                if (j == m-1)
                    System.out.println();
            }
        }
    }
}
