using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_03____Match_Tickets
{
    class Program
    {
        static void Main(string[] args)
        {
            //10 min.
            double bud = double.Parse(Console.ReadLine());
            string cat = Console.ReadLine();
            int br = int.Parse(Console.ReadLine());

            if (br <= 4)
            {
                bud = bud - bud * 0.75;
            }
            else if (br > 4 && br <= 9)
            {
                bud = bud - bud * 0.6;
            }
            else if (br >= 10 && br <= 24)
            {
                bud = bud - bud * 0.5;
            }
            else if (br >= 25 && br <= 49)
            {
                bud = bud - bud * 0.4;
            }
            else
            {
                bud = bud - bud * 0.25;
            }

            if (cat == "Normal")
            {
                bud = bud - (br * 249.99);
            }
            else
            {
                bud = bud - (br * 499.99);
            }

            if (bud >= 0)
            {
                Console.WriteLine("Yes! You have {0:f2} leva left.", bud);
            }
            else
            {
                Console.WriteLine("Not enough money! You need {0:f2} leva.", Math.Abs(bud));
            }
        }
    }
}