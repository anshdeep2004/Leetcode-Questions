class StockSpanner {
    Stack<Integer> st;
    HashMap<Integer, Integer> hm;
    public StockSpanner() {
        st = new Stack<>();
        hm = new HashMap<>();
    }
    
    public int next(int price) {
        int span = 1;
        while(!hm.isEmpty() && !st.isEmpty() && price >= st.peek()) {
            span += hm.get(st.peek());
            st.pop();
        }
        st.push(price);
        hm.put(price, span);
        return span;
    }
}

/*
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */