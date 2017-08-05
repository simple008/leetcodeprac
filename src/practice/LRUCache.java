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
    Node head = null;//����ͷ����β�ڵ�
    Node end = null;
    HashMap<Integer,Node> map = new HashMap<Integer, Node>(); //���������õ�hashmap
    public LRUCache(int capacity){
        this.capacity = capacity;//���췽������ LRU ָ������ capacity
    }
//��ȡһ����������֮��Ӧ�ð���������ڵ�ǰλ�����Ƴ�����������ӵ�ͷ��λ�ã���Щ�����ڷ�������֮ǰ��ɵ�
   public int get(int key){
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
        return -1;
    }
//�Ƴ�Ԫ�ط�Ϊ��N��ǰ�ߺ�N�ĺ�߶�Ҫ������ô�������
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
        node.next = head;//headԭλ��Ӧ����ָ���һ��Ԫ�أ����ڰ����λ�ø�n.next
        node.pre = null;
        if(head !=null)
            head.pre = node;
        head = node;
        if(end == null)
            end = head;
    }
    //���ÿ�ԭλ���Ƿ���Ԫ�أ�����еĻ����滻����֤��ʹ�ù��ˣ�Ȼ�����滻Ϊͷ����Ԫ�أ�������һ���µĽڵ��Ҫ�ж����Ĵ�С�Ƿ���Ϲ淶

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
