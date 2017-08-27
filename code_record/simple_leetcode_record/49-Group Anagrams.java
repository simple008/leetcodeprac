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
//�ڶ��� �����ķ��� �ǳ����ķ���

    public static List<List<String>> groupAnagrams(String[] strs) {
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};//���10609��z

        List<List<String>> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (String s : strs) {
            int key = 1;
            for (char c : s.toCharArray()) {
                key *= prime[c - 'a'];
            }
            List<String> t;
            if (map.containsKey(key)) {
                t = res.get(map.get(key));
            } else {
                t = new ArrayList<>();
                res.add(t);
                map.put(key, res.size() - 1);
            }
            t.add(s);
        }
        return res;
    }