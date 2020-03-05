import java.util.Scanner ;
import java.lang.* ;
import java.util.Arrays;

class Edit_Distance_3
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        String str1 = scan.nextLine();

        String str2 = scan.nextLine();

        int[][] memo = new int[str1.length()+1][str2.length()+1] ;

        for(int[] row : memo)
        {
            Arrays.fill(row,-1) ;

        }

        System.out.println(""+editDistance(str1, str2, str1.length() , str2.length(), memo));


    }

    public static int miniumum(int num1, int num2 , int num3)
    {

        return Math.min(num1 , Math.min(num2, num3)) ;
    }

    public static int editDistance(String strA , String strB, int Index_A , int Index_B, int[][] memo)
    {


        if(memo[Index_A][Index_B] != -1)
        {
            return memo[Index_A][Index_B];
        }

        if(Index_A == 0)
        {
            memo[Index_A][Index_B] =  Index_B ;
            return memo[Index_A][Index_B] ; 
        }

        if(Index_B == 0 )
        {
            memo[Index_A][Index_B] =  Index_A ;
        }

        if(Index_A > 0) 
        {
            if(Index_B > 0)
            {
                if(strA.charAt(Index_A - 1) == strB.charAt(Index_B - 1))
        {
                //System.out.println(strA.charAt(Index_A ) + " " + strB.charAt(Index_B));
            memo[Index_A][Index_B] = editDistance(strA, strB, Index_A-1, Index_B-1, memo);
            return memo[Index_A][Index_B] ; 
        }

        memo[Index_A][Index_B]  = miniumum(
                        1 + editDistance(strA, strB, Index_A, Index_B-1,memo), //insertion
                        1 + editDistance(strA, strB, Index_A-1, Index_B,memo), //Removal
                        1 + editDistance(strA, strB, Index_A-1, Index_B-1,memo)//Substitution 
                        ) ;
            }
        }

        return memo[Index_A][Index_B] ;
    
    }

        
    
}