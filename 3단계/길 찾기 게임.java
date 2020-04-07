import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[][] solution(int[][] nodeinfo) {
        int length = nodeinfo.length;
        int[][] answer = new int[2][length];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0; i<length; i++) {
            map.put(nodeinfo[i][0], i+1);
        }
        
        Arrays.sort(nodeinfo, new Comparator<int[]>() {
           @Override
            public int compare(int[] p1, int[] p2) {
                if(p1[1] == p2[1]) {
                    return p1[0] - p2[0];
                }
                return p2[1] - p1[1];
            }
        });
        
        Tree tree = new Tree();
        tree.setRoot(nodeinfo[0][0]);
        
        for(int i=1; i<length; i++) {
            tree.addNode(nodeinfo[i][0]);
        }
        
        List<Integer> preorderList = new ArrayList<Integer>();
        List<Integer> postorderList = new ArrayList<Integer>();
        
        preorder(tree.root, preorderList);
        postorder(tree.root, postorderList);
        
        for(int i=0; i<length; i++) {
            answer[0][i] = map.get(preorderList.get(i));
            answer[1][i] = map.get(postorderList.get(i));
        }
        
        
        
        
        return answer;
    }
    
    public void postorder(Node node, List<Integer> list) {
        if(node == null) {
            return;
        }
        
        postorder(node.leftChild, list);
        postorder(node.rightChild, list);
        list.add(node.x);
    }
    
    
    public void preorder(Node node, List<Integer> list) {
        if(node == null) {
            return;
        }
        
        list.add(node.x);
        preorder(node.leftChild, list);
        preorder(node.rightChild, list);
    } 
}

class Tree {
    Node root;
    
    public void setRoot(int x) {
        this.root = new Node(x);
    }
    
    public void addNode(int x) {
        Node temp = root;
        while(true) {
            
            if(temp.x > x) {
                if(temp.leftChild != null) {
                    temp = temp.leftChild;
                }
                else {
                    temp.leftChild = new Node(x);
                    break;
                }
            }
            else {
                if(temp.rightChild != null) {
                    temp = temp.rightChild;
                }
                else {
                    temp.rightChild = new Node(x);
                    break;
                }
            }
        }
    }
}

class Node {
    int x;
    Node leftChild;
    Node rightChild;
    
    public Node(int x) {
        this.x =x;
    }
}