/*Created by ${USER} on ${DATE}.
 *���⣺�����ظ����ֵ� �Ӽ������⡣
 *ע�⣺
 *˼·��ÿ����һ�εݹ鷽���Ͱ����ڵ���ʱ�б�ӽ�ȥ���ӿռ��Ͽ�ʼ��
 *      �����ظ����⣬��start�����ƣ������ǰ������i�ǵ�һ�α�����ô�����ظ���
 *      122 �����ɵ��ڶ���2ʱ��startҲ�ǵ�ǰ����λ�ã������ظ�������12 ʱ ���2�����startλ�õ�2û���⣬����ǵڶ���2
 *      ��ʱ������λ���Ѿ�����start�� comtinue
 *
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */

//��һ��
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list =new ArrayList<List<Integer>>();
        if(nums.length==0) return list;
        Arrays.sort(nums);
        backtrack(list,new ArrayList<>(),nums,0);
        return list;
    }
    public List<Integer> backtrack(List<List<Integer>> list,List<Integer> listtem,int [] nums,int start){
        list.add(new ArrayList<>(listtem));
        for(int i=start;i<nums.length;i++){
            if(i>start&&nums[i-1]==nums[i]) continue;
            listtem.add(nums[i]);
            backtrack(list,listtem,nums,i+1);
            listtem.remove(listtem.size()-1);
        }
        return listtem;
    }
}

public (List<List>> resutl , List<> ,int start, int nums, )

list.add

for(int i=start;i<nums.length;i++){
        if(i> start num[i-1]==num[i])
        li.add(addnum[i])
        backa(i=+1,)
        list.remo*(size-1)
        }