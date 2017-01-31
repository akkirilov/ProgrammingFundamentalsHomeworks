using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_03___Fallen_In_Love
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int dotsOut = n * 2;
            int dotsIn = 0;
            int leave = 0;

            for (int i = 0; i < n; i++)
            {
                Console.Write(new string('#',1));
                Console.Write(new string('~', leave));
                Console.Write(new string('#', 1));
                Console.Write(new string('.', dotsOut));
                Console.Write(new string('#', 1));
                Console.Write(new string('.', dotsIn));
                Console.Write(new string('#', 1));
                Console.Write(new string('.', dotsOut));
                Console.Write(new string('#', 1));
                Console.Write(new string('~', leave));
                Console.Write(new string('#', 1));

                leave++;
                dotsOut -= 2;
                dotsIn += 2;
                Console.WriteLine();
            }

            dotsOut = 1;
            dotsIn = n*2;
            leave = n;
            for (int i = 0; i < n; i++)
            {
                Console.Write(new string('.', dotsOut));
                Console.Write(new string('#', 1));
                Console.Write(new string('~', leave));
                Console.Write(new string('#', 1));
                Console.Write(new string('.', dotsIn));
                Console.Write(new string('#', 1));
                Console.Write(new string('~', leave));
                Console.Write(new string('#', 1));
                Console.Write(new string('.', dotsOut));
                
                leave--;
                dotsOut += 2;
                dotsIn -= 2;
                Console.WriteLine();
            }

            Console.Write(new string('.', ((4 * n + 6)-4)/2));
            Console.Write(new string('#', 4));
            Console.Write(new string('.', ((4 * n + 6) - 4) / 2));
            Console.WriteLine();

            for (int i = 1; i <= n; i++)
            {
                Console.Write(new string('.', ((4 * n + 6) - 2) / 2));
                Console.Write(new string('#', 2));
                Console.Write(new string('.', ((4 * n + 6) - 2) / 2));
                Console.WriteLine();
            }
        }
    }
}