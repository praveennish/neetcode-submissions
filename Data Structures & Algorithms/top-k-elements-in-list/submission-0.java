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
            freqMap.put(num, freqMap.getOrDefault(num,1) + 1);
        }

        Queue<Element> minHeap = new PriorityQueue<> ((a,b) -> Integer.compare(a.getFreq(), b.getFreq()));

        for (Map.Entry<Integer, Integer> entry: freqMap.entrySet()){
            minHeap.offer(new Element(entry.getKey(), entry.getValue()));

            if(minHeap.size() > k)
                minHeap.poll();
        }

        int[] result = new int[minHeap.size()];
        int i = 0;
        while(!minHeap.isEmpty()){
            result[i++] = minHeap.poll().getNum();
        }

        return result;
    }
}
