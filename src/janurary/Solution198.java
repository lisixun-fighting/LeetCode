package janurary;

public class Solution198 {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        if(len == 1) return nums[0];
        if(len == 2) return Math.max(nums[0], nums[1]);
        nums[2] += nums[0];
        for (int i = 3; i < len; i++) {
            nums[i] += Math.max(nums[i-2], nums[i-3]);
        }
        return Math.max(nums[len-1], nums[len-2]);
    }

    public int rob2(int[] nums) {
        if(nums.length == 0) return 0;
        int f = nums[0];
        if(nums.length == 1) return f;
        int l = nums[1];
        for (int i = 2; i < nums.length; i++) {
            int temp = l;
            l = Math.max(nums[i] + f, l);
            f = Math.max(f, temp);
        }
        return Math.max(f, l);
    }
}
