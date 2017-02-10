using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Globalization;

namespace _20161001_01_Softuni_Coffee_Orders
{
    class SoftuniCoffeeOrders
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            decimal totalPrice = 0;

            for (int i = 0; i < n; i++)
            {
                decimal pricePerCapsule = decimal.Parse(Console.ReadLine());
                DateTime orderDate = DateTime.ParseExact(Console.ReadLine(), "d\\/M\\/yyyy", CultureInfo.InvariantCulture);
                int daysInMonth = DateTime.DaysInMonth(orderDate.Year, orderDate.Month);
                long capsulesCount = long.Parse(Console.ReadLine());

                decimal orderPrice = ((daysInMonth * capsulesCount) * pricePerCapsule);

                Console.WriteLine($"The price for the coffee is: ${orderPrice:f2}");

                totalPrice += orderPrice;
            }

            Console.WriteLine($"Total: ${totalPrice:f2}");

        }
    }
}