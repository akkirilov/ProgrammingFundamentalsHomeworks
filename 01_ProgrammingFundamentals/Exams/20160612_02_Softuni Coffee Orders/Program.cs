using System;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _20160612_02_Softuni_Coffee_Orders
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            decimal totalOrderPrice = 0;

            for (int i = 0; i < n; i++)
            {
                decimal pricePerCapsule = decimal.Parse(Console.ReadLine());
                int daysInMonth = GetDaysInMounth(Console.ReadLine());
                int capsulesCount = int.Parse(Console.ReadLine());

                decimal currentOrderPrice = ((decimal)daysInMonth * (decimal)capsulesCount * pricePerCapsule);
                Console.WriteLine("The price for the coffee is: ${0:f2}", Math.Round(currentOrderPrice, 2));
                totalOrderPrice += currentOrderPrice;
            }

            Console.WriteLine("Total: ${0:f2}", Math.Round(totalOrderPrice, 2));
        }

        private static int GetDaysInMounth(string date)
        {
            DateTime orderDate = DateTime.ParseExact(date, @"d\/M\/yyyy", CultureInfo.InvariantCulture);
            int days = DateTime.DaysInMonth((int)orderDate.Year, (int)orderDate.Month);
            return days;
        }
    }
}