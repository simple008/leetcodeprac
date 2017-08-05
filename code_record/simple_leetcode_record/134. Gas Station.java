/*Created by ${USER} on ${DATE}.
 *���⣺����վ���⣬�ܷ�תȦ
 *ע�⣺
 *˼·�����ڵ����ܵ���һվ����������˰�������Ϊ��ʼλ�õ�ǰһ������¼һ���ܵĺ��ж��Ƿ���Ե���
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */
//��һ��
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int i=0;
        int left=0;
        int beg=0;
        int total=0;
        while(i<gas.length){
            left+=gas[i]-cost[i];
            total+=gas[i]-cost[i];//totalΪ����֤���������Ƿ�gas>cost
            if(left<0){
                beg=i+1;
                left=0;
            }
            i++;
        }
        if(total>=0) return beg;
        else return -1;
    }
}

// �ڶ���
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = -1;
        int sum = 0;
        int count = 0;
        int total = 0;
        for(int i = 0; i < gas.length; i++){
            total += gas[i]-cost[i];
            if(sum + gas[i] < count + cost[i]){
                start = i;
                sum = 0;
                count = 0;
            }else{
                sum += gas[i];
                count += cost[i];
            }

        }

        if(total < 0) return -1;
        else return ++start;

    }
}