class DisjointSet {
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();
    DisjointSet(int n) {
        for(int i=0; i<n; i++) {
            parent.add(i);
            size.add(1);
        }
    }
    public int findParent(int node) {
        if(node == parent.get(node)) return node;
        int ulp = findParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    public void unionBySize(int u, int v) {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if(ulp_u == ulp_v) return ;
        else if(size.get(ulp_u) > size.get(ulp_v)) {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
        else {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DisjointSet ds = new DisjointSet(accounts.size());
        HashMap<String, Integer> mailsNumber = new HashMap<>();
        for(int i=0; i<accounts.size(); i++) {
            for(int j=1; j<accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if(!mailsNumber.containsKey(mail)) {
                    mailsNumber.put(mail, i);
                }
                else {
                    ds.unionBySize(i, mailsNumber.get(mail));
                }
            }
        }
        HashMap<Integer, ArrayList<String>> numberMail = new HashMap<>();
        for(Map.Entry<String, Integer> map : mailsNumber.entrySet()) {
            int ulp_mail = ds.findParent(map.getValue());
            numberMail.computeIfAbsent(ulp_mail, k -> new ArrayList<>()).add(map.getKey());
        }
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<Integer, ArrayList<String>> map : numberMail.entrySet()) {
            String name = accounts.get(map.getKey()).get(0);
            ArrayList<String> mails = map.getValue();
            Collections.sort(mails);
            ArrayList<String> nameAndMail = new ArrayList<>();
            nameAndMail.add(name);
            nameAndMail.addAll(mails);
            result.add(nameAndMail);
        }
        return result;
    }
}