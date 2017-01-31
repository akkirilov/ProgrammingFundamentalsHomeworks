using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_03___Dumbbell
{
    class Program
    {
        static void Main(string[] args)
        {
            //13 min.
            int n = int.Parse(Console.ReadLine());
            int outDots = n / 2;
            int inDots = n / 2;

            Console.Write(new string('.', outDots));
            Console.Write(new string('&', n / 2 + 1));
            Console.Write(new string('.', n ));
            Console.Write(new string('&', n / 2 + 1));
            Console.Write(new string('.', outDots));
            Console.WriteLine();

            outDots--;
            for (int i = 0; i < n/2; i++)
            {
                Console.Write(new string('.', outDots));
                Console.Write(new string('&', 1));
                Console.Write(new string('*', inDots));
                Console.Write(new string('&', 1));
                if (i + 1 != n / 2)
                {
                    Console.Write(new string('.', n));
                }
                else
                {
                    Console.Write(new string('=', n));
                }
                Console.Write(new string('&', 1));
                Console.Write(new string('*', inDots));
                Console.Write(new string('&', 1));
                Console.Write(new string('.', outDots));
                Console.WriteLine();
                outDots--;
                inDots++;
            }

            outDots++;
            inDots--;
            for (int i = 0; i < n / 2 - 1; i++)
            {
                outDots++;
                inDots--;
                Console.Write(new string('.', outDots));
                Console.Write(new string('&', 1));
                Console.Write(new string('*', inDots));
                Console.Write(new string('&', 1));
                Console.Write(new string('.', n));
                Console.Write(new string('&', 1));
                Console.Write(new string('*', inDots));
                Console.Write(new string('&', 1));
                Console.Write(new string('.', outDots));
                Console.WriteLine();
            }

            outDots++;
            Console.Write(new string('.', outDots));
            Console.Write(new string('&', n / 2 + 1));
            Console.Write(new string('.', n));
            Console.Write(new string('&', n / 2 + 1));
            Console.Write(new string('.', outDots));
            Console.WriteLine();
        }
    }
}