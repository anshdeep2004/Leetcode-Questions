class Node {
    int key;
    int val;
    int count;
    Node prev;
    Node next;

    Node(int k, int v, int f) {
        key = k;
        val = v;
        count = f;
    }
}

class LFUCache {
    int capacity;
    int count;
    HashMap<Integer, Node> mp;
    HashMap<Integer, Node[]> freq;
    int leastFrequent = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        count = 0;
        mp = new HashMap<>();
        freq = new HashMap<>();
    }

    public int get(int key) {
        if (!mp.containsKey(key)) return -1;
        Node n = mp.get(key);
        int f = n.count;
        Node[] edges = freq.get(f);

        if (n == edges[0]) edges[0] = n.next;
        if (n == edges[1]) edges[1] = n.prev;
        if (n.prev != null) n.prev.next = n.next;
        if (n.next != null) n.next.prev = n.prev;
        n.prev = n.next = null;

        if (edges[0] == null && edges[1] == null) {
            freq.remove(f);
            if (leastFrequent == f) leastFrequent++;
        }

        n.count = ++f;
        if (freq.containsKey(f)) {
            edges = freq.get(f);
            n.next = edges[0];
            if (edges[0] != null) edges[0].prev = n;
            edges[0] = n;
        } else {
            edges = new Node[]{n, n};
            freq.put(f, edges);
        }

        return n.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (mp.containsKey(key)) {
            Node n = mp.get(key);
            get(key); 
            n.val = value;
            return;
        }

        if (count == capacity) {
            Node[] edges = freq.get(leastFrequent);
            if (edges[0] == edges[1]) {
                mp.remove(edges[0].key);
                freq.remove(leastFrequent);
            } else {
                Node toRemove = edges[1];
                mp.remove(toRemove.key);
                if (toRemove.prev != null) toRemove.prev.next = null;
                edges[1] = toRemove.prev;
            }
            count--;
        }

        Node n = new Node(key, value, 1);
        mp.put(key, n);
        leastFrequent = 1;

        if (freq.containsKey(1)) {
            Node[] edges = freq.get(1);
            n.next = edges[0];
            if (edges[0] != null) edges[0].prev = n;
            edges[0] = n;
        } else {
            freq.put(1, new Node[]{n, n});
        }

        count++;
    }
}