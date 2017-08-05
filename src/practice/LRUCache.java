package practice;

import java.util.HashMap;

/**
 * Created by lpeiz on 2017/4/8.
 */
class Node{
    int key;
    int value;
    Node pre;
    Node next;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
public class LRUCache {
    int capacity;
    Node head = null;//声明头结点和尾节点
    Node end = null;
    HashMap<Integer,Node> map = new HashMap<Integer, Node>(); //声明查找用的hashmap
    public LRUCache(int capacity){
        this.capacity = capacity;//构造方法生成 LRU 指定参数 capacity
    }
//获取一个缓存数据之后，应该把这个数据在当前位置中移除，并重新添加到头的位置，这些都是在返回数据之前完成的
   public int get(int key){
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
        return -1;
    }
//移除元素分为，N的前边和N的后边都要看是怎么样的情况
    public void remove(Node node){
        if(node.pre!=null){
            node.pre.next = node.next;
        }else{
            head = node.next;
        }

        if(node.next!=null){
            node.next.pre=node.pre;
        }else {
            end = node.pre;
        }
    }
    public void setHead(Node node){
        node.next = head;//head原位置应该是指向第一个元素，现在把这个位置给n.next
        node.pre = null;
        if(head !=null)
            head.pre = node;
        head = node;
        if(end == null)
            end = head;
    }
    //设置看原位置是否有元素，如果有的话就替换，这证明使用过了，然后将其替换为头结点的元素，若果是一个新的节点就要判断它的大小是否符合规范

    public void set(int key, int value){
        if(map.containsKey(key)){
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        }else{
            Node created = new Node(key,value);
            if(map.size()>=capacity){
                map.remove(end.key);
                remove(end);
                setHead(created);
            }else{
                setHead(created);
            }
            map.put(key,created);
        }
    }
}
