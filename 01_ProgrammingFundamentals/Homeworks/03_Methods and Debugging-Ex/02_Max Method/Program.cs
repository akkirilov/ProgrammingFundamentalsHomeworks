using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02_Max_Method
{
    class Program
    {
        static void Main(string[] args)
        {
            int num1 = int.Parse(Console.ReadLine());
            int num2 = int.Parse(Console.ReadLine());
            int num3 = int.Parse(Console.ReadLine());

            GetMax(num1, num2, num3);
        }

        private static void GetMax(int num1, int num2, int num3)
        {
            Console.WriteLine(Math.Max(Math.Max(num1, num2), num3));
        }
    }
}