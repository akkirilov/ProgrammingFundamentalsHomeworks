using System;
using System.Globalization;

namespace _01_Softuni_Coffee_Orders
{
    public class SoftuniCoffeeOrders
    {
        public static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            decimal total = 0;

            for (int i = 0; i < n; i++)
            {
                decimal pricePerCapsule = decimal.Parse(Console.ReadLine());
                DateTime orderDate = DateTime.ParseExact(Console.ReadLine(), "d/M/yyyy", CultureInfo.InvariantCulture);
                long count = long.Parse(Console.ReadLine());

                int daysInMonth = DateTime.DaysInMonth(orderDate.Year, orderDate.Month);
                decimal coffeePrice = ((daysInMonth * count) * pricePerCapsule);

                Console.WriteLine($"The price for the coffee is: ${coffeePrice:f2}");

                total += coffeePrice;
            }

            Console.WriteLine($"Total: ${total:f2}");
        }
    }
}