package bishi.fw;

/**
 * Created by lpeiz on 2017/9/26.
 */
public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] weight = {3,5,2,6}; //��Ʒ����
        int[] val = {1,3,1,1000000}; //��Ʒ��ֵ
        int m = 12; //��������
        int n = val.length; //��Ʒ����

        int[] f = new int[m+1];
        for(int i=1;i<f.length;i++){     //��װ����f[0]=0,f[1...m]����ʼ��Ϊ����С
            f[i] = Integer.MIN_VALUE;
        }
        for(int i=0;i<n;i++){
            for(int j=f.length-1;j>=weight[i];j--){
                f[j] = Math.max(f[j], f[j-weight[i]]+val[i]);
            }
        }
        for(int i=0;i<f.length;i++){
            System.out.print(f[i]+" ");
        }
        System.out.println();
        System.out.println("����ֵΪ"+f[f.length-1]);
    }
}
