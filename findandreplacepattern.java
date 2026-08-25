import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }
        
        return result;
    }
    
    private boolean matches(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }
        
        // Arrays to store last seen position + 1 of each character
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        
        for (int i = 0; i < word.length(); i++) {
            char wChar = word.charAt(i);
            char pChar = pattern.charAt(i);
            
            // If the last seen position of both characters don't match, pattern breaks
            if (m1[wChar] != m2[pChar]) {
                return false;
            }
            
            // Store current position (using i + 1 because default array values are 0)
            m1[wChar] = i + 1;
            m2[pChar] = i + 1;
        }
        
        return true;
    }
}