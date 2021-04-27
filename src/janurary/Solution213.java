package janurary;

public class Solution213 {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int left = simRob(nums, 0, nums.length-2);
        int right = simRob(nums, 1, nums.length-1);
        return Math.max(left, right);
    }

    public int simRob(int[] nums, int start, int end) {
        int former = 0;
        int latter = nums[start];
        for (int i = start+1; i <= end; i++) {
            int temp = latter;
            latter = Math.max(former+nums[i], latter);
            former = temp;
        }
        return Math.max(former, latter);
    }
}
