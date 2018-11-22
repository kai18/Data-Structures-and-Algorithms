/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

public class EditDistance {
public static int min(int a, int b, int c){
		int x = Math.min(a, b);
		return Math.min(x, c);
	}

	public static int findDistance(String s1, String s2, int n, int m){
		int dp[][] = new int[s1.length()+1][s2.length()+1];
		for(int i = 0; i <= n; i++){
			for(int j = 0; j <= m; j++){

				if(i == 0)
					dp[i][j] = j;
				else if(j == 0)
				    dp[i][j] = i;

				else if(s1.charAt(i-1) == s2.charAt(j-1))
					dp[i][j] = dp[i-1][j-1];
				else
					dp[i][j] = 1 + min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]);
			}
		}

		return dp[n][m];

	}

	public static void main(String args[]){
		System.out.println(findDistance("abcefg", "abcdef", 6, 6));
	}
}