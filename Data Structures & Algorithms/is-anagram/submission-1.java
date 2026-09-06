class Solution {
    public boolean isAnagram(String s, String t) {

       if (s == null || t == null || s.length() != t.length())
            return false;
        int n = s.length(); 
       int[] counts = new int[256];

       for(int i = 0; i < n; i++){
        counts[s.charAt(i)]++;
        counts[t.charAt(i)]--;
       }

       for (int count: counts){
        if (count != 0)
            return false;
       }
       return true;
    }
}
