using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06_13_butterfly
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int symbols = n - 2;
            int hight = n - 2;

            for (int i = 1; i <= hight; i++)
            {
                if (i % 2 != 0)
                {
                    Console.Write(new string('*', symbols));
                    Console.Write(new string('\\', 1));
                    Console.Write(new string(' ', 1));
                    Console.Write(new string('/', 1));
                    Console.Write(new string('*', symbols));
                    Console.WriteLine();
                }
                if (i % 2 == 0)
                {
                    Console.Write(new string('-', symbols));
                    Console.Write(new string('\\', 1));
                    Console.Write(new string(' ', 1));
                    Console.Write(new string('/', 1));
                    Console.Write(new string('-', symbols));
                    Console.WriteLine();
                }
            }

            Console.Write(new string(' ', symbols + 1));
            Console.Write(new string('@', 1));
            Console.Write(new string(' ', symbols + 1));
            Console.WriteLine();

            for (int i = 1; i <= hight; i++)
            {
                if (i % 2 != 0)
                {
                    Console.Write(new string('*', symbols));
                    Console.Write(new string('/', 1));
                    Console.Write(new string(' ', 1));
                    Console.Write(new string('\\', 1));
                    Console.Write(new string('*', symbols));
                    Console.WriteLine();
                }
                if (i % 2 == 0)
                {
                    Console.Write(new string('-', symbols));
                    Console.Write(new string('/', 1));
                    Console.Write(new string(' ', 1));
                    Console.Write(new string('\\', 1));
                    Console.Write(new string('-', symbols));
                    Console.WriteLine();
                }
            }


        }
    }
}
