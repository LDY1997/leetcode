package algorithm;

public class dfs {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

      public void changeLands(char[][] grid,int i,int j){
          if (i>=0 && j>=0 && i< grid.length && j <grid[0].length && grid[i][j] == '1'){
              grid[i][j] = '0';
              changeLands(grid,i-1,j);
              changeLands(grid,i,j-1);
              changeLands(grid,i+1,j);
              changeLands(grid,i,j+1);
          }

      }

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1'){
                    changeLands(grid,i,j);
                    count ++;
                }
            }
        }
        return count;
    }

}
