using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_03___Headphones
{
    class Program
    {
        static void Main(string[] args)
        {
            //8 min.
            int n = int.Parse(Console.ReadLine());
            int outLine = n / 2;
            int inLine = n;
            int hStars = 1;

            Console.Write(new string('-', outLine));
            Console.Write(new string('*', n+2));
            Console.Write(new string('-', outLine));
            Console.WriteLine();

            for (int i = 0; i < n; i++)
            {
                Console.Write(new string('-', outLine));
                Console.Write(new string('*', hStars));
                Console.Write(new string('-', n));
                Console.Write(new string('*', hStars));
                Console.Write(new string('-', outLine));
                Console.WriteLine();
            }

            for (int i = 0; i < n / 2; i++)
            {
                outLine--;
                hStars+=2;
                inLine-=2;
                Console.Write(new string('-', outLine));
                Console.Write(new string('*', hStars));
                Console.Write(new string('-', inLine));
                Console.Write(new string('*', hStars));
                Console.Write(new string('-', outLine));
                Console.WriteLine();
            }

            for (int i = 0; i < n / 2; i++)
            {
                outLine++;
                hStars -= 2;
                inLine += 2;
                Console.Write(new string('-', outLine));
                Console.Write(new string('*', hStars));
                Console.Write(new string('-', inLine));
                Console.Write(new string('*', hStars));
                Console.Write(new string('-', outLine));
                Console.WriteLine();
            }
        }
    }
}