/*Created by ${USER} on ${DATE}.
 *���⣺
 *˼·�� ���ַ���תΪ�ַ��������������Ͱ�������ַ������������ģ��ٰ����������תΪ�ַ��������Դ�Ϊ���浽hash�н��бȽϲ�����
 *map�ı�����ʽ
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 * ���жϲ�����һ�µĴ���һֱ������ʾno suitable constructor found for ArrayList(String)
 *
 * if(map.containsKey(sp)){
       map.get(sp).add(s);
       }
   List<String> li=new ArrayList<String>(s); //map.put(sp,new ArrayList<String>(s));
   map.put(sp,li);

 */

//��һ��
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0||strs==null) return new ArrayList<List<String>>();
        HashMap<String,List<String>> map=new HashMap<>();
        // List<List<String>> list=new ArrayList<List<Integer>>();
        for(String s:strs){
            char [] a=s.toCharArray();
            Arrays.sort(a);
            String str=String.valueOf(a);
            // List<String> ll=new ArrayList<String>();
            if(!map.containsKey(str)){
                map.put(str,new ArrayList<>());
            }
            map.get(str).add(s);

        }
        return new ArrayList<List<String>>(map.values());
    }
}
//�ڶ���

