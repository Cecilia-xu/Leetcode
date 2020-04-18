// Solution 1: hashset
// Two cases need to be considered before putting a number into hashmap
// (1) if the double of this number has already existed
// (2) if a number whose double is this number has already existed
class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> num = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (num.contains(arr[i] * 2)) {
                return true;
            }
            else if (arr[i] % 2 == 0 && num.contains(arr[i] / 2)) {
                return true;
            }
            num.add(arr[i]);
        }
        return false;
    }
}
