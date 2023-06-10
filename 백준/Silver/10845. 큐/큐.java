

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new LinkedList<Integer>();
        int val1 = 0;

        int num1 = Integer.parseInt(br.readLine());
        for (int i = 0; i < num1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            switch (s){
             
                case "push" :
                    int num2 = Integer.parseInt(st.nextToken());
                    q.add(num2);
                    val1 = num2;
                    break;
              
                case "pop" :
                    if (q.isEmpty()){
                        sb.append("-1\n");
                    }else {
                        sb.append(q.remove()+"\n");
                    }
                    break;
             
                case "size" :
                    sb.append(q.size() + "\n");
                    break;
                
                case "empty" :
                    if (q.isEmpty()) sb.append("1\n");
                    else sb.append("0\n");
                    break;
               
                case "front" :
                    if (q.isEmpty()) sb.append("-1\n");
                    else sb.append(q.peek() + "\n");
                    break;
 
                case "back" :
                    if (q.isEmpty()) sb.append("-1\n");
                    else sb.append(val1 + "\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
