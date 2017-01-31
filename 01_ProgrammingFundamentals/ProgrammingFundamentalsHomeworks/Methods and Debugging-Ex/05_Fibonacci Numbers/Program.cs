using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05_Fibonacci_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            PrintNFib(n);
        }

        private static void PrintNFib(int n)
        {
            if (n == 0 || n == 1)
            {
                Console.WriteLine(1);
            }
            else if (n == 2)
            {
                Console.WriteLine(2);
            }
            else
            {
                long a = 1;
                long b = 1;
                long c = 2;
                while (n - 1 > 0)
                {
                    c = a + b;
                    a = b;
                    b = c;
                    n--;
                }
                Console.WriteLine(c);
            }
        }
    }
}