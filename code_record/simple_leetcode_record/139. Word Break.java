/*Created by ${USER} on ${DATE}.
 *���⣺����һ���ַ�����һ���ַ����ֵ䣬�ж��ַ����Ƿ����ַ����ֵ��е��ַ������
 *ע�⣺
 *˼·��
 *һˢ��dp
 *��ˢ��dfs  dfsҪע���֦�������ڰ���ʱҪ��ǰ��һ����ȥ��
 * ע��dfs �ĺ��� �жϣ�i,j�� �Ƿ��ܹ���dict�е��ַ�����ɣ�ÿһ��dfs��Ҫ��ǰ�벿�ֺͺ�벿��
 *���Ӷȷ�����
 *��˼��
 */
//��һ��  dp
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean []flag=new boolean[s.length()+1];
        flag[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(flag[j]&&wordDict.contains(s.substring(j,i))){
                    flag[i]=true;
                    break;
                }
            }
        }
        return flag[s.length()];
    }
}
//�ڶ���

    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || wordDict == null)
            return false;
        if(s.length() == 0)
            return true;
        int len = s.length();

        for(int i = 1; i <= len; i++) {
            String frontPart = s.substring(0, i);
            String backPart = s.substring(i, len);
            if(wordDict.contains(frontPart)) {
                if(wordBreak(backPart, wordDict))
                    return true;
                wordDict.remove(frontPart);  //��֦�����������ٴ��ظ�����
            }
        }

        return false;
    }
