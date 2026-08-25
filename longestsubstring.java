import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Map to store the last seen index of each character
        HashMap<Character, Integer> map = new HashMap<>();
        
        int maxLength = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // If the character is already in the map and its index is within the current window
            if (map.containsKey(currentChar) && map.get(currentChar) >= left) {
                // Move the left pointer just past the previous occurrence of the character
                left = map.get(currentChar) + 1;
            }
            
            // Update the last seen position of the current character
            map.put(currentChar, right);
            
            // Calculate the maximum length found so far
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}