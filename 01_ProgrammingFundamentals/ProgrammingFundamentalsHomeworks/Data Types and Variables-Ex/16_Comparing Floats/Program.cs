using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _16_Comparing_Floats
{
    class Program
    {
        static void Main(string[] args)
        {
            double a = double.Parse(Console.ReadLine());
            double b = double.Parse(Console.ReadLine());
            double eps = 0.000001;

            double max = Math.Max(a, b);
            double min = Math.Min(a, b);

            if (max - min <= eps)
            {
                Console.WriteLine("True");
            }
            else
            {
                Console.WriteLine("False");
            }
        }
    }
}