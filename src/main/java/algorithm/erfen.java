package algorithm;

public class erfen {
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j){
            int mid = (i + j) / 2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                i = mid + 1;
            }else if (nums[mid] > target){
                j = mid - 1;
            }
        }
        return -1;
    }

    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int mid = 0;
        while (i <= j){
            mid = (i + j) / 2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                i = mid + 1;
            }else if (nums[mid] > target){
                j = mid - 1;
            }
        }
        if (target>nums[i]){
            return mid+1;
        }else {
            return mid;
        }
    }

}
