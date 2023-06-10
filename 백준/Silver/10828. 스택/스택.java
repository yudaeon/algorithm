import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    
        Stack<Integer> a = new Stack<>();

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String[] input = br.readLine().split(" ");

            switch (input[0]) {

                case "push":
                    a.push(Integer.parseInt(input[1]));
                    break;

                case "pop":
                    if (a.empty()) {
                        bw.write("-1" + "\n");
                    } else {
                        bw.write(a.pop() + "\n");
                    }
                    break;
                case "size":
                    bw.write(a.size() + "\n");
                    break;

                case "empty":
                    if (a.empty()) {
                        bw.write("1" + "\n");
                    } else {
                        bw.write("0" + "\n");
                    }
                    break;
                case "top":
                    if (a.empty()) {
                        bw.write("-1" + "\n");
                    } else {
                        bw.write(a.peek() + "\n");
                    }
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
        
