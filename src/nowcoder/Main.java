package nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * 在这记录一下牛客网答题所需要的模板背
 * Created by lpeiz on 2017/3/25.
 */
/*public class Main{
    public static void main(String[]args){
        Scanner in = new Scanner (System.in);
        int r2=in.nextInt();
        System.out.println(solve(r2));
        in.close();
    }

    public static int solve(int r2){
        int count=0;
        HashMap map = new HashMap<>();
        HashSet set = new HashSet();
        ArrayList list = new ArrayList();
        list.add
        set.contains(a)
        for(int i=0;i*i<r2;i++){
            int x2=i*i;
            int y2=(int)Math.sqrt(r2-x2);
            if((y2*y2+x2)==r2){
                count++;
            }
        }
        return count*4;
    }

}*/

public class Main {
    public static List<char[][]> number = new ArrayList<char[][]>();
    public static List<char[][]> symbol = new ArrayList<char[][]>();

    public static void init() {
        char[][] number_1 = new char[5][1];
        for (int i = 0; i < 5; i++) {
            number_1[i][0] = '*';
        }
        number.add(number_1);

        char[][] number_2 = new char[5][3];
        char[][] number_3 = new char[5][3];
        char[][] number_5 = new char[5][3];
        char[][] number_6 = new char[5][3];
        char[][] number_8 = new char[5][3];
        char[][] number_9 = new char[5][3];
        for (int i = 0; i < 5; i++) {
            if (i == 0 || i == 2 || i == 4) {
                for (int j = 0; j < 3; j++) {
                    number_2[i][j] = '*';
                    number_3[i][j] = '*';
                    number_5[i][j] = '*';
                    number_6[i][j] = '*';
                    number_8[i][j] = '*';
                    number_9[i][j] = '*';
                }
            }
            if (i == 1) {
                number_2[i][2] = '*';
                number_3[i][2] = '*';
                number_8[i][2] = '*';
                number_9[i][2] = '*';

                number_5[i][0] = '*';
                number_6[i][0] = '*';
                number_8[i][0] = '*';
                number_9[i][0] = '*';
            }
            if (i == 3) {
                number_2[i][0] = '*';
                number_6[i][0] = '*';
                number_8[i][0] = '*';

                number_3[i][2] = '*';
                number_5[i][2] = '*';
                number_6[i][2] = '*';
                number_8[i][2] = '*';
                number_9[i][2] = '*';
            }
        }
        number.add(number_2);
        number.add(number_3);

        char[][] number_4 = new char[5][3];
        for (int i = 0; i < 5; i++) {
            if (i == 0 || i == 1) {
                number_4[i][0] = '*';
                number_4[i][2] = '*';
            }
            if (i == 2) {
                for (int j = 0; j < 3; j++) {
                    number_4[i][j] = '*';
                }
            }
            if (i == 3 || i == 4) {
                number_4[i][2] = '*';
            }
        }
        number.add(number_4);
        number.add(number_5);
        number.add(number_6);

        char[][] number_7 = new char[5][3];
        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                for (int j = 0; j < 3; j++) {
                    number_7[i][j] = '*';
                }
            } else {
                number_7[i][2] = '*';
            }
        }
        number.add(number_7);
        number.add(number_8);
        number.add(number_9);

        char[][] number_0 = new char[5][3];
        for (int i = 0; i < 5; i++) {
            if (i == 0 || i == 4) {
                for (int j = 0; j < 3; j++) {
                    number_0[i][j] = '*';
                }
            } else {
                number_0[i][0] = '*';
                number_0[i][2] = '*';
            }
        }

        number.add(number_0);

        char[][] add = new char[5][3];
        add[1][1] = '*';
        add[2][0] = '*';
        add[2][1] = '*';
        add[2][2] = '*';
        add[3][1] = '*';
        symbol.add(add);

        char[][] minus = new char[5][3];
        minus[2][0] = '*';
        minus[2][1] = '*';
        minus[2][2] = '*';
        symbol.add(minus);

        char[][] times = new char[5][3];
        times[1][0] = '*';
        times[1][2] = '*';
        times[2][1] = '*';
        times[3][0] = '*';
        times[3][2] = '*';
        symbol.add(times);

        char[][] div = new char[5][3];
        div[1][2] = '*';
        div[2][1] = '*';
        div[3][0] = '*';
        symbol.add(div);

        char[][] equals = new char[5][4];
        for (int i = 0; i < 4; i++) {
            equals[1][i] = '*';
            equals[3][i] = '*';
        }
        symbol.add(equals);

        char[][] point = new char[5][2];
        for (int i = 0; i < 2; i++) {
            point[3][i] = '*';
            point[4][i] = '*';
        }
        symbol.add(point);

       /* for(char[][] ch : number){
            System.out.println();
            for(int i = 0; i < ch.length;i++){
                for(int j = 0; j < ch[i].length; j++){
                    if(ch[i][j]=='*')
                        System.out.print(ch[i][j]);
                    else System.out.print(' ');
                }
                System.out.println();
            }
        }
*/
    /*    for(char[][] ch : symbol){
            System.out.println();
            for(int i = 0; i < ch.length;i++){
                for(int j = 0; j < ch[i].length; j++){
                    if(ch[i][j]=='*')
                        System.out.print(ch[i][j]);
                    else System.out.print(' ');
                }
                System.out.println();
            }
        }*/

    }
    public static void printnum(int n){
        if(n==0) n = 9;
        else n=n-1;
        char[][] ch=number.get(n);
        for(int i = 0; i < ch.length;i++){
            for(int j = 0; j < ch[i].length; j++){
                if(ch[i][j]=='*')
                    System.out.print(ch[i][j]);
                else System.out.print(' ');
            }
            System.out.println();
        }
    }
    public static void printop(int n){
//        if(n==0) n = 9;
//        else n=n-1;
        char[][] ch=symbol.get(n);
        for(int i = 0; i < ch.length;i++){
            for(int j = 0; j < ch[i].length; j++){
                if(ch[i][j]=='*')
                    System.out.print(ch[i][j]);
                else System.out.print(' ');
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        init();
        printnum(0);
        Scanner in = new Scanner(System.in);
        in.next();
    }
}


