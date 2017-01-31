using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_05___Stop
{
    class Program
    {
        static void Main(string[] args)
        {
            //15 min.
            int n = int.Parse(Console.ReadLine());

            Console.Write(new string('.', n+1));
            Console.Write(new string('_', n*2 + 1));
            Console.Write(new string('.', n + 1));
            Console.WriteLine();

            int dots = n;
            int cherta = n * 2 - 1;

            for (int i = 0; i < n; i++)
            {
                Console.Write(new string('.', dots));
                Console.Write(new string('/', 2));
                Console.Write(new string('_', cherta));
                Console.Write(new string('\\', 2));
                Console.Write(new string('.', dots));
                Console.WriteLine();
                dots--;
                cherta += 2;
            }
            Console.Write(new string('/', 2));
            Console.Write(new string('_', (cherta-5)/2));
            Console.Write("STOP!");
            Console.Write(new string('_', (cherta - 5) / 2));
            Console.Write(new string('\\', 2));
            Console.WriteLine();
            for (int i = 0; i < n; i++)
            {
                Console.Write(new string('.', dots));
                Console.Write(new string('\\', 2));
                Console.Write(new string('_', cherta));
                Console.Write(new string('/', 2));
                Console.Write(new string('.', dots));
                Console.WriteLine();
                dots++;
                cherta -= 2;
            }
        }
    }
}