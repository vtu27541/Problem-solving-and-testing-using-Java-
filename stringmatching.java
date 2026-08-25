import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        int n = words.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Do not compare a word with itself
                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    // Break early so we don't add duplicates if words[i] is a substring of multiple words
                    break;
                }
            }
        }

        return result;
    }
}