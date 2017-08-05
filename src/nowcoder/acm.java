package nowcoder;

/**
 * Created by lpeiz on 2017/4/7.
 */
public class acm{
    public static void main(String []args){
       /* Scanner in = new Scanner(System.in);
        int n = in.nextInt();*/
        int n=4;
        double []p = new double[n+1];
        double [][]dp = new double[n+5][n+5];
        /*for(int i = 0; i < n; i++){
            p[i] = in.nextInt()*1.0/100;
        }*/

        p[0]=0;
        p[1]=50;
        p[2]=50;
        p[3]=50;
        p[4]=50;
//        p[4]=50;
        int pass = (int)Math.ceil(n * 0.6);
        System.out.println(pass);
        dp[1][1] = p [1];
        dp[1][0] = 1- dp[1][1];
        for(int i = 2; i <= n; i++){
            dp[i][0]=1;
            for(int j = 1; j <= i; j++)
                dp[i][0]*=(1-p[j]);
            for(int j = 1; j <=i; j++)
                dp [i][j] = dp[i-1][j-1]*p[i] + dp[i-1][j]*(1-p[i]);

        }

        double res=0;
        for (int i = pass ; i<= n;i++){
            System.out.println(dp[n][i]);
            res += dp[n][i];}
//            System.out.printf("%.5lf\n",res);
            System.out.println(res);


    }
}


