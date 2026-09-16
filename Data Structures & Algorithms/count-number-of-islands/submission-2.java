class Solution {
    private final int[] X = new int[]{-1, 0, 1, 0};
    private final int[] Y = new int[]{0, 1, 0, -1};
    public int numIslands(char[][] grid) {
        int noOfIslands = 0;
    
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    processConnectedIslands(grid, i, j);
                    noOfIslands++;
                }
            }
        }

        return noOfIslands;
    }

    private void processConnectedIslands(char[][] grid, int x, int y){
        Queue<Integer> queue = new LinkedList<>();
        int cols = grid[0].length;

        queue.offer(x * cols + y);
        grid[x][y] = '2';

       

        while(!queue.isEmpty()){
         int polled = queue.poll();
         
       
         for(int k = 0; k < 4; k++){
            int newX = polled / cols + X[k];
            int newY = polled % cols + Y[k];

            if (newX < grid.length && newY < grid[0].length && newX >= 0 && newY >= 0 && grid[newX][newY] == '1'){
                grid[newX][newY] = '2';
                queue.offer(newX * cols + newY);
            }
         }
        }
    }
}
