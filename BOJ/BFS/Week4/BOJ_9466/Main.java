import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static int BFS(int num, int[] select){
    int start;
    int count;
    int prev;
    int answer = num;
    Queue<Integer> queue = new LinkedList<>();
    int[] visited = new int[num+1];
    for(int i=1;i<=num;i++){
      if(visited[i]==2){
        continue;
      }
      prev = i;
      queue.add(prev);
      visited[prev] = 1;
      while(true){
        if(select[prev]==i){
          while(!queue.isEmpty()){
            visited[queue.poll()]=2;
          }
          break;
        }
        if(visited[select[prev]]==1){
          while(!queue.isEmpty()){
            visited[queue.poll()]=0;
          }
          break;
        }
        if(visited[select[prev]]!=0){
          continue;
        }
        prev = select[prev];
        visited[prev] = 1;
        queue.add(prev);
      }
    }
    for(int i=1;i<=num;i++){
      if(visited[i]==2){
        answer--;
      }
    }
    return answer;
  }
  public static void main(String[] args) throws IOException{
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int Testcase = Integer.parseInt(br.readLine());
    int num;
    int[] select;
    int[] answerArr = new int[Testcase];
    for(int t=0;t<Testcase;t++){
      num = Integer.parseInt(br.readLine());
      select = new int[num+1];
      st=new StringTokenizer(br.readLine());
      for(int i=1;i<=num;i++){
        select[i] = Integer.parseInt(st.nextToken());
      }
      answerArr[t] = BFS(num,select);
    }
    for(int t=0;t<Testcase;t++){
      bw.write(answerArr[t]+"\n");
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
