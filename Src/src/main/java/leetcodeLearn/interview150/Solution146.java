package leetcodeLearn.interview150;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Src
 * @description: LRU 缓存
 * @author: wsj
 * @create: 2024-09-23 16:12
 **/
public class Solution146 {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        DLinkedNode() {};
        DLinkedNode(int _key, int _value) {
            this.key = _key;
            this.value = _value;
        }
    }
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public Solution146(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            // 添加到头部
            addToHead(newNode);
            size++;
            if(size > capacity) {
                // 超出容量，删除双向链表的尾节点
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            // 移动到头部
            moveToHead(node);
        }

    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void moveToHead(DLinkedNode node) {
        // 中间的节点移动到链表头部: 先断开链表再移动到头部
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}
