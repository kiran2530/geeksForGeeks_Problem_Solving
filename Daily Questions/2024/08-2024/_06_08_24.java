/*
 *  Validate an IP Address
        You are given a string str in the form of an IPv4 Address. Your task is to validate an IPv4 Address, if it is valid return true otherwise return false.
        IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots, e.g., 172.16.254.1
        A valid IPv4 Address is of the form x1.x2.x3.x4 where 0 <= (x1, x2, x3, x4) <= 255. Thus, we can write the generalized form of an IPv4 address as (0-255).(0-255).(0-255).(0-255)
        Note: Here we are considering numbers only from 0 to 255 and any additional leading zeroes will be considered invalid.

    Example : 1
        Input: str = 222.111.111.111
        Output: true
        Explanation: Here, the IPv4 address is as per the criteria mentioned and also all four decimal numbers lies in the mentioned range.
        
    Example : 2
        Input: str = 5555..555
        Output: false
        Explanation: 5555..555 is not a valid. IPv4 address, as the middle two portions are missing.
        
    Expected Time Complexity: O(n)
    Expected Auxiliary Space: O(1)

    Constraints:
        1<=str.length() <=15
 */
public class _06_08_24 {
    public static boolean isValid(String str) {
        String arr[] = str.split("\\.");    // use \\ because (.) is an special character in regular expression hence to escape it use double backslash(\\.)
        if(arr.length != 4) 
            return false;
        
        for(int i=0;i<arr.length;i++) {
            int l=arr[i].length();
            if(l>1 && arr[i].charAt(0)=='0')
                return false;
                
            if(arr[i].isEmpty() || arr[i].length()>3 || Integer.parseInt(arr[i])<0  || Integer.parseInt(arr[i])>255) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String ip = "255..255.255";
        System.out.println(isValid(ip));
    }   
}
