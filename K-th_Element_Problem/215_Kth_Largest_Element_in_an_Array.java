class Solution1 {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length==1) return nums[0];
        quicksort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
        return nums[nums.length-k];
    }    
    private void quicksort(int[] nums, int low, int high){
        if (low<high){
            int pi = partition(nums, low, high);
            quicksort(nums, low, pi-1);
            quicksort(nums, pi+1, high);
        }
    }
    
    private int partition(int[] nums, int lo, int hi){
        int i = lo-1; // i is the largest index of num<=pivot
        int pivot = nums[hi];
        for (int j=lo; j<hi; j++){
            // if num<=pivot, put it into the (i+1)th position, and increment i
            if (nums[j]<=pivot){
                i++;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
            // if num>pivot, no change
        }
        nums[hi] = nums[i+1];
        nums[i+1] = pivot;
        return i+1;
    }
}

//quickselect don't have to sort the whole array, but stop sorting if the pivot found is the kth largest number
class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length==1) return nums[0];
        quickselect(nums, 0, nums.length-1, nums.length-k);
        return nums[nums.length-k];
    }    
    private void quickselect(int[] nums, int low, int high, int k){
        if (low<high){
            int pi = partition(nums, low, high);
            // reduce sorting
            if (pi==k) return;
            else if (pi>k) quickselect(nums, low, pi-1, k);
            else if (pi<k) quickselect(nums, pi+1, high, k);
        }
    }
    
    private int partition(int[] nums, int lo, int hi){
        int i = lo-1; // i is the largest index of num<=pivot
        int pivot = nums[hi];
        for (int j=lo; j<hi; j++){
            // if num<=pivot, put it into the (i+1)th position, and increment i
            if (nums[j]<=pivot){
                i++;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
            // if num>pivot, no change
        }
        nums[hi] = nums[i+1];
        nums[i+1] = pivot;
        return i+1;
    }
}

class Solution3 {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length==1) return nums[0];
        Arrays.sort(nums);
        return nums[nums.length-k];
    }    
}
