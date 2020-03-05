import java.util.Scanner ;
import java.lang.Integer ;

class Primitive_Cal_Better
{
    public static int[] arr = new int[10000000]  ;
    {
        arr[0] = 0 ;
        arr[1] = 0 ;
    }
   public static void main(String[] args)
   {
       Scanner scan = new Scanner(System.in) ;
       int num = scan.nextInt();
       System.out.println("" + numOps(num)) ; 
   } 

   public static int numOps(int num)
   {
        for(int i = 2 ; i < num + 1 ; i++)
        {
          int max1 = arr[i - 1] ;
          int max2 = Integer.MAX_VALUE ; 
          int max3 = Integer.MAX_VALUE ;

          if( i % 2 == 0)
          {
              max2 = arr[i/2];
          }
          if( i % 3 == 0)
          {
              max3 = arr[i/3];
          }

          int min = Math.min(max1, Math.min(max2,max3));

          arr[i] = min + 1 ; 

        }

        return arr[num] ; 
   }
}