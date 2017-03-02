using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04_02_SmallShop
{
    class Program
    {
        static void Main(string[] args)
        {

            string product = Console.ReadLine().ToLower();
            string town = Console.ReadLine().ToLower();
            double amount = double.Parse(Console.ReadLine());

            double price = 0.00;

            if (product == "coffee")
            {
                if (town == "sofia")
                {
                    price += 0.50;
                }
                else if (town == "plovdiv")
                {
                    price += 0.40;
                }
                else if (town == "varna")
                {
                    price += 0.45;
                }
            }
            else if (product == "water")
            {
                if (town == "sofia")
                {
                    price += 0.80;
                }
                else if (town == "plovdiv")
                {
                    price += 0.70;
                }
                else if (town == "varna")
                {
                    price += 0.70;
                }
            }
            else if (product == "beer")
            {
                if (town == "sofia")
                {
                    price += 1.20;
                }
                else if (town == "plovdiv")
                {
                    price += 1.15;
                }
                else if (town == "varna")
                {
                    price += 1.10;
                }
            }
            else if (product == "sweets")
            {
                if (town == "sofia")
                {
                    price += 1.45;
                }
                else if (town == "plovdiv")
                {
                    price += 1.30;
                }
                else if (town == "varna")
                {
                    price += 1.35;
                }
            }
            else if (product == "peanuts")
            {
                if (town == "sofia")
                {
                    price += 1.60;
                }
                else if (town == "plovdiv")
                {
                    price += 1.50;
                }
                else if (town == "varna")
                {
                    price += 1.55;
                }
            }
            Console.WriteLine(price * amount);
        }
    }
}
