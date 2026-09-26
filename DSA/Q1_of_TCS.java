import java.util.Scanner;

public class Q1_of_TCS {
    public static void main(String[] args) {
        int n ,target , result = 0 , prev_value = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            int value = sc.nextInt();
            arr[i] = value;
        }

        target = sc.nextInt();
        // for(int i=0; i<n; i++){
        //     System.out.print(arr[i] + " ");
        // }
        // System.out.println();

        for(int i=0;i<n;i++){
            if(arr[i]<target){
                prev_value++;
                result = result + prev_value;
            }
        }
        System.out.println("Number of elements less than target: " + result);

    }
}
