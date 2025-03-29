class RandomizedSet {
    private ArrayList<Integer> arr;
    private HashMap<Integer, Integer> map;
    public RandomizedSet() {
        arr = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(arr.contains(val)) {
            return false;
        }
        else {
            arr.add(val);
            map.put(val, arr.size() - 1);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }
        else {
            int index = map.get(val);
            arr.set(index, arr.get(arr.size() - 1));
            map.put(arr.get(index), index);
            arr.remove(arr.size() - 1);
            map.remove(val);
            return true;
        }
    }
    
    public int getRandom() {
        Random ran = new Random();
        return arr.get(ran.nextInt(arr.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */