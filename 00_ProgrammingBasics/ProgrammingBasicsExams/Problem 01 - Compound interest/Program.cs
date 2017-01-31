using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_01___Compound_interest
{
    class Program
    {
        static void Main(string[] args)
        {
            //15 min.
            double p = double.Parse(Console.ReadLine());
            int y = int.Parse(Console.ReadLine());
            double rateB = double.Parse(Console.ReadLine()) + 1;
            double rateF = double.Parse(Console.ReadLine()) + 1;

            double pB = p * (Math.Pow(rateB, y));
            double pF = p * rateF;

            if (pF<=pB)
            {
                Console.WriteLine("{0:f2} Friend", pF);
            }
            else
            {
                Console.WriteLine("{0:f2} Bank", pB);
            }
        }
    }
}