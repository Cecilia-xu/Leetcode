// Time: O(1)
// Space: O(1)
class Solution {
  public boolean isAnagram(String s, String t) {
         char[] charFreq = new char[256];

          for (char c1 : s.toCharArray()) {
              charFreq[c1]++;
          }

          for (char c2 : t.toCharArray()) {
              charFreq[c2]--;
          }

          for (int i = 0; i < charFreq.length; i++) {
              if (charFreq[i] != 0) {
                  return false;
              }
          }

          return true;
  }
}
