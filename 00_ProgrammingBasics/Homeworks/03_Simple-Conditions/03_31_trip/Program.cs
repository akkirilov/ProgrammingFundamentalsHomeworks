using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03_31_trip
{
    class Program
    {
        static void Main(string[] args)
        {
            double n = double.Parse(Console.ReadLine());
            string seson = Console.ReadLine();
            double harch = n;

            if (n > 1000)
            {
                harch *= 0.9;
                Console.WriteLine("Somewhere in Europe");
                Console.WriteLine("Hotel - {0:0.00}", harch);
            }

            if ((n <= 1000) && (n > 100))
            {
                if (seson == "summer")
                {
                    harch *= 0.4;
                    Console.WriteLine("Somewhere in Balkans");
                    Console.WriteLine("Camp - {0:0.00}", harch);
                }
                if (seson == "winter")
                {
                    harch *= 0.8;
                    Console.WriteLine("Somewhere in Balkans");
                    Console.WriteLine("Hotel - {0:0.00}", harch);
                }

            }
            if (n <= 100)
            {
                if (seson == "summer")
                {
                    harch *= 0.3;
                    Console.WriteLine("Somewhere in Bulgaria");
                    Console.WriteLine("Camp - {0:0.00}", harch);
                }
                if (seson == "winter")
                {
                    harch *= 0.7;
                    Console.WriteLine("Somewhere in Bulgaria");
                    Console.WriteLine("Hotel - {0:0.00}", harch);
                }

            }
        }
    }
}
