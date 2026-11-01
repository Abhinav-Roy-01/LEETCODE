class Solution {
public:
    int removeDuplicates(vector<int>& nums) {

        if(nums.size() <= 2)
            return nums.size();


        int slow = 1;

        for (int fast = slow + 1; fast < nums.size(); fast++) {
            if (nums[fast] != nums[slow - 1] || nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }

        return slow + 1;
    }
};