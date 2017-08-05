package nowcoder;

/**
 * Created by lpeiz on 2017/4/21.
 */
public class huawei_1 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();
//        int n = sc.nextInt();
//        int [][]arr = new int[m][n];
//
//        for(int i = 0; i < m; m++){
//            for(int j = 0; j < n; n++){
//                arr[i][j] = sc.nextInt();
//            }
//        }
        int m=2;
        int n=4;
        int arr[][]={{1,2,3,40},{6,7,8,90}};

        int [][]dp = new int[m][n];
        dp[0][0] = arr[0][0];
        for (int i = 1;i<m;i++){
            dp[i][0] = arr[i][0]+dp[i-1][0];
        }
        for (int i = 1;i<n;i++){
            dp[0][i] = arr[0][i]+dp[0][i-1];
        }
        for(int i = 1; i < m; i++){
            for(int j = 1;j < n; j++){
                dp[i][j] = arr[i][j]+Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        System.out.println(dp[m-1][n-1]);
    }
}
