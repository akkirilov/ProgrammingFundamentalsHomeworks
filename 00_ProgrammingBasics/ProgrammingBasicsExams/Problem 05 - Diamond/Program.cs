using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_05___Diamond
{
    class Program
    {
        static void Main(string[] args)
        {
            //9 min.
            int n = int.Parse(Console.ReadLine());

            int dots = n;
            int insideDots = 3 * n;
            Console.Write(new string('.',dots));
            Console.Write(new string('*', insideDots));
            Console.Write(new string('.', dots));
            Console.WriteLine();
            for (int i = 0; i < n-1; i++)
            {
                dots--;
                Console.Write(new string('.', dots));
                Console.Write(new string('*', 1));
                Console.Write(new string('.', insideDots));
                Console.Write(new string('*', 1));
                Console.Write(new string('.', dots));
                insideDots += 2;
                Console.WriteLine();
            }
            Console.Write(new string('*', 5*n));
            Console.WriteLine();
            for (int i = 0; i < n*2; i++)
            {
                insideDots -= 2;
                Console.Write(new string('.', dots));
                Console.Write(new string('*', 1));
                Console.Write(new string('.', insideDots));
                Console.Write(new string('*', 1));
                Console.Write(new string('.', dots));
                dots++;
                Console.WriteLine();
            }
            Console.Write(new string('.', 2*n+1));
            Console.Write(new string('*', n-2));
            Console.Write(new string('.', 2*n+1));
            Console.WriteLine();
        }
    }
}