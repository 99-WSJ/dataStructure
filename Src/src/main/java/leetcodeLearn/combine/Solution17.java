package leetcodeLearn.combine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 阿叙
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母
 */
public class Solution17 {
    //设置全局列表存储最后的结果
    List<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return list;
        }
        String[] s = {"", "", "abc","def", "ghi", "jkl","mno","pqrs","tuv","wxyz"};
        // 迭代处理
        backTracing(digits,s,0);
        return list;

    }
    StringBuilder temp = new StringBuilder();

    private void backTracing(String digits, String[] s, int startIndex) {
        if(temp.length() == digits.length()){
            list.add(temp.toString());
        }
        String str = s[digits.charAt(startIndex) - '0'];
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            backTracing(digits,s,startIndex+1);
            temp.deleteCharAt(temp.length() - 1);

        }
    }

}
