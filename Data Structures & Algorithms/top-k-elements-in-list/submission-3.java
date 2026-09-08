class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer>[] freqList = new List[nums.length + 1];

        for(int i = 0; i < freqList.length; i++){
            freqList[i] = new ArrayList<>();
        } 
        
        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num,0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry: freqMap.entrySet()){
            freqList[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        int current = 0;

        for(int i = freqList.length - 1; current < k && i > 0;i--){
            for(int num: freqList[i]){
                result[current++] = num;
                if (current == k)
                    return result;
            }
        }
        return result;
    }
}
