using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_03___Ace_of_Diamonds
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int tire = (n / 2) - 1;
            int a = 1;

            Console.Write(new string('*', n));
            Console.WriteLine();

            for (int i = 0; i < n / 2; i++)
            {
                Console.Write(new string('*', 1));
                Console.Write(new string('-', tire));
                Console.Write(new string('@', a));
                Console.Write(new string('-', tire));
                Console.Write(new string('*', 1));
                a += 2;
                tire--;
                Console.WriteLine();
            }

            a -= 2;
            tire++;

            for (int i = 0; i < (n / 2) - 1; i++)
            {
                a -= 2;
                tire++;
                Console.Write(new string('*', 1));
                Console.Write(new string('-', tire));
                Console.Write(new string('@', a));
                Console.Write(new string('-', tire));
                Console.Write(new string('*', 1));

                Console.WriteLine();
            }

            Console.Write(new string('*', n));
            Console.WriteLine();
        }
    }
}
