using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_03___Christmas_Tree
{
    class Program
    {
        static void Main(string[] args)
        {
            //00:15
            int n = int.Parse(Console.ReadLine());
            int dots = n;
            int arows = 1;

            for (int i = 0; i <= n / 2; i++)
            {
                Console.Write(new string('\'', dots));
                Console.Write(new string('^', arows));
                Console.Write(new string('\'', dots));
                Console.WriteLine();
                dots--;
                arows += 2;
            }

            dots = n - 1;
            arows = 3;
            for (int i = 0; i <= n / 2; i++)
            {
                Console.Write(new string('\'', dots));
                Console.Write(new string('^', arows));
                Console.Write(new string('\'', dots));
                Console.WriteLine();
                dots--;
                arows += 2;
            }

            dots = n - 1;
            for (int i = 0; i <= n / 2; i++)
            {
                Console.Write(new string('\'', dots));
                Console.Write(new string('|', 1));
                Console.Write(new string(' ', 1));
                Console.Write(new string('|', 1));
                Console.Write(new string('\'', dots));
                Console.WriteLine();
            }
            Console.WriteLine(new string('-', n * 2 + 1));
        }
    }
}