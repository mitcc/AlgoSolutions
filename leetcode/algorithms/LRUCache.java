/*
Design and implement a data structure for Least Recently Used (LRU) cache. It
should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists
in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present.
When the cache reached its capacity, it should invalidate the least recently
used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
 */
public class LRUCache {

    private int capacity;
    private Map<Integer, DeNode> map;
    private DeNode head;
    private DeNode tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, DeNode>(capacity);
        this.head = new DeNode(0, 0);
        this.tail = new DeNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DeNode node = map.get(key);
            deleteNode(node);
            addToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DeNode node = map.get(key);
            node.value = value;

            deleteNode(node);
            addToHead(node);
        } else {
            if (map.size() == capacity) {
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
            }
            DeNode node = new DeNode(key, value);
            addToHead(node);
            map.put(key, node);
        }
    }

    private void addToHead(DeNode node) {
        if (node == null) {
            return;
        }
        node.next = head.next;
        node.prev = head;
        node.next.prev = node;
        head.next = node;
    }

    private void deleteNode(DeNode node) {
        if (node == null) {
            return;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
    }

}

class DeNode {

    int key;
    int value;
    DeNode prev;
    DeNode next;

    public DeNode(int key, int value) {
        this.key = key;
        this.value = value;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
