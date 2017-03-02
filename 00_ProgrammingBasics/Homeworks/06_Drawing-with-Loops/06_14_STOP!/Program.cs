using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06_14_STOP_
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int firstPart = n + 1;
            int firstDots = firstPart;
            int secondPart = n - 1;
            int secondDots = 1;
            int firstLastLine = (n * 2) + 1;
            int secondLine = firstLastLine - 4;
            int length = (firstPart * 2) + firstLastLine;

            Console.Write(new string('.',firstDots));
            Console.Write(new string('_', firstLastLine));
            Console.Write(new string('.', firstDots));
            Console.WriteLine();

            for (int i = 1; i < firstPart; i++)
            {
                firstDots -= 1;
                secondLine += 2;

                Console.Write(new string('.', firstDots));
                Console.Write(new string('/',2));
                Console.Write(new string('_', secondLine));
                Console.Write(new string('\\', 2));
                Console.Write(new string('.', firstDots));
                Console.WriteLine();
            }
            Console.Write(new string('/', 2));
            Console.Write(new string('_', length/2-4));
            Console.Write("STOP!");
            Console.Write(new string('_', length/2 - 4));
            Console.Write(new string('\\', 2));
            Console.WriteLine();

            Console.Write(new string('\\', 2));
            Console.Write(new string('_', length - 4));
            Console.Write(new string('/', 2));
            Console.WriteLine();

            for (int i = 1; i < secondPart; i++)
            {
                Console.Write(new string('.', secondDots));
                Console.Write(new string('\\', 2));
                Console.Write(new string('_', secondLine));
                Console.Write(new string('/', 2));
                Console.Write(new string('.', secondDots));
                Console.WriteLine();

                secondDots += 1;
                secondLine -= 2;
            }

            Console.Write(new string('.', secondDots));
            Console.Write(new string('\\', 2));
            Console.Write(new string('_', secondLine));
            Console.Write(new string('/', 2));
            Console.Write(new string('.', secondDots));
            Console.WriteLine();
        }
    }
}
