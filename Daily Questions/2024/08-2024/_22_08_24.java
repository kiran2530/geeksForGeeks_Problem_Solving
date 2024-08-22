/*
 *  Q) Alien Dictionary
        Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary. Find the order of characters in the alien language.
        Note: Many orders may be possible for a particular test case, thus you may return any valid order and output will be 1 if the order of string returned by the function is correct else 0 denoting incorrect string returned.

    Examples : 1
        Input:  n = 5, k = 4, dict = {"baa","abcd","abca","cab","cad"}
        Output: 1
        Explanation: Here order of characters is 'b', 'd', 'a', 'c' Note that words are sorted and in the given language "baa" comes before "abcd", therefore 'b' is before 'a' in output.
        Similarly we can find other orders.
        
    Examples : 2
        Input: n = 3, k = 3, dict = {"caa","aaa","aab"}
        Output: 1
        Explanation: Here order of characters is 'c', 'a', 'b' Note that words are sorted and in the given language "caa" comes before "aaa", therefore 'c' is before 'a' in output.
        Similarly we can find other orders.
        
    Expected Time Complexity: O(n * |s| + k)
    Expected Auxillary Space: O(k)

    Constraints:
        1 ≤ n≤ 10^4
        1 ≤ k ≤ 26
        1 ≤ Length of words ≤ 50
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _22_08_24 {
    public static String findOrder(String[] dict, int n, int k) {
        HashMap<Character,ArrayList<Character>> map=new HashMap<>();
        for(int i=1;i<dict.length;i++){
            String str1=dict[i-1].toLowerCase();
            String str2=dict[i].toLowerCase();
            int s1=0;
            int len = Math.min(str1.length(), str2.length());
            while(s1<len  && str1.charAt(s1)==str2.charAt(s1)){
                s1++;
            }
            if(s1>=len) continue;
            map.computeIfAbsent(str1.charAt(s1),p->new ArrayList<>()).add(str2.charAt(s1));
        }
        
        int []inDegree=new int[k];
        for(char i:map.keySet()){
            for(char j:map.get(i)){
                inDegree[j-'a']++;
            }
        }
        String ans="";
        Queue<Character> q=new LinkedList<>();
        for(int i=0;i<k;i++){
            if(inDegree[i]==0){
                char ch=(char)(i+'a');
                q.add(ch);
            }
        }
        while(!q.isEmpty()){
            char ch=q.poll();
            ans+=ch;
            if(map.containsKey(ch)){
                for(char j:map.get(ch)){
                     inDegree[j-'a']--;
                     if(inDegree[j-'a']==0){
                         q.add(j);
                     }
                }
            }
        }
        
        if(ans.length()!=k){
            return "";
        }
        return ans;
    }
}