using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_04___SmartLilly
{
    class Program
    {
        static void Main(string[] args)
        {
            //8 min.
            int age = int.Parse(Console.ReadLine());
            double washingMachine = double.Parse(Console.ReadLine());
            int toyPrice = int.Parse(Console.ReadLine());

            double money = 0d;
            double curMoney = 10d;

            for (int i = 1; i <= age; i++)
            {
                if (i%2==0)
                {
                    money += curMoney-1;
                    curMoney += 10;
                }
                else
                {
                    money += toyPrice;
                }
            }
            if (money >= washingMachine)
            {
                Console.WriteLine("Yes! {0:f2}", (money-washingMachine));
            }
            else
            {
                Console.WriteLine("No! {0:f2}", (washingMachine-money));
            }
        }
    }
}