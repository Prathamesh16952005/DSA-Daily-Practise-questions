class Solution {
    public boolean checkValidString(String s) {

        int low = 0;
        int high = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                low++;
                high++;
            } 
            else if (ch == ')') {
                low--;
                high--;
            } 
            else { // '*'
                low--;   // '*' acts as ')'
                high++;  // '*' acts as '('
            }

            // Too many ')' in every possible case
            if (high < 0) {
                return false;
            }

            // low cannot be negative
            if (low < 0) {
                low = 0;
            }
        }

        return low == 0;
    }
}