https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

class Solution {

    public static final String[] KEYPAD = {

        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz",
    };
     
    public List<String> letterCombinations(String digits) {
         if(digits.isEmpty()){
            return new ArrayList<>();
         }
         return helper("",digits);
    }

    private List<String> helper(String processed, String unprocessed){

        if(unprocessed.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        int digit = unprocessed.charAt(0) - '0';
        String letters = KEYPAD[digit];
          
        
        List<String> ans = new ArrayList<>();
        for(char ch : letters.toCharArray()){
            
            ans.addAll(helper(processed + ch, unprocessed.substring(1)));
        }
        return ans;
    }
    }

    
