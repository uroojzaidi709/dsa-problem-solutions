https://leetcode.com/problems/subsets/

class Solution {
  
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());

        for (int number : nums ){

            int n = outer.size();

            for ( int i = 0; i < n; i++){

                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(number);
                outer.add(internal);
            }
        }
        return outer;
    }   
}
