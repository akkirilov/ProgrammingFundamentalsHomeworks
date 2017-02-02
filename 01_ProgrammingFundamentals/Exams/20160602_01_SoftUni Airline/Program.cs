using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _20160602_01_SoftUni_Airline
{
    class Program
    {
        static void Main(string[] args)
        {
            decimal totallProfit = 0m;
            decimal averageProfit = 0m;

            int flights = int.Parse(Console.ReadLine());
            for (int i = 0; i < flights; i++)
            {
                int adultCount = int.Parse(Console.ReadLine());
                decimal adultPrice = decimal.Parse(Console.ReadLine());
                int youthCount = int.Parse(Console.ReadLine());
                decimal youthPrice = decimal.Parse(Console.ReadLine());
                decimal fuelPrice = decimal.Parse(Console.ReadLine());
                decimal fuelConsumption = decimal.Parse(Console.ReadLine());
                int flightDuration = int.Parse(Console.ReadLine());

                decimal profit = (adultCount * adultPrice) + (youthCount * youthPrice);
                decimal expenses = flightDuration * fuelConsumption * fuelPrice;
                profit -= expenses;
                if (profit >= 0)
                {
                    Console.WriteLine($"You are ahead with {profit:f3}$.");
                }
                else
                {
                    Console.WriteLine($"We've got to sell more tickets! We've lost {profit:f3}$.");
                }

                totallProfit += profit;
            }

            averageProfit = totallProfit / flights;

            Console.WriteLine($"Overall profit -> {totallProfit:f3}$.");
            Console.WriteLine($"Average profit -> {averageProfit:f3}$.");
        }
    }
}