using System;

namespace _20161002_01_SweetDesert
{
    class SweetDesert
    {
        static void Main()
        {
            decimal totalMoney = decimal.Parse(Console.ReadLine());
            int guests = int.Parse(Console.ReadLine());
            decimal bananasPriceUnit = decimal.Parse(Console.ReadLine());
            decimal eggsPriceUnit = decimal.Parse(Console.ReadLine());
            decimal berriesKG = decimal.Parse(Console.ReadLine());

            int portions = guests / 6 + 1;
            if (guests % 6 == 0)
            {
                portions--;
            }

            decimal totalPrice = portions * ((bananasPriceUnit * 2) + (eggsPriceUnit * 4) + (berriesKG / 5));

            if (totalMoney >= totalPrice)
            {
                Console.WriteLine("Ivancho has enough money - it would cost {0:f2}lv.", totalPrice);
            }
            else
            {
                Console.WriteLine("Ivancho will have to withdraw money - he will need {0:f2}lv more.", (totalPrice - totalMoney));
            }
        }
    }
}