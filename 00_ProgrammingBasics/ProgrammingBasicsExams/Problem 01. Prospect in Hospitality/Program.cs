using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_01.Prospect_in_Hospitality
{
    class Program
    {
        static void Main(string[] args)
        {
            uint b = uint.Parse(Console.ReadLine());
            uint r = uint.Parse(Console.ReadLine());
            uint c = uint.Parse(Console.ReadLine());
            uint t = uint.Parse(Console.ReadLine());
            uint o = uint.Parse(Console.ReadLine());
            decimal nSalary = decimal.Parse(Console.ReadLine());
            decimal usdCurrency = decimal.Parse(Console.ReadLine());
            decimal mySalary = decimal.Parse(Console.ReadLine());
            decimal budget = decimal.Parse(Console.ReadLine());

            decimal allSalary = (b * 1500.04m) + (r * 2102.10m) + (c * 1465.46m) +
                (t * 2053.33m) + (o * 3010.98m) + (nSalary * usdCurrency) + mySalary;

            Console.WriteLine("The amount is: {0:f2} lv.", allSalary);
            Console.WriteLine("{0} \\ {1}: {2:f2} lv.",
                allSalary <= budget ? "YES" : "NO",
                allSalary <= budget ? "Left" : "Need more",
                Math.Abs(budget-allSalary));
        }
    }
}
