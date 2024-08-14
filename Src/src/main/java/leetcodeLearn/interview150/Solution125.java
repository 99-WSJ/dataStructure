package leetcodeLearn.interview150;

/**
 * @author wsj
 * @description: 验证回文串
 * @date 2024年08月14日 22:58
 */
public class Solution125 {
    public static void main(String[] args) {
        // String s = "A man, a plan, a canal: Panama";
        String s = "0P";
        System.out.println(isPalindrome(s));
    }

    private static boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        String s1 = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if(s1.charAt(i) >= 'a' && s1.charAt(i) <= 'z' ||
                    (s1.charAt(i) >= '0' && s1.charAt(i) <= '9')){
                str.append(s1.charAt(i));
            }
        }
        int right = str.length() - 1;
        int left = 0;
        while(left < right) {
            if(str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
