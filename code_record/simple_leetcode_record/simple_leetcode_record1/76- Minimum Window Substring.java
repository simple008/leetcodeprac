/*Created by ${USER} on ${DATE}.
 *题意：给定一个长字符串S 一个单字符串T 找出在S中最短的一个子串包含T的所有字符
 *注意：
 *思路：记录T、S中各个字符出现的次数，用256长度的数组记比较方便，用hashmap的话需要总判断是否空
 *      遍历短串初始化一个数组，遍历长串，可开始比较，
 *      当找到一个字符在T中出现时，比较在S中出现的次数是否已经超过T中出现的次数，
 *      如果没有超过在比较一下出现的符合要求的字符个数found与T串长度的关系，如果小于那么这个字符串可以放入窗口，
 *      found++;j++右指针移动
 *      再比较found == T.length() 如果相等 当前窗口的子串作为一个结果
 *      Smap[S.charAt(i)]--;将当前指针字符出现的次数减一，准备移动左指针，如果当前指针位置指向的字符串在当前窗口中出现的次数大于在T串中出现的次数是冗余，不care
 *      如果小于说明是有效次数，found--；  在比较的时候要注意这个字符串是否在T中出现 不出现的就不用考虑了，跟found没关系
 *
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */

class Solution {
    public String minWindow(String S, String T) {
        if(S==null||S.isEmpty()||T==null||T.isEmpty()) return "";
        int i=0, j=0;
        int[] Tmap=new int[256];
        int[] Smap=new int[256];
        for(int k=0; k< T.length(); k++){
            Tmap[T.charAt(k)]++;
        }
        int found=0;
        int length=Integer.MAX_VALUE;
        String res="";
        while(j<S.length()){
            if(found<T.length()){
                if(Tmap[S.charAt(j)]>0){
                    Smap[S.charAt(j)]++;
                    if(Smap[S.charAt(j)]<=Tmap[S.charAt(j)]){
                        found++;
                    }
                }
                j++;
            }
            while(found==T.length()){
                if(j-i<length){
                    length=j-i; res=S.substring(i,j);
                }
                if(Tmap[S.charAt(i)]>0){
                    Smap[S.charAt(i)]--;
                    if(Smap[S.charAt(i)]<Tmap[S.charAt(i)]){
                        found--;
                    }
                }
                i++;
            }
        }
        return res;
    }
}


public String minWindow(String S, String T) {
        if(S==null||S.isEmpty()||T==null||T.isEmpty()) return "";
        int i=0, j=0;
        int[] Tmap=new int[256];
        int[] Smap=new int[256];
        for(int k=0; k< T.length(); k++){
        Tmap[T.charAt(k)]++;
        }
        int found=0;
        int length=Integer.MAX_VALUE;
        String res="";
        while(j<S.length()){
        if(found<T.length()){
        if(Tmap[S.charAt(j)]>0){
        Smap[S.charAt(j)]++;
        if(Smap[S.charAt(j)]<=Tmap[S.charAt(j)]){
        found++;
        }
        }
        j++;
        }
        while(found==T.length()){
        if(j-i<length){
        length=j-i; res=S.substring(i,j);
        }
        if(Tmap[S.charAt(i)]>0){
        Smap[S.charAt(i)]--;
        if(Smap[S.charAt(i)]<Tmap[S.charAt(i)]){
        found--;
        }
        }
        i++;
        }
        }
        return res;
        }