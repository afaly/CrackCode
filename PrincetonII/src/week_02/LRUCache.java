package week_02;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class LinkedNode<T> {
        LinkedNode<T> nxt, pre;
        Integer key;
        T val;

        public LinkedNode(Integer key, T data) {
            this.key = key;
            this.val = data;
            this.nxt = null;
            this.pre = null;
        }

        public LinkedNode(Integer key, T data, LinkedNode<T> pre,
                LinkedNode<T> nxt) {
            this.key = key;
            this.nxt = nxt;
            this.pre = pre;
            this.val = data;
        }

        public void setVal(T data) {
            this.val = data;
        }
    }

    private Map<Integer, LinkedNode<Integer>> cache;
    private final int capacity;
    private int size;
    private LinkedNode<Integer> head, tail;

    public LRUCache(int capacity) {
        this.cache = new HashMap<Integer, LinkedNode<Integer>>();
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            LinkedNode<Integer> node = cache.get(key);
            remove(node);
            setHead(node);
            return node.val;
        } else return -1;
    }

    private void remove(LinkedNode<Integer> n) {
        if (n.pre != null) n.pre.nxt = n.nxt;
        else head = n.nxt;
        if (n.nxt != null) n.nxt.pre = n.pre;
        else tail = n.pre;
        n.pre = null;
        n.nxt = null;
    }

    private void setHead(LinkedNode<Integer> n) {
        n.nxt = head;
        n.pre = null;
        if (head != null) head.pre = n;
        head = n;
        if (tail == null) tail = head;
    }

    public void set(int key, int value) {
        if (!cache.containsKey(key)) {
            if (size == capacity) {
                cache.remove(tail.key);
                remove(tail);
                size--;
            }
            LinkedNode<Integer> node = new LinkedNode<Integer>(key, value);
            cache.put(key, node);
            setHead(node);
            size++;
        } else {
            LinkedNode<Integer> temp = cache.get(key);
            temp.setVal(value);
            remove(temp);
            setHead(temp);
        }
    }

}