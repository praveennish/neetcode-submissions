class Element{
    int num;
    int freq;

    public Element(int num, int freq){
        this.num = num;
        this.freq = freq;
    }

    public int getNum(){return this.num;}
    public int getFreq(){return this.freq;}
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num,0) + 1);
        }

        List<int[]> sortedList = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry: freqMap.entrySet()){
            sortedList.add(new int[]{entry.getValue(), entry.getKey()});
        }

        sortedList.sort((a, b) -> b[0] - a[0]);

        int[] result = new int[k];

        for(int i = 0; i < k;i++){
            result[i] = sortedList.get(i)[1];
        }
        return result;
    }
}
