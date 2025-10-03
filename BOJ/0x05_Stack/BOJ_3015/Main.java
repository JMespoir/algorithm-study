import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    long[] arr = new long[N];

    for(int i=0;i<N;i++){
      arr[i] = Long.parseLong(br.readLine());
    }
    
    
    bw.flush();
    bw.close();
    br.close();
  }
}
