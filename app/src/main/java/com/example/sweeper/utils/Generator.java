package com.example.sweeper.utils;
import java.util.Random;

public class Generator {

    public static int[][] generate( int bombnumber , final int width , final int height){
        // Random for generating numbers
        Random r = new Random();

        int [][] grid = new int[width][height];
        for( int x = 0 ; x< width ;x++ ){
            grid[x] = new int[height];
        }

        while( bombnumber > 0 ){
            int x = r.nextInt(width);
            int y = r.nextInt(height);

            // -1 is the bomb
            if( grid[x][y] != -1 ){
                grid[x][y] = -1;
                bombnumber--;
            }
        }
        grid = calculateNeigbours(grid,width,height);

        return grid;
    }

    private static int[][] calculateNeigbours( int[][] grid , final int width , final int height){
        for( int x = 0 ; x < width ; x++){
            for( int y = 0 ; y < height ; y++){
                grid[x][y] = getNeighbourNumber(grid,x,y,width,height);
            }
        }

        return grid;
    }

    private static int getNeighbourNumber( final int grid[][] , final int x , final int y , final int width , final int height){
        if( grid[x][y] == -1 ){
            return -1;
        }

        int count = 0;
        for( int i = -1 ; i <= 1 ; i++ ){
            for( int j = -1 ; j <= 1 ; j++ ){
                if( x+i >= 0 && y+j >= 0 && x+i < width && y+j < height ){
                    if( grid[x+i][y+j] == -1 ){
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private static boolean isMineAt( final int [][] grid, final int x , final int y , final int width , final int height){
        if( x >= 0 && y >= 0 && x < width && y < height ){
            if( grid[x][y] == -1 ){
                return true;
            }
        }
        return false;
    }

}
