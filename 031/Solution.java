// Solution: simulation
// Time complexity: O(n)
// Space complexity: O(1)
// Notes: How can we find next permutation? e.g. [1,3,1,2,5,4,3,3,1]
// Step 1: Find the last index that its following sequence is decreasing after this position(the index need to be changed in 
// next permutation) e.g. find index = 3, nums[index] = 2
// Step 2: If we cannot find that index, it means that the overall array is decreasing(greatest permutation)
// -> reverse array and then get the smallest permutation for the answer
// Step 3: Find next number need to be placed in the position index. This number should be slightly larger than current 
// nums[index]. ->  traverse from the end to (index - 1) and find the first number that is larger than nums[index]
// e.g.find nums[7] = 3 
// Step 4: swap the number we find in step 1 and step 3. e.g.[1,3,1,3,5,4,3,2,1]
// Step 5: Reverse the part that is behind index. e.g. [1,3,1,3,1,2,3,4,5]

class Solution {
    public void nextPermutation(int[] nums) {
        // find the last index before a increasing sequence
        int index = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                index = i;
            }
        }
        // if the number is decreasing, reverse nums
        if (index == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        // find the next number need to be placed at index position and swap
        for (int i = nums.length - 1; i > index; i--) {
           if (nums[i] > nums[index]) {
               swap(nums, i, index);
               break;
           }
        }
        // reverse 
        reverse(nums, index + 1, nums.length - 1);
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        } 
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
