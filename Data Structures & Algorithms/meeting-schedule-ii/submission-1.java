/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.size() < 1)
            return intervals.size();

        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals.get(0).end);
        int noOfMeetingRooms = 1;

        for (int i = 1;i < intervals.size(); i++)
        {
            if (pq.peek() > intervals.get(i).start){
                noOfMeetingRooms++;
            }
            else{
                pq.poll();
            }
            pq.add(intervals.get(i).end);
        }
        return noOfMeetingRooms;

    }
}
