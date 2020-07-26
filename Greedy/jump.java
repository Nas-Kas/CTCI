/*

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

jump game

[1,1,2,5,5,1,1,1]

- start at the beginning
- traverse through for start pointers val
- find a val in the subarray of length n that is the greatest
- choose that value and repeat until we've reached the end or length of n is is greater than or equal to length of arr

*/


class jump{
    public boolean canJump(int[] nums) {
        int start = 0;
        int end = start + nums[start];
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            System.out.println(end + ":" + nums.length);
            if(end >= nums.length - 1){
                return true;
            }
            i = getSubArrayMax(nums,start,end);
            start = i;
            end = i + nums[i];
            System.out.println(start + ":" + i + ":" + end);
            
            if(count > nums.length){
                return false;
            }
            count++;
        }
        return false;
    }
    
    public int getSubArrayMax(int [] nums, int start, int end){
        int max = Integer.MIN_VALUE;
        int maxidx = 0;
        for(int i = start + 1; i < end; i++){
            if(nums[i] > max){
                max = nums[i];
                maxidx = i;
            }
        }
        return maxidx;
    }
}