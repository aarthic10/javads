package com.practice.walmartTest;

public class WordSearch {
	
	public static void main(String args[]) {
		char[][] board = new char[][] {
			{'A','B','C','E'},
			{'S','F','C','S'},
			{'A','D','E','E'}};
			
		System.out.println(isExist(board,"SEE"));
	}
	
	
	public static boolean isExist(char[][] board, String word) {
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				 if(isExist(board, word, i, j, 0)) {
					 return true;
				 }
			}
		}
		
		return false;
		
	}
	
	
	public static boolean isExist(char[][]board, String word, int i, int j, int k) {
		
		int columnLen = board.length;
		int rowLen = board[0].length;
		
		if(i<0 || j<0 || i>=columnLen || j>=rowLen) {
			return false;
		}
		
		if(k == word.length()-1) {
			return true;
		} else if(board[i][j] == word.charAt(k)) {
			char temp = board[i][j];
			board[i][j] = '#';
			if(isExist(board, word, i-1,j,k+1) ||
					isExist(board, word, i+1, j, k+1) ||
					isExist(board, word, i, j-1, k+1) ||
					isExist(board, word, i, j+1, k+1)) {
				return true;
			}
			
			board[i][j] = temp;
		}
		
		return false;
	}

	//Modified Graph DFS
	public static boolean exist(char[][] board, String word) {
	    int m = board.length;
	    int n = board[0].length;
	 
	    boolean result = false;
	    for(int i=0; i<m; i++){
	        for(int j=0; j<n; j++){
	           if(dfs(board,word,i,j,0)){
	               result = true;
	           }
	        }
	    }
	 
	    return result;
	}
	 
	public static boolean dfs(char[][] board, String word, int i, int j, int k){
	    int m = board.length;
	    int n = board[0].length;
	 
	    if(i<0 || j<0 || i>=m || j>=n){
	        return false;
	    }
	 
	    if(board[i][j] == word.charAt(k)){
	        char temp = board[i][j];
	        board[i][j]='#';
	        if(k==word.length()-1){
	            return true;
	        }else if(dfs(board, word, i-1, j, k+1)
	        ||dfs(board, word, i+1, j, k+1)
	        ||dfs(board, word, i, j-1, k+1)
	        ||dfs(board, word, i, j+1, k+1)){
	            return true;
	        }
	        board[i][j]=temp;
	    }
	 
	    return false;
	}
}
