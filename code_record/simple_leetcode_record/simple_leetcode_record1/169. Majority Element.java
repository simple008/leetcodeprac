/*Created by ${USER} on ${DATE}.
 *���⣺ �����д���һ�����ִ�������һ���Ԫ�� �����Ԫ��
 *ע�⣺
 *˼·����ָoffer�е�
 *һˢ��
 *��ˢ����Ƚ�ָoffer ����һЩ ����Ҫ�ٿ���һЩ�������  �������ʣ�µ�������Ƿ�һ���ǳ�����1/2��
 *���Ӷȷ�����
 *��˼��
 */
//��һ��

public class Solution {
    public int majorityElement(int[] array) {

        if(array.length==0) return 0 ;
        int count=0;
        int pre=0;
        for(int i=0;i<array.length;i++){
            if(count==0){
                pre=array[i];
                count=1;
            }
            else if(pre==array[i])
                count++;
            else count--;
        }
        return pre;
    }
}
// �ڶ���
class Solution {
    public int majorityElement(int[] nums) {

        int times = 1;
        int pre = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(times == 0){
                pre = nums[i];
                times = 1;
                continue;
            }
            if(nums[i] == pre){
                times++;
            }else{
                times--;
            }

        }
        return pre;
    }
}