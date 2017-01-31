using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03_19_TransportPrice
{
    class Program
    {
        static void Main(string[] args)
        {
            double n = double.Parse(Console.ReadLine());
            string dayPart = Console.ReadLine();

            double taxiStart = 0.70;
            double taxiDay = 0.79;
            double taxiNight = 0.90;

            double train = 0.00;
            double bus = 0.00;

            if (n >= 100)
            {
                train += 0.06;
                Console.WriteLine(train * n);
            }
            if ((n >= 20)&&(n<=99))
            {
                bus += 0.09;
                Console.WriteLine(bus * n);
            }
            else if ((dayPart == "day") && (n<=19))
            {
                Console.WriteLine(taxiStart + (n*taxiDay));
            }
            else if ((dayPart == "night") && (n <= 19))
            {
                Console.WriteLine(taxiStart + (n * taxiNight));
            }
        }
    }
}
