import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    if (n <= 1){
        System.out.println(n);
    }
    else{
        int arr[] = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        System.out.println(arr[n]); 
    }
 }

}
