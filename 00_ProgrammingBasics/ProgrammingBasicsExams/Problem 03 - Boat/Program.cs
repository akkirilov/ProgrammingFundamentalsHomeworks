using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_03___Boat
{
    class Program
    {
        static void Main(string[] args)
        {
            //8 min.
            int n = int.Parse(Console.ReadLine());

            int outDots = n - 1;
            int stars = 1;
            for (int i = 0; i < n; i++)
            {
                Console.Write(new string('.',outDots));
                Console.Write(new string('*', stars));
                Console.Write(new string('.', n));
                Console.WriteLine();
                if (i < n / 2 )
                {
                    outDots -= 2;
                    stars += 2;
                }
                else
                {
                    outDots += 2;
                    stars -= 2;
                }
            }

            stars = n * 2;
            outDots = 0;
            for (int i = 0; i < n/2; i++)
            {
                Console.Write(new string('.', outDots));
                Console.Write(new string('*', stars));
                Console.Write(new string('.', outDots));
                Console.WriteLine();
                outDots++;
                stars -= 2;
            }
        }
    }
}