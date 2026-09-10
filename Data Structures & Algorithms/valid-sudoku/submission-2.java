
class Solution {
    public boolean isValidSudoku(char[][] board) {
       Set<Character>[] rowSet = new HashSet[9];
       Set<Character>[] colSet = new HashSet[9];
       Set<Character>[] boxSet = new HashSet[9];

       for(int i = 0; i < 9; i++){
        rowSet[i] = new HashSet<>();
        colSet[i] = new HashSet<>();
        boxSet[i] = new HashSet<>();
       }

       for(int i = 0; i < 9; i++){
        for(int j = 0; j < 9; j++){

            char c = board[i][j];
            if (c == '.')
                continue;

            int boxIndex = (i/3) * 3 + j/3;

            if (!rowSet[i].add(c)) return false;
            if (!colSet[j].add(c)) return false;
            if (!boxSet[boxIndex].add(c)) return false;
        }
       }

       return true; 
    }
}
