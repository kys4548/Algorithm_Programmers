import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

class Solution {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        Set<String> set = new HashSet<String>(Arrays.asList(words));
        words = new String[set.size()];
        set.toArray(words);
        TrieNode[][] trieArr = new TrieNode[10001][2];
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i=0; i<words.length; i++) {
            String str = words[i];
            int length = str.length();
            if(trieArr[length][0] == null) {
                trieArr[length][0] = new TrieNode();
                trieArr[length][1] = new TrieNode();
            }
            int[] arr = new int[length];
            for(int j=0; j<length; j++) {
                arr[j] = str.charAt(j) - 'a';
            }
            TrieNode node1 = trieArr[length][0];
            TrieNode node2 = trieArr[length][1];
            node1.childNum++;
            node2.childNum++;
            for(int j=0; j<length; j++) {
                if(node1.child[arr[j]] == null) {
                    node1.child[arr[j]] = new TrieNode();
                }
                node1 = node1.child[arr[j]];
                node1.childNum++;
                
                if(node2.child[arr[length-1-j]] == null) {
                    node2.child[arr[length-1-j]] = new TrieNode();
                }
                node2 = node2.child[arr[length-1-j]];
                node2.childNum++;
            }
        }
        
        for(int i=0; i<queries.length; i++) {
            String str = queries[i];
            if(map.containsKey(str)) {
                answer[i] = map.get(str);
                continue;
            }
            int length = str.length();
            int idx =0;
            if(trieArr[length][0] == null) {
                continue;
            }
            TrieNode node = null;
            boolean match = true;
            if(str.charAt(length-1) =='?') {
                node = trieArr[length][0];
                for(int j=0; j<length; j++) {
                    if(str.charAt(j) != '?') {
                        idx = str.charAt(j) - 'a';
                        if(node.child[idx] == null) {
                            match = false;
                            break;
                        }
                        node = node.child[idx];
                    }
                    else {
                        break;
                    }
                }
            }
            else {
                node = trieArr[length][1];
                for(int j=length-1; j>=0; j--) {
                    if(str.charAt(j) != '?') {
                        idx = str.charAt(j) - 'a';
                        if(node.child[idx] == null) {
                            match = false;
                            break;
                        }
                        node = node.child[idx];
                    }
                    else {
                        break;
                    }
                }
            }
            if(match == true) {
                answer[i] = node.childNum;
            }
            map.put(str, answer[i]);
        }
        
        return answer;
    }
    
    class TrieNode {
        TrieNode[] child;
        int childNum;
        
        public TrieNode() {
            child = new TrieNode[26];
            childNum = 0;
        }
    }
}