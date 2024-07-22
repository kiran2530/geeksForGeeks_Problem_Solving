import java.util.Arrays;

/*
 * march 8 : Check if frequencies can be equal
    Given a string s which contains only lower alphabetic characters, check if it is possible to remove at most one character from this string in such a way that frequency of each distinct character becomes same in the string. Return true if it is possible to do else return false.

    Note: The driver code print 1 if the value returned is true, otherwise 0.

    Example 1:
    Input:
    s = "xyyz"
    Output: 
    1 
    Explanation: 
    Removing one 'y' will make frequency of each character to be 1.
    
    Example 2:
    Input:
    s = "xxxxyyzz"
    Output: 
    0
    Explanation: 
    Frequency can not be made same by removing at most one character.
    
    Your Task:  
    You dont need to read input or print anything. Complete the function sameFreq() which takes a string as input parameter and returns a boolean value denoting if same frequency is possible or not.

    Expected Time Complexity: O(|s|) 
    Expected Auxiliary Space: O(1)

    Constraints:
    1 <= |s| <= 105
*/
public class march_8_check_frequencies_equal {
    public static boolean sameFreq(String s) {
        // code here
        int cnt[] = new int[26];
        for(int i = 0;i<s.length();i++){
            cnt[s.charAt(i)-'a']++;
        }
        Arrays.sort(cnt);
        int min = 0,max = cnt[25];
        for(int i = 0;i<26;i++){
            if(cnt[i]==0) continue;
            else{
                min = cnt[i];
                break;
            }
        }
        int mincnt= 0,maxcnt=0;
        
        for(int i = 0;i<26;i++){
            if(cnt[i]==0)continue;
            if(min!=cnt[i]) mincnt++;
            if(max!=cnt[i]) maxcnt++;
        }
        if(mincnt==0||maxcnt==0) return true;
        if(mincnt==1){
            if(max==min+1) return true;
        }
        if(maxcnt==1){
            if(min==1) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String s = "xyyyz";
        System.out.println(sameFreq(s));
    }
}