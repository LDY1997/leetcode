package algorithm;

public class DivideConquer {

    private static int countInRange(int[] nums, int num, int l, int r) {
        int count = 0;
        for (int i = l; i <= r; i++) {
            if (nums[i] == num){
                count ++;
            }
        }
        return count;
    }

        public static int majorityElement(int[] nums,int l,int r) {
        if (l == r){
            return nums[l];
        }
        int mid = l + (r-l)/2;
        int left = majorityElement(nums,l,mid);
        int right = majorityElement(nums,mid+1,r);

        if (left == right){
            return nums[left];
        }
        int leftCount = countInRange(nums,left,l,r);
        int rightCount = countInRange(nums,right,l,r);

        return leftCount > rightCount ? left : right;
    }

    public int majorityElement(int[] nums) {
        return majorityElement(nums,0,nums.length);
    }

    public int maxSubArray(int[] nums) {
        int maxValue = nums[0];
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp += nums[i];
            maxValue = Math.max(maxValue,tmp);
            if (tmp < 0){
                tmp = 0;
            }
        }
        return maxValue;
    }

}
