using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06_Math_Power
{
    class Program
    {
        static void Main(string[] args)
        {
            double baseNumber = double.Parse(Console.ReadLine());
            int pow = int.Parse(Console.ReadLine());

            double result = GetPowedNumber(baseNumber, pow);

            Console.WriteLine(result);
        }

        private static double GetPowedNumber(double baseNumber, int pow)
        {
            double result = 1;

            for (int i = 0; i < pow; i++)
            {
                result *= baseNumber;
            }

            return result;
        }
    }
}