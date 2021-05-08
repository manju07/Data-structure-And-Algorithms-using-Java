package problemsolving;

import java.util.HashMap;
import java.util.Map;

/**
 * Doubly LinkedList
 */
class DLL {
    int key, data;
    DLL previous, next;

    DLL(int key, int data) {
        this.key = key;
        this.data = data;
        this.previous = this.next = null;
    }

    DLL() {

    }

}

/**
 * LRU Implementation using HashMap and Doubly LinkedList
 * 
 * @author Manjunath Asundi
 */
public class LRU {

    private Map<Integer, DLL> map = new HashMap<>();
    private DLL dll = null;
    private int LRU_SIZE = 10;

    public void putData(int key, int data) {
        if (LRU_SIZE == 0) {
            System.out.println("Cache is full");
            return;
        }
        if (dll == null) {
            dll = new DLL(key, data);
            map.put(key, dll);
        } else {
            DLL temp = new DLL(key, data);
            temp.next = dll;
            dll.previous = temp;
            dll = temp;
            map.put(key, temp);
        }
        LRU_SIZE--;
    }

    public int getData(int key) {
        if (!map.containsKey(key)) {
            System.out.println("Key does not exist");
            return -1;
        }
        DLL temp = map.get(key);
        DLL previousNode = temp.previous;
        DLL nextNode = temp.next;
        if (previousNode != null)
            previousNode.next = nextNode;
        else
            return temp.data;
        if (nextNode != null)
            nextNode.previous = previousNode;
        DLL temp1 = new DLL(temp.key, temp.data);
        dll.previous = temp1;
        temp1.next = dll;
        map.put(key, temp1);
        dll = temp1;
        return dll.data;
    }

    public void printCache() {
        DLL temp = dll;
        while (temp != null) {
            System.out.println(temp.key + " " + temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LRU lru = new LRU();
        lru.putData(1, 10);
        lru.putData(2, 20);
        lru.putData(3, 30);
        lru.putData(4, 40);
        lru.putData(5, 50);
        lru.putData(6, 60);
        lru.putData(7, 60);
        lru.putData(8, 80);
        lru.putData(9, 90);
        lru.putData(10, 100);
        System.out.println(lru.getData(10));
        System.out.println(lru.getData(2));
        System.out.println(lru.getData(5));
        System.out.println(lru.getData(1));
        lru.putData(11, 110);
        lru.printCache();
    }
}