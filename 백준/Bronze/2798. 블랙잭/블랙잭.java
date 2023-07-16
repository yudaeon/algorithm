
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public int solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(reader.readLine());
        int cardCount = Integer.parseInt(info.nextToken());
        int target = Integer.parseInt(info.nextToken());

        StringTokenizer cardTokens = new StringTokenizer(reader.readLine());
        int[] cards = new int[cardCount];
        for (int i = 0; i < cardCount; i++) {
            cards[i] = Integer.parseInt(cardTokens.nextToken());
        }

        // 3장의 카드를 뽑는다
        int max = 0;
        //첫번째 카드 -> n 장의 카드가 있다면 첫번쨰는 n-2 까지
        for (int i = 0; i < cardCount - 2; i++) {
            // 두번째 카드 -> 두번쨰는 n-1 까지
            for (int j = i + 1; j < cardCount - 1; j++) {
                // 세번쨰 카드 -> 세번쨰는 n 까지
                for (int k = j + 1; k < cardCount; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if (sum <= target && sum > max)
                        max = sum;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Main().solution());
    }
}