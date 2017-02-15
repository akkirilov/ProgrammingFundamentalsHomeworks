using System;
using System.Linq;
using System.Text;
using System.Numerics;

namespace _01_Convert_from_base_10_to_base_N
{
    public class ConvertFromBase10ToBaseN
    {
        public static void Main()
        {
            string[] parameters = Console.ReadLine()
                .Split()
                .ToArray();

            int toBase = int.Parse(parameters[0]);
            BigInteger number = BigInteger.Parse(parameters[1]);

            StringBuilder result = new StringBuilder();
            while (number != 0)
            {
                result.Insert(0, number % toBase);
                number /= toBase;
            }

            Console.WriteLine(result.ToString());
        }
    }
}