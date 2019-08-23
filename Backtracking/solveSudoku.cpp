#include<iostream> 
#include<bits/stdc++.h>
#define DIM 9 

using namespace std ;

void printGrid(int **grid){
    for(int x =0;x<9;x++){
        for(int y=0;y<9;y++){
            cout<<grid[x][y]<<" " ;
        }
        //cout<<endl;
    }
}


bool usedInRow(int **grid , int row , int element){
    
    for(int col =0;col<DIM;col++){
        if(grid[row][col]==element)
           return true ;     
    }
    return false ;
}


bool usedInCol(int **grid , int col , int element ){
    for(int row= 0 ;row<DIM;row++){
        if(grid[row][col]==element)
         return true ;
    }
    return false ;
}

bool usedIn3X3Grid(int **grid , int startPointRow , int startPointCol , int element){
    
    for(int row =0;row<3;row++){
        for(int col= 0 ;col<3;col++){
            if(grid[row+startPointRow][col+startPointCol]==element)
             return true ;
        }
    }
    return false ; 
    
}

bool isSafe(int **grid, int row, int col, int num)
{
	return !usedInRow(grid, row, num) &&
		!usedInCol(grid, col, num) &&
		!usedIn3X3Grid(grid, row - row % 3, col - col % 3, num);
}

pair<int, int> getUnassignedLocation(int **grid)
{
	for (int row = 0; row < DIM; row++)
		for (int col = 0; col < DIM; col++)
			if (grid[row][col] == 0)
			{
				return make_pair(row, col);
			}
	return make_pair(9,9);
}


bool solveSudoku(int **grid){
    
    if(getUnassignedLocation(grid)==make_pair(9,9))
     return true ; //we are done 
    
    pair<int,int> location = getUnassignedLocation(grid);
    int row = location.first ;
    int col = location.second ; 
    
    for(int x =1;x<=9;x++){
        
        if(isSafe(grid , row , col , x)){
            grid[row][col] = x ;
            
            if(solveSudoku(grid)){
                return true ;
            }
            
            grid[row][col] = 0 ; 
        }
    }
      return false ;
}


int main(){
    int test ;
    cin>>test ;
    while(test--){
        int ** grid = new int*[9] ;
        for(int x=0;x<9;x++){
            grid[x] = new int[9] ;
        }
        
        for(int x =0;x<9;x++){
            for(int y=0;y<9;y++){
                cin>>grid[x][y] ;
            }
        }
        
        if(solveSudoku(grid))
         printGrid(grid);
        else
        printGrid(grid);
        cout<<endl; 
    }
    return 0 ;
}
