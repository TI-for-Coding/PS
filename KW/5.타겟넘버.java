class Solution {
    public int solution(int[] numbers, int target) {
        return makeExpression(0, numbers, 0, target);
    }

    public int makeExpression(int idx, int[] nums, int curr, int target){

        if(idx == nums.length){
            return curr == target ? 1 : 0;
        }

        return makeExpression(idx+1, nums, curr+nums[idx], target)
                +
                makeExpression(idx+1, nums, curr-nums[idx], target);
    }
}