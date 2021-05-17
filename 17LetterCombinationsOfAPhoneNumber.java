/**
 * 17. Letter Combinations of a Phone Number
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */

class Solution {

    /**
     * Approach 1. Backtracking
     * Time: O(4^N * N), Space: O(N)
     *
     * StringBuilder costs O(N)
     */
    private Map<Character, String> digitToLetterMap = Map.of(
            '2', "abc", '3', "def",
            '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs",
            '8', "tuv", '9', "wxyz");

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }

        // initiate backtracking with an empty path and starting index of 0
        backtrack(digits, 0, new StringBuilder(), combinations);
        return combinations;
    }

    private void backtrack(String digits, int index, StringBuilder path, List<String> allCombinations) {
        if (digits.length() == index) {
            allCombinations.add(path.toString());
            return; // backtrack
        }

        String possibleLetters = digitToLetterMap.get(digits.charAt(index));
        for (char l : possibleLetters.toCharArray()) {
            // add the letter to our current path
            path.append(l);
            // move on to the next index
            backtrack(digits, index + 1, path, allCombinations);
            // backtrack by removing the letter before moving onto the next
            path.deleteCharAt(index);
        }
    }
}