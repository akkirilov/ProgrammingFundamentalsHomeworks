using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Numerics;

namespace Problem_01
{
    public class Problem01
    {
        public static void Main()
        {
            BigInteger wingFlaps = BigInteger.Parse(Console.ReadLine());
            decimal distance = decimal.Parse(Console.ReadLine());
            BigInteger endurance = BigInteger.Parse(Console.ReadLine());

            decimal flight = ((decimal)(wingFlaps / 1000) * distance);
            BigInteger time = (wingFlaps / 100);
            time += ((wingFlaps / endurance) * 5);

            Console.WriteLine($"{flight:f2} m.");
            Console.WriteLine($"{time} s.");
        }
    }
}