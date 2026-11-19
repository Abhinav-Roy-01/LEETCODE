class Solution {

    public int nextIndex(int[] nums, int current) {
        return ((current + nums[current]) % nums.length + nums.length) % nums.length;
    }

    public boolean circularArrayLoop(int[] nums) {

        int n = nums.length;

        for(int i = 0; i < n; i++) {

            if(nums[i] == 0)
                continue;

            int slow = i;
            int fast = i;

            boolean direction = nums[i] > 0;

            while(true) {

                int slowNext = nextIndex(nums, slow);

                if(nums[slowNext] == 0 || (nums[slowNext] > 0) != direction)
                    break;

                int fastNext = nextIndex(nums, fast);

                if(nums[fastNext] == 0 || (nums[fastNext] > 0) != direction)
                    break;

                int fastNext2 = nextIndex(nums, fastNext);

                if(nums[fastNext2] == 0 || (nums[fastNext2] > 0) != direction)
                    break;

                slow = slowNext;
                fast = fastNext2;

                if(slow == fast) {

                    if(slow != nextIndex(nums, slow))
                        return true;

                    break;
                }
            }
            int current = i;

            while(nums[current] != 0 && (nums[current] > 0) == direction) {

                int next = nextIndex(nums, current);

                nums[current] = 0;

                current = next;
            }
        }

        return false;
    }
}