using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03_Printing_Triangle
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            PrintTriangle(n);
        }

        private static void PrintTriangle(int n)
        {
            PrintHalfTriangle(n, 0);
            PrintHalfTriangle(n, n);
        }

        private static void PrintHalfTriangle(int n, int a)
        {
            for (int row = 1; row <= n; row++)
            {
                for (int col = 1; col <= Math.Abs(a - row); col++)
                {
                    Console.Write(col + " ");
                }
                Console.WriteLine();
            }
        }
    }
}