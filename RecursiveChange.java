import java.util.Scanner;



class RecursiveChange
{
    
    public static int[] coins = new int[]{4,3,1};
    public static int[] money_arr = new int[1000000] ;
    
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        int money = scan.nextInt();
        System.out.println(""+Recursive_Change(money, coins));

        
    }

    public static int Recursive_Change(int money, int[] coins)
    {
        int MinNumCoins = 2147483646; 

        if(money == 0)
        {
            return 0 ;
        }
        else if( money_arr[money] != 0)
        {
            return money_arr[money] ;
        }
        else 
        {
            for(int i = 0 ; i < coins.length ; i++)
            {
                if(money >= coins[i])
                {
                    int NumofCoins = Recursive_Change(money - coins[i], coins) + 1 ;
                    if(NumofCoins < MinNumCoins)
                    {
                        MinNumCoins = NumofCoins  ;
                    }
                    money_arr[money - coins[i]] = MinNumCoins ; 

                }
            }

            return MinNumCoins ;
        }

       

         

    }
}