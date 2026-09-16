class Solution {
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
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        grid[x][y] = '2';

        while(!queue.isEmpty()){
         int[] polled = queue.poll();
         
         int[] X = new int[]{-1, 0, 1, 0};
         int[] Y = new int[]{0, 1, 0, -1};

         for(int k = 0; k < 4; k++){
            int newX = polled[0] + X[k];
            int newY = polled[1] + Y[k];

            if (newX < grid.length && newY < grid[0].length && newX >= 0 && newY >= 0 && grid[newX][newY] == '1'){
                grid[newX][newY] = '2';
                queue.offer(new int[]{newX, newY});
            }
         }
        }
    }
}
