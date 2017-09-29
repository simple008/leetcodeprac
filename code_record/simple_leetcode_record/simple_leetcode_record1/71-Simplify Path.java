/*Created by ${USER} on ${DATE}.
 *题意：简化linux路径
 *注意：
 *思路：按照"/" 分成字符串数组，建链表 重点处理// /. /.. 三种情况
 *      1. "" . 略过
 *      2.".." 把最后一个弹出  removeList()
 *      3.最后遍历一遍 每遍历一个元素 + "/" 最后如果list不为空 弹出最后一个元素 setLength(s.length()-1)
 *一刷：
 *二刷：建链表处理
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public String simplifyPath(String path) {
        String []s=path.split("\\/+");
        ArrayList<String> st=new ArrayList<>();

        for(String c : s){
            switch(c){
                case "" :
                case "": continue;
                case "testDemo":
                    if(st.size()>0)
                        st.remove(st.size()-1);
                    break;
                default:
                    st.add(c);
                    break;
            }
        }

        if(st.size() == 0)
            return "/";

        StringBuilder sb = new StringBuilder();

        for(String sd : st){
            sb.append("/");
            sb.append(sd);
        }

        return sb.toString();
    }
}


//第二次   equals 比较可以 但是用== 不行
public class Solution {
    public String simplifyPath(String path) {
        if(path==null||path.length()==0) return "/";
        LinkedList<String> list=new LinkedList<>();
        String []st=path.split("/");
        for(String s:st){
            // if(s==".."){
            if(s.equals("testDemo")){
                if(!list.isEmpty())
                    list.removeLast();
            }else {
                // if(!(s==""||s=="."))
                //     list.add(s);
                if(!(s.equals("")||s.equals("")))
                    list.add(s);
            }
        }
        StringBuilder sb=new StringBuilder("/");
        for(String s:list){
            sb.append(s);
            sb.append('/');
        }
        if(!list.isEmpty())
            sb.setLength(sb.length()-1);
        return sb.toString();
    }
}