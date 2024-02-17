import java.util.Scanner;
public class backTrackingProblem_01 {
    public static int grid(int x, int y, int m, int n){
        if(x == m && y == n){
            return 1;
        }
        else if(x <= m && y <= n){
            return grid(x+1, y, m, n) + grid(x, y+1, m, n);
        }
        else{
            return 0; 
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the values of m and n:");
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int result = grid(1,1, m, n);
        System.out.println("Result: "+ result);

        scanner.close();
    }
}