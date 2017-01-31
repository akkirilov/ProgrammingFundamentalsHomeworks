using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_03___Magic_Wand
{
    class Program
    {
        static void Main(string[] args)
        {
            //30 min.
            int n = int.Parse(Console.ReadLine());
            int outDots = (3 * n + 1) / 2;
            int inDots = 1;

            Console.Write(new string('.', (3 * n + 1) / 2));
            Console.Write(new string('*', 1));
            Console.Write(new string('.', (3 * n + 1) / 2));
            Console.WriteLine();
            for (int i = 0; i < n/2+1; i++)
            {
                outDots--;
                Console.Write(new string('.', outDots));
                Console.Write(new string('*', 1));
                Console.Write(new string('.', inDots));
                Console.Write(new string('*', 1));
                Console.Write(new string('.', outDots));
                inDots+=2;
                Console.WriteLine();
            }
            Console.Write(new string('*', outDots));
            Console.Write(new string('.', inDots));
            Console.Write(new string('*', outDots));
            Console.WriteLine();

            outDots = 1;
            inDots = 3 * n - 2;
            for (int i = 0; i < n/2; i++)
            {
                Console.Write(new string('.', outDots));
                Console.Write(new string('*', 1));
                Console.Write(new string('.', inDots));
                Console.Write(new string('*', 1));
                Console.Write(new string('.', outDots));
                outDots++;
                inDots -= 2;
                Console.WriteLine();
            }
            outDots--;
            inDots = 0;
            for (int i = 0; i < n / 2; i++)
            {
                if (outDots<0)
                {
                    outDots = 0;
                }
                outDots--;
                Console.Write(new string('.', outDots));
                Console.Write(new string('*', 1));
                Console.Write(new string('.', n/2));
                Console.Write(new string('*', 1));
                Console.Write(new string('.', inDots));
                Console.Write(new string('*', 1));
                Console.Write(new string('.', n));
                Console.Write(new string('*', 1));
                Console.Write(new string('.', inDots));
                Console.Write(new string('*', 1));
                Console.Write(new string('.', n / 2));
                Console.Write(new string('*', 1));
                Console.Write(new string('.', outDots));
                inDots++;
                Console.WriteLine();
            }
            Console.Write(new string('*', 1));
            Console.Write(new string('*', n / 2-1));
            Console.Write(new string('*', 1));
            Console.Write(new string('.', inDots));
            Console.Write(new string('*', 1));
            Console.Write(new string('.', n));
            Console.Write(new string('*', 1));
            Console.Write(new string('.', inDots));
            Console.Write(new string('*', 1));
            Console.Write(new string('*', n / 2-1));
            Console.Write(new string('*', 1));
            Console.WriteLine();

            inDots = ((n * 3 + 2) - (n + 2)) / 2;
            for (int i = 0; i < n; i++)
            {
                Console.Write(new string('.', inDots));
                Console.Write(new string('*', 1));
                Console.Write(new string('.', n));
                Console.Write(new string('*', 1));
                Console.Write(new string('.', inDots));
                Console.WriteLine();
            }
            Console.Write(new string('.', inDots));
            Console.Write(new string('*', n+2));
            Console.Write(new string('.', inDots));
            Console.WriteLine();
        }
    }
}