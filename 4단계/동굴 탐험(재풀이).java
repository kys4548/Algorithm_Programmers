import java.util.*;

class Solution {
    public boolean solution(int n, int[][] path, int[][] order) {
        boolean answer = true;
        Node[] nodes = new Node[n];
        for(int i=0; i<n; i++) {
            nodes[i] = new Node();
        }

        for(int i=0; i<path.length; i++) {
            nodes[path[i][0]].child.add(path[i][1]);
            nodes[path[i][1]].child.add(path[i][0]);
        }

        List<Integer> list = new LinkedList<>();
        list.add(0);

        while(!list.isEmpty()) {
            List<Integer> nextList = new LinkedList<>();
            while (!list.isEmpty()) {
                int index = list.remove(0);
                for (Integer childIndex : nodes[index].child) {
                    nodes[childIndex].child.remove(index);
                    nodes[childIndex].parent.add(index);
                    if(nodes[childIndex].child.size() != 0) {
                        nextList.add(childIndex);
                    }
                }
            }
            list = nextList;
        }

        for(int i=0; i<order.length; i++) {
            nodes[order[i][0]].child.add(order[i][1]);
            nodes[order[i][1]].parent.add(order[i][0]);
        }

        if(!nodes[0].parent.isEmpty()) {
            return false;
        }

        list = new LinkedList<>();
        Set set = new HashSet();
        list.add(0);

        while (!list.isEmpty()) {
            int index = list.remove(0);
            set.add(index);
            for (Integer childIndex : nodes[index].child) {
                nodes[childIndex].parent.remove(index);
                if(nodes[childIndex].parent.isEmpty()) {
                    list.add(childIndex);
                }
            }
        }

        if(set.size() < n) {
            return false;
        }

        return answer;
    }
}

class Node {
    Set<Integer> child = new HashSet<>();
    Set<Integer> parent = new HashSet<>();
}