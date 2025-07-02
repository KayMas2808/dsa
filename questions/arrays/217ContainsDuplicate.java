package questions.arrays;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for(int i: nums){
            if(seen.contains(i)) return true;
            else seen.add(i);
        }
        return false;
    }
}

//[0,4,5,0,3,6]