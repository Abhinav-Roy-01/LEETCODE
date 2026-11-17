class Solution {
    public int[] sortedSquares(int[] nums) {
       for(int i = 0; i<nums.length ; i++){
          nums[i] = nums[i]*nums[i];
       }
       int[] result = Arrays.copyOf(nums, nums.length);
       for(int i = 0; i< result.length - 1; i++){
           for(int j = 0; j<result.length -1 -i; j++){
                if(result[j]> result[j+1]){
                    int temp = result[j];
                    result[j] = result[j+1];
                    result[j+1] = temp;
                }

            }
       }
       return result; 
    }
}