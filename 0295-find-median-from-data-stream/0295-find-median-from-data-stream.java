class MedianFinder {
    List<Integer> list;
    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        list.add(num);
    }
    
    public double findMedian() {
        int n = list.size();
        Collections.sort(list);
        if(list.size() % 2 != 0) {
            return list.get((n-1)/2);
        }
        else {
            return (double)(list.get((n - 1) / 2) + list.get((n + 1) / 2)) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */