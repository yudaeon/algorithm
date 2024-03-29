import java.io.*;
import java.util.*;


public class Main {
    //숫자 야구 응답 정보 관련 클래스
    static class info{
        int strike, ball;
        String num;
        public info(String num, int strike, int ball){
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }
    }
    static int N;
    static ArrayList<info> game = new ArrayList<>();	//숫자 야구 응답 저장 리스트
    static ArrayList<String> answer = new ArrayList<>();	//정답 가능한 숫자 저장 리스트
    static boolean[] numUsing;		//숫자 사용 여부 확인 배열
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        numUsing = new boolean[10];
        StringTokenizer st;
        //응답 관련 정보 저장
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            String num = st.nextToken();
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            game.add(new info(num, s, b));
        }
        search("", 0);	//숫자야구 모든 경우의 수 탐색
        bw.write(answer.size() + "");	//정답이 가능한 숫자개수 BufferedWriter 저장
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
    //숫자야구의 모든 경우 만드는 함수
    static void search(String num, int size){
        //완성된 경우 모든 응답 만족하는지 확인하기.
        if(size == 3){
            numCheck(num);
            return;
        }
        //숫자야구에 나올 수 있는 숫자 만들기.
        for(int i=1;i<=9;i++){
            if(!numUsing[i]){
                numUsing[i] = true;
                search(num + i, size + 1);
                numUsing[i] = false;
            }
        }
    }
    //숫자가 모든 응답에 만족하는지 확인하는 함수
    static void numCheck(String num){
        //모든 응답에 대하여 만족하는지 탐색
        for(info cur : game){
            int s = 0;
            int b = 0;
            //스트라이크 조건 만족하는지 확인
            for(int i=0;i<3;i++)
                if(cur.num.charAt(i) == num.charAt(i))
                    s++;

            if(cur.strike != s)
                return;
            //볼 조건 만족하는지 확인
            for(int i=0;i<3;i++){
                int temp = (i + 1) % 3;
                if(num.charAt(i) == cur.num.charAt(temp))
                    b++;
                temp = (i + 2) % 3;
                if(num.charAt(i) == cur.num.charAt(temp))
                    b++;
            }

            if(cur.ball != b)
                return;
        }
        //모든 조건 만족할 때 추가
        answer.add(num);
    }
}