//求最大公约数
public class Divisor {

    public int getMaxDivisor(int[] array) {
        int minN = getMin(array);
        for (int j = minN; j >= 2; j--) {
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] % j == 0) {
                    count++;  //计算j是数组中多少个元素的因子，从数组中最小的元素开始逐个减1
                }
            }
            if (count == array.length) { //如果j是所有元素的因子
                return j;
            }
        }
        return -1;// 无最大公约数
    }

    public int getMin(int[] a) {
        if (a.length < 1) {
            return -1;
        }
        int min = a[0];
        for (int i = 0; i < a.length; i++) {
            if (min > a[i]) {
                min = a[i];
            }
        }
        return min;
    }
}
    //辗转相除算法，a%b  b%(a%b)
    public static int Method(int x,int y){
        int a,b,c;
        a=x;
        b=y;
        while(b!=0){
            c=a%b;
            a=b;
            b=c;
        }
        return a;
    }
for(int i = 0; i<a.length-1; i++){
        x=temp;
        y=a[i+1];
        temp=method(x,y);
        }