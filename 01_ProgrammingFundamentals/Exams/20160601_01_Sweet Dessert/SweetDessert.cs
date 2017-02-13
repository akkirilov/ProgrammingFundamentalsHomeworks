using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _20160601_01_Sweet_Dessert
{
    class SweetDessert
    {
        static void Main(string[] args)
        {
            decimal cash = decimal.Parse(Console.ReadLine());
            int guests = int.Parse(Console.ReadLine());
            decimal bananasPriceU = decimal.Parse(Console.ReadLine());
            decimal eggsPriceU = decimal.Parse(Console.ReadLine());
            decimal berriesPriceKG = decimal.Parse(Console.ReadLine());

            int sets = (guests / 6) + 1;
            if (guests % 6 == 0)
            {
                sets--;
            }

            int bananasNeeded = sets * 2;
            int eggsNeeded = sets * 4;
            decimal berriesNeeded = sets * 0.2m;

            decimal costAll = (bananasNeeded * bananasPriceU) + (eggsNeeded * eggsPriceU) + (berriesNeeded * berriesPriceKG);

            if (cash >= costAll)
            {
                Console.WriteLine("Ivancho has enough money - it would cost {0:f2}lv.", costAll);
            }
            else
            {
                Console.WriteLine("Ivancho will have to withdraw money - he will need {0:f2}lv more.", (costAll - cash));
            }
        }
    }
}