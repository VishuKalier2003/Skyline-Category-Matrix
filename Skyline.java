/* There is a city composed of n x n blocks, where each block contains a single building shaped like a vertical 
square prism. You are given a 0-indexed n x n integer matrix grid where grid[r][c] represents the height of the 
building located in the block at row r and column c. A city's skyline is the outer contour formed by all the building 
when viewing the side of the city from a distance. The skyline from each cardinal direction north, east, south, and 
west may be different. We are allowed to increase the height of any number of buildings by any amount (the amount 
can be different per building). The height of a 0-height building can also be increased. However, increasing the 
height of a building should not affect the city's skyline from any cardinal direction.
Return the maximum total sum that the height of the buildings can be increased by without changing the city's skyline 
from any cardinal direction.
* Eg 1 : grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]      Output = 35 
* Eg 2 : grid = [[0,0,0],[0,0,0],[0,0,0]]                      Output = 0  
*/
import java.util.*;
public class Skyline
{
      public int MaximumIncreaseInSkyline(int grid[][])
      {
            int MaxRows[] = new int[grid.length];       //* Array Declaration -> O(N)
            int MaxCols[] = new int[grid.length];       //* Array Declaration -> O(N)
            for(int i = 0; i < MaxRows.length; i++)    //! Grid Traversa; -> O(N ^ 2)
            {
                  for(int j = 0; j < MaxCols.length; j++)
                  {
                        MaxRows[i] = Math.max(MaxRows[i], grid[i][j]);   // Storing the max element of ith row...
                        MaxCols[i] = Math.max(MaxCols[i], grid[j][i]);   // Storing the max element of ith column...
                  }
            }
            int sum = 0;     //*  Variable Declaration -> O(1)
            for(int i = 0; i < grid.length; i++)      //! Grid Traversal -> O(N x M)
            {
                  for(int j = 0; j < grid.length; j++)    // Taking the min, since it will not disturb the skyline...
                        sum = sum + Math.abs(grid[i][j] - Math.min(MaxRows[i], MaxCols[j]));
            }
            return sum;
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            int row, col;
            System.out.print("Enter number of Rows : ");
            row = sc.nextInt();
            System.out.print("Enter number of Columns : ");
            col = sc.nextInt();
            int grid[][] = new int[row][col];
            for(int i = 0; i < grid.length; i++)
            {
                  for(int j = 0; j < grid[0].length; j++)
                  {
                        System.out.print("Enter value of "+(i+1)+" row and "+(j+1)+" column : ");
                        grid[i][j] = sc.nextInt();
                  }
            }
            Skyline skyline = new Skyline();       // Object creation...
            System.out.println("The Maximum Increase to maintain Skyline : "+skyline.MaximumIncreaseInSkyline(grid));
            sc.close();
      }
}


//! Time Complexity -> O(N x N)
//* Space Complexity -> O(N)