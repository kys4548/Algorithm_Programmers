import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        Map<Long, Node> map = new HashMap<Long, Node>();
        List<Node> list = new ArrayList<Node>();
        
        for(int i=0; i<room_number.length; i++) {
            long num = room_number[i];
            Node node = null;
            Node parent = null;
            
            if(map.containsKey(num)) {
                node = map.get(num);
                parent = node;
                
                while(parent.parent != null) {
                    list.add(parent);
                    parent = parent.parent;
                }
                
                while(parent.parent == null && map.containsKey(parent.n+1)) {
                    list.add(parent);
                    parent = map.get(parent.n+1);
                    while(parent.parent != null) {
                        list.add(parent);
                        parent = parent.parent;
                    }
                }
                list.add(parent);
            }
            
            
            if(node == null) {
                node = new Node(num);
                parent = node;
            }
            else {
                parent.parent = new Node(parent.n+1);
                parent = parent.parent;
            }
            
            int length = list.size();
            Node temp = null;
            for(int j=0; j<length; j++) {
                temp = list.get(j);
                temp.parent = parent;
            }

            list.clear();
            map.put(parent.n, parent);
            
            if(node.parent == null) {
                answer[i] = node.n;
            } else {
                answer[i] = map.get(num).parent.n;
            }
            
            // for(long n : map.keySet()) {
            //     Node t = map.get(n);
            //     System.out.print(n+" " );
            //     if(t.parent != null) {
            //         System.out.print(t.parent.n+" ,|");
            //     }
            //     System.out.println();
            // }
            // System.out.println();
        }
        
        return answer;
    }
}


class Node {
    long n;
    Node parent;
    
    public Node(long n) {
        this.n = n;
    }
    
}