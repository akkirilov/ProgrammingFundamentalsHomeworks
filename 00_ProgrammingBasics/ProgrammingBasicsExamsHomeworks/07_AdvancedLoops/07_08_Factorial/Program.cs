using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07_08_Factorial
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int f = 1;

            for (int i = 2; i <= n; i++)
            {
                f *= i;
            }
            Console.WriteLine(f);
        }
    }
}
