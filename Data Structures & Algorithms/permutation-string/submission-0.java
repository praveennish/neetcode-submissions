class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        char[] s1Arr = s1.toCharArray();
        Arrays.sort(s1Arr);
        String sortedS1 = new String(s1Arr);

        int k = s1.length();
        
        int start = 0, end = start + k - 1;
        int n = s2.length();

        while (end < n){
            String subStr = s2.substring(start, end + 1);
            char[] tmpArr = subStr.toCharArray();
            Arrays.sort(tmpArr);

            if ((new String(tmpArr)).equals(sortedS1))
                return true;
            end++;
            start++;
        }
        return false;

    }
}
