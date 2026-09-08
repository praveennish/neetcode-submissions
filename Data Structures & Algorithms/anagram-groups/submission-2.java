class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs){
            char[] strArr = str.toCharArray();
            
            String derivedKey = deriveKey(strArr);

            List<String> words = map.get(derivedKey);
            if(words == null)
                words = new ArrayList<String>();

            words.add(str);

            map.put(derivedKey, words);
        }

        for(List<String> words: map.values()){
            result.add(words);
        }

        return result;
    }

    private String deriveKey(char[] strArr){
        int[] count = new int[26];
        for (char ch: strArr){
            count[ch - 'a']++;
        }
        return Arrays.toString(count);
    }
}
