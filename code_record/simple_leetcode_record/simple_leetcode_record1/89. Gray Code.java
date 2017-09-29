/*Created by ${USER} on ${DATE}.
 *���⣺������ ����
 *ע�⣺
 *˼·��00 01 --11 10 --110 111 101 100
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */
//��һ��
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> li=new ArrayList<Integer>();
        Stack<Integer> stack=new Stack<Integer>();

        if(n==1){
            li.add(0);
            li.add(1);
            return li;
        }
        // List<Integer> lastli=new List<Integer>();
        for(Integer nn:grayCode(n-1)){
            li.add(nn);
            stack.push(nn);
        }
        while(!stack.isEmpty()){
            li.add(1<<n-1+stack.pop());
        }


        return li;
    }
}

