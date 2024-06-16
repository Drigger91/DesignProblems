package LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Lru cache.
 */
class LRUCache {
    private final Map<Integer, DoublyLinkedListNode> map;
    private final DoublyLinkedListNode head;
    private final DoublyLinkedListNode tail;
    private final int capacity;

    /**
     * Instantiates a new Lru cache.
     *
     * @param capacity the capacity
     */
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.head = new DoublyLinkedListNode(0, 0);
        this.tail = new DoublyLinkedListNode(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    /**
     * Get value from cache.
     *
     * @param key the key
     * @return the int
     */
    public int get(int key) {
        if (map.containsKey(key)) {
            return updateLru(key);
        }
        return -1;
    }
    /**
     * @param key
     * takes the integer key, and update it's position in LRU
     */
    private int updateLru(int key) {
        DoublyLinkedListNode node = map.get(key);
        DoublyLinkedListNode previous = node.prev;
        DoublyLinkedListNode next = node.next;
        previous.next = next;
        next.prev = previous;
        insertNodeInLRU(node);
        return node.val;
    }

    /**
     * Put the key inside map & LRU cache
     * @param key   the key
     * @param value the value
     */
    public void put(int key, int value) {
        if (map.size() == capacity && !map.containsKey(key)) {
            deleteLRUNode();
        }
        DoublyLinkedListNode node;
        if (map.containsKey(key)) {
            DoublyLinkedListNode currentNode = map.get(key);
            currentNode.val = value;
            node = currentNode;
            deleteNode(key);
        } else {
            node = new DoublyLinkedListNode(key, value);
        }
        map.put(key, node);
        insertNodeInLRU(node);
    }
    /**
    * Delete specific node from list
    */
    private void deleteNode(int key) {
        DoublyLinkedListNode nodeToDelete = map.get(key);
        DoublyLinkedListNode next = nodeToDelete.next;
        DoublyLinkedListNode prev = nodeToDelete.prev;
        prev.next = next;
        next.prev = prev;
    }
    /**
     * Put.
     * delete the LRU node and make head point to nextLru, tail can also be nextLRU;
     */
    private void deleteLRUNode() {
        DoublyLinkedListNode lruNode = head.next;
        DoublyLinkedListNode nextLruNode = lruNode.next;
        head.next = nextLruNode;
        nextLruNode.prev = head;
        map.remove(lruNode.key);
    }
    /**
     * insert node prev to tail.
    */
    private void insertNodeInLRU(DoublyLinkedListNode node) {
        DoublyLinkedListNode previousNode = this.tail.prev;
        previousNode.next = node;
        node.prev = previousNode;
        node.next = this.tail;
        this.tail.prev = node;
        print();
    }
    public void print() {
        DoublyLinkedListNode node = head;
        while (node != null) {
            System.out.print("[ " + node.key + "," + node.val + "] " + "->");
            node = node.next;
        }
        System.out.println();
    }
}
