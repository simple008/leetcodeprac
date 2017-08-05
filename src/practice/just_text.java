package practice;

/**
 * Created by lpeiz on 2017/4/23.
 */
public class just_text {
    public static void main(String[]args){
        int a[]={1,1,1,2,2,2,10};
        System.out.println(singleNumber(a));
    }
    public static int singleNumber(int[] nums) {
        int len = nums.length, result = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < len; j++) {
                sum += (nums[j] >> i) & 1;
            }
            result += (sum % 3) << i;
        }
        return result;

    }
    
}
