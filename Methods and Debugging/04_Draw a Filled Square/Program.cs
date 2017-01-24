using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04_Draw_a_Filled_Square
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            PrintSquare(n);
        }

        private static void PrintSquare(int n)
        {
            PrintStartEnd(n);
            PrintBoddy(n);
            PrintStartEnd(n);
        }

        private static void PrintBoddy(int n)
        {
            for (int i = 1; i < n-1; i++)
            {
                Console.Write('-');
                for (int j = 1; j < n; j++)
                {
                    Console.Write("\\/", n);
                }
                Console.WriteLine('-');
            }
        }

        private static void PrintStartEnd(int n)
        {
            Console.WriteLine(new string('-', 2 * n));
        }
    }
}