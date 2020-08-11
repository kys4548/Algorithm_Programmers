import java.util.*;

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 9;
        int[][] path = {{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
        int[][] order = {{4,1},{8,7},{6,5}};
        solution.solution(n, path, order);
    }
}

class Solution {

    static boolean isCycle = false;

    public boolean solution(int n, int[][] path, int[][] order) {
        boolean answer = true;
        Node[] arr = new Node[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Node(i);
        }

        for (int i = 0; i < path.length; i++) {
            Node node1 = arr[path[i][0]];
            Node node2 = arr[path[i][1]];

            node1.nodeList.add(node2);
            node2.nodeList.add(node1);
        }

        //자식노드에서 부모 노드를 가리키는 유향 그래프 만들기
        solve(arr[0], null);
        arr[0].nodeList.clear();


        for (int i = 0; i < order.length; i++) {
            arr[order[i][1]].nodeList.add(arr[order[i][0]]);
        }

        //날 여는데 내 자식노드가 필요한 경우를 찾는다. (사이클 존재 여부) -> 방문 불가
        //깊이 우선 탐색


        Set<Integer> set = new HashSet<>();
        List<Node> list = new ArrayList<>();

        long start = System.currentTimeMillis();

        for (int i=n-1; i>=0; i--) {
            set.add(i);
            Set<Integer> tempSet = new HashSet<>();
            tempSet.add(arr[i].number);
            list.add(arr[i]);


            while (!list.isEmpty()) {
                Node node = list.remove(list.size() - 1);
                for (Node nextNode : node.nodeList) {
                    if (nextNode == arr[i]) {
                        isCycle = true;
                        break;
                    } else if (set.contains(nextNode.number) || tempSet.contains(nextNode.number)) {
                        continue;
                    }
                    tempSet.add(nextNode.number);
                    list.add(nextNode);
                }
                if (isCycle) {
                    break;
                }
            }
            if (isCycle) {
                answer = false;
                break;
            }
            if(System.currentTimeMillis() - start > 900) {
                break;
            }
        }

        return answer;
    }


    public void solve(Node node, Node parent) {
        for(Node child : node.nodeList) {
            child.nodeList.remove(node);
            solve(child, node);
        }
        node.nodeList.clear();
        node.nodeList.add(parent);
    }
}

class Node {
    int number;
    List<Node> nodeList;

    Node(int number) {
        this.number = number;
        nodeList = new ArrayList<>();
    }
}