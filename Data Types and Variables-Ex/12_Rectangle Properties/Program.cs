using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _12_Rectangle_Properties
{
    class Program
    {
        static void Main(string[] args)
        {
            double sideA = double.Parse(Console.ReadLine());
            double sideB = double.Parse(Console.ReadLine());

            Console.WriteLine(sideA * 2 + sideB * 2);
            Console.WriteLine(sideA * sideB);
            Console.WriteLine(Math.Sqrt((sideA * sideA) + (sideB * sideB)));
        }
    }
}