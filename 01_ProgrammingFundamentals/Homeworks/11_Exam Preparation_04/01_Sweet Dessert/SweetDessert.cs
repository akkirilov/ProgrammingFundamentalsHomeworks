using System;

namespace _01_Sweet_Dessert
{
    public class SweetDessert
    {
        static void Main()
        {
            decimal moneyForProducts = decimal.Parse(Console.ReadLine());
            int totalGuests = int.Parse(Console.ReadLine());
            decimal bananaPrice = decimal.Parse(Console.ReadLine());
            decimal eggPrice = decimal.Parse(Console.ReadLine());
            decimal berries = decimal.Parse(Console.ReadLine());

            int totalPortions = totalGuests / 6 + 1;
            if (totalGuests % 6 == 0)
            {
                totalPortions--;
            }

            decimal totalPrice = totalPortions * ((bananaPrice * 2) + (eggPrice * 4) + (berries / 5));

            if (moneyForProducts >= totalPrice)
            {
                Console.WriteLine("Ivancho has enough money - it would cost {0:f2}lv.", totalPrice);
            }
            else
            {
                Console.WriteLine("Ivancho will have to withdraw money - he will need {0:f2}lv more.", (totalPrice - moneyForProducts));
            }
        }
    }
}