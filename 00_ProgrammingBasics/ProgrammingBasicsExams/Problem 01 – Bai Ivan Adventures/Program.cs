using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_01___Bai_Ivan_Adventures
{
    class Program
    {
        static void Main(string[] args)
        {
            //26
            int day = int.Parse(Console.ReadLine());
            decimal alchoholPrice = 42;
            decimal money = decimal.Parse(Console.ReadLine());
            decimal wantedAlchohol = decimal.Parse(Console.ReadLine());

            if (day == 0)
            {
                alchoholPrice = 25;
            }
            else if (day == 1)
            {
                alchoholPrice = 21;
            }
            else if (day == 2)
            {
                alchoholPrice = 14;
            }
            else if (day == 3)
            {
                alchoholPrice = 17;
            }
            else if (day == 4)
            {
                alchoholPrice = 45;
            }
            else if (day == 5)
            {
                alchoholPrice = 59;
            }

            string condition = "sober";
            if ((money / alchoholPrice > 1.5m))
            {
                condition = "very drunk";
            }
            else if ((money / alchoholPrice <= 1.5m) && (money / alchoholPrice >= 1m))
            {
                condition = "drunk";
            }

            if (money / alchoholPrice > wantedAlchohol)
            {
                Console.WriteLine("Bai Ivan is {0} and very happy and he shared {1:f2} l. of alcohol with his friends"
                    ,condition, ((money / alchoholPrice) - wantedAlchohol));
            }
            else if (money / alchoholPrice == wantedAlchohol)
            {
                Console.WriteLine("Bai Ivan is {0} and happy. He is as drunk as he wanted"
                    , condition);
            }
            else
            {
                Console.WriteLine("Bai Ivan is {0} and quite sad. He wanted to drink another {1:f2} l. of alcohol"
                    , condition, (wantedAlchohol-(money / alchoholPrice)));
            }
        }
    }
}