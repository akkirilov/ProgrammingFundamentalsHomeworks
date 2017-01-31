using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_04___Passion_Days
{
    class Program
    {
        static void Main(string[] args)
        {
            decimal money = decimal.Parse(Console.ReadLine());
            int count = 0;
            string enter = "";
            string buy = "";
            char ch;
            decimal totalSpend = 0;
            for (;;)
            {
                enter = Console.ReadLine();
                if (enter == "mall.Enter")
                {
                    break;
                }    
            }
            
            if (enter == "mall.Enter")
            {
                for (int i = 0; i <= money;)
                {
                    buy = Console.ReadLine();
                    if (buy == "mall.Exit")
                    {
                        break;
                    }
                    for (int ii = 0; ii < buy.Length; ii++)
                    {
                        if (buy == "mall.Exit")
                        {
                            break;
                        }
                        ch = buy[ii];
                        if ((ch >= 'A') && (ch <= 'Z'))
                        {
                            totalSpend = (ch - (ch * 0.5m));
                            count++;
                            money -= totalSpend;
                            if (money<0)
                            {
                                count--;
                                money = money + totalSpend;
                            }
                        }
                        else if ((ch >= 'a') && (ch <= 'z'))
                        {
                            totalSpend = (ch - (ch * 0.7m));
                            count++;
                            money -= totalSpend;
                            if (money < 0)
                            {
                                count--;
                                money = money + totalSpend;
                            }
                        }
                        else if ((ch == '%') && (money>0))
                        {
                            money = money / 2;
                            count++;
                            if (money < 0)
                            {
                                count--;
                                money = money * 2;
                            }
                        }
                        else if (ch == '*')
                        {
                            money += 10;
                        }
                        else
                        {
                            money = money - ch;
                            count++;
                            if (money < 0)
                            {
                                count--;
                                money = money + ch;
                            }
                        }
                    }
                }
                if (count == 0)
                {
                    Console.WriteLine("No purchases. Money left: {0:f2} lv.", money);
                }
                else if (count > 0)
                {
                    Console.WriteLine("{0} purchases. Money left: {1:f2} lv.", count, money);
                }
            }
        }
    }
}
