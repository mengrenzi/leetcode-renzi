class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
    boolean[] isMatch = new boolean[s.length() + 1];
    isMatch[0] = true;
    for (int i = 0; i < s.length(); i++) {
      if (!isMatch[i]) {
        continue;
      }

      for (int j = i + 1; j <= s.length(); j++) {
        String tmp = s.substring(i, j);
        if (wordDict.contains(tmp)) {
          isMatch[j] = true;
        }
      }
    }
    return isMatch[s.length()];
  }
}