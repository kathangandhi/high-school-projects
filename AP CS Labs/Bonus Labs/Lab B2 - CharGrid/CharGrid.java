public class CharGrid{
    char[][] grid;
    
    public CharGrid(char[][] grid){
        this.grid = grid;
    }
    
    @Override
    public String toString(){
        String print = new String();
        
        for(char[] arr: grid){
            for(char letter: arr){
                print += letter;
            }
            print += "\n";
        }
        
        return print;
    }
    
    public int charArea(char ch){
        int[] occurences = new int[4];
        boolean foundOne = false;
        
        for(int I = 0; I < grid.length; I++){
            for(int i = 0; i < grid[I].length; i++){
                if(grid[I][i] == ch && !foundOne){
                    foundOne = true;
                    occurences[0] = I;
                    occurences[1] = i;
                }
                else if(grid[I][i] == ch){
                    occurences[2] = I;
                    occurences[3] = i;
                }
            }
        }
        
        int area = (occurences[2]-occurences[0]+1)*(occurences[3]-occurences[1]+1);
        return area;
    }
    
    public int countPlus(){
        int plusCount = 0;
        
        for(int I = 0; I < grid.length; I++){
            for(int i = 0; i < grid[I].length; i++){
                plusCount += this.checkArms(I,i,grid[I][i]);
            }
        }
        
        return plusCount;
    }
    
    public int checkArms(int r, int c, char ch){
        int armLength = 0;
        int row = r+1;
        int col = c;
        
        if(grid[r][c] == ' ')
            return 0;
        
        while(row < grid.length && grid[row][col] == ch){
            armLength++;
            row++;
        }
            
        if(armLength == 0)
            return 0;
        else{
            row = r-1;
            col = c;
            for(int i = armLength; i > 0; i--, row--){
                if(row < 0 || grid[row][col] != ch)
                    return 0;    
            }
            
            row = r;
            col = c-1;
            for(int i = armLength; i > 0; i--, col--){
                if(col < 0 || grid[row][col] != ch)
                    return 0;    
            }
            
            row = r;
            col = c+1;
            for(int i = armLength; i > 0; i--, col++){
                if(col == grid[row].length || grid[row][col] != ch)
                    return 0;    
            }
        }
        
        return 1;
    }    
}
