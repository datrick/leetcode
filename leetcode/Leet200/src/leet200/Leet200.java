package leet200;

public class Leet200 {

	private void defineTerritory(char[][] grid, int i, int j){
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
			return;
		if (grid[i][j] == '1'){
			grid[i][j] = 'v';
			defineTerritory(grid, i - 1, j);
			defineTerritory(grid, i + 1, j);
			defineTerritory(grid, i, j + 1);
			defineTerritory(grid, i, j - 1);
		}
		return;
	}
	public int numIslands(char[][] grid) {
		int num = 0;
		for (int i = 0; i < grid.length; i ++)
			for (int j = 0; j < grid[0].length; j ++){
				if (grid[i][j] == '1'){
					num += 1;
					this.defineTerritory(grid, i, j);
				}
			}
		return num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid = { 	{'1', '0', '1', '0', '1'},
							{'1', '1', '1', '0', '1'},
							{'0', '1', '1', '0', '1'}, 
							{'0', '0', '1', '1', '1'}	}; 
		System.out.println(new Leet200().numIslands(grid));
		}
	
}
