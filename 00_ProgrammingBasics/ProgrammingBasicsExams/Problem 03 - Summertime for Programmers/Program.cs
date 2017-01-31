using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_03___Summertime_for_Programmers
{
    class Program
    {
        static void Main(string[] args)
        {
            //17 min.
            int n = int.Parse(Console.ReadLine());

            Console.Write(new string(' ', n / 2));
            Console.Write(new string('*', n + 1));
            Console.Write(new string(' ', n / 2));
            Console.WriteLine();

            for (int i = 0; i < n/2+1; i++)
            {
                Console.Write(new string(' ', n / 2));
                Console.Write(new string('*', 1));
                Console.Write(new string(' ', n - 1));
                Console.Write(new string('*', 1));
                Console.Write(new string(' ', n / 2));
                Console.WriteLine();
            }

            int dots = n / 2 - 1;
            int ins = n + 1;
            for (int i = 1; i < n-((n/2)+1); i++)
            {
                Console.Write(new string(' ', dots));
                Console.Write(new string('*', 1));
                Console.Write(new string(' ', ins));
                Console.Write(new string('*', 1));
                Console.Write(new string(' ', dots));
                dots--;
                ins += 2;
                Console.WriteLine();
            }

            for (int i = 0; i < n; i++)
            {
                Console.Write(new string('*', 1));
                Console.Write(new string('.', n * 2 - 2));
                Console.Write(new string('*', 1));
                Console.WriteLine();
            }

            for (int i = 0; i < n; i++)
            {
                Console.Write(new string('*', 1));
                Console.Write(new string('@', n * 2 - 2));
                Console.Write(new string('*', 1));
                Console.WriteLine();
            }

            Console.Write(new string('*', n * 2));
            Console.WriteLine();
        }
    }
}