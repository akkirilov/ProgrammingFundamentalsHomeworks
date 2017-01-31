using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_03___Sunlight
{
    class Program
    {
        static void Main(string[] args)
        {
            //10 min.
            int n = int.Parse(Console.ReadLine());

            int outD = 1;
            int insD = (n * 3 - 5) / 2;
            Console.Write(new string('.', (n * 3) / 2));
            Console.Write(new string('*', 1));
            Console.Write(new string('.', (n * 3) / 2));
            Console.WriteLine();
            for (int i = 0; i < n-1; i++)
            {
                Console.Write(new string('.', outD));
                Console.Write(new string('*', 1));
                Console.Write(new string('.', insD));
                Console.Write(new string('*', 1));
                Console.Write(new string('.', insD));
                Console.Write(new string('*', 1));
                Console.Write(new string('.', outD));
                Console.WriteLine();
                outD++;
                insD--;
            }
            for (int i = 0; i < n/2; i++)
            {
                Console.Write(new string('.', n));
                Console.Write(new string('*', n));
                Console.Write(new string('.', n));
                Console.WriteLine();
            }
            Console.Write(new string('*', n*3));
            Console.WriteLine();
            for (int i = 0; i < n / 2; i++)
            {
                Console.Write(new string('.', n));
                Console.Write(new string('*', n));
                Console.Write(new string('.', n));
                Console.WriteLine();
            }
            for (int i = 0; i < n - 1; i++)
            {
                outD--;
                insD++;
                Console.Write(new string('.', outD));
                Console.Write(new string('*', 1));
                Console.Write(new string('.', insD));
                Console.Write(new string('*', 1));
                Console.Write(new string('.', insD));
                Console.Write(new string('*', 1));
                Console.Write(new string('.', outD));
                Console.WriteLine();
            }
            Console.Write(new string('.', (n * 3) / 2));
            Console.Write(new string('*', 1));
            Console.Write(new string('.', (n * 3) / 2));
            Console.WriteLine();
        }
    }
}