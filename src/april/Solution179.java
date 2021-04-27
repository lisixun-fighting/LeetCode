package april;

import java.util.*;

public class Solution179 {
    public String largestNumber(int[] nums) {
        int index = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if(large(nums[j], nums[index])) {
                    index = j;
                }
            }
            nums[i] = nums[i] ^ nums[index];
            nums[index] = nums[i] ^ nums[index];
            nums[i] = nums[i] ^ nums[index];
            sb.append(nums[i]);
        }
        if(nums[0] == 0) return "0";
        return sb.toString();
    }

    private boolean large(int n1, int n2) {
        char[] chars1 = (n1 + "" + n2).toCharArray();
        char[] chars2 = (n2 + "" + n1).toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            if(chars1[i] > chars2[i]) return true;
        }
        return false;
    }
}
