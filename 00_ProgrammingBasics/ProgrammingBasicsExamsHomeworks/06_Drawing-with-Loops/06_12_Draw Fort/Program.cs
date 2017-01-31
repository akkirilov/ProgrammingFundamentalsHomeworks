using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06_12_Draw_Fort
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int mid = n / 2;
            int midLine = (2 * n) - (mid * 2) - 4;
            int midHight = n - 2;
            int midLength = 2 * (n - 1);

            if (n <= 4)
            {
                Console.Write(new string ('/', 1));
                Console.Write(new string('^', mid));
                Console.Write(new string ('\\', 1));
                Console.Write(new string('/', 1));
                Console.Write(new string('^', mid));
                Console.Write(new string('\\', 1));
                Console.WriteLine();
            }

            if (n > 4)
            {
                Console.Write(new string('/', 1));
                Console.Write(new string('^', mid));
                Console.Write(new string('\\', 1));
                Console.Write(new string('_', midLine));
                Console.Write(new string('/', 1));
                Console.Write(new string('^', mid));
                Console.Write(new string('\\', 1));
                Console.WriteLine();
            }

            for (int i = 0; i < midHight; i++)
            {
                if (i < midHight - 1)
                {
                    Console.Write(new string ('|', 1));
                    Console.Write(new string (' ', midLength));
                    Console.Write(new string ('|', 1));
                    Console.WriteLine();
                }
                if ((i == midHight - 1) && (n > 4))
                {
                    Console.Write(new string('|', 1));
                    Console.Write(new string(' ', mid+1));
                    Console.Write(new string('_', midLine));
                    Console.Write(new string(' ', mid+1));
                    Console.Write(new string('|', 1));
                    Console.WriteLine();
                }
                if ((i == midHight - 1) && (n <= 4))
                {
                    Console.Write(new string('|', 1));
                    Console.Write(new string(' ', mid + 1));
                    Console.Write(new string(' ', mid + 1));
                    Console.Write(new string('|', 1));
                    Console.WriteLine();
                }
            }

            if (n <= 4)
            {
                Console.Write(new string('\\', 1));
                Console.Write(new string('_', mid));
                Console.Write(new string('/', 1));
                Console.Write(new string('\\', 1));
                Console.Write(new string('_', mid));
                Console.Write(new string('/', 1));
                Console.WriteLine();
            }

            if (n > 4)
            {
                Console.Write(new string('\\', 1));
                Console.Write(new string('_', mid));
                Console.Write(new string('/', 1));
                Console.Write(new string(' ', midLine));
                Console.Write(new string('\\', 1));
                Console.Write(new string('_', mid));
                Console.Write(new string('/', 1));
                Console.WriteLine();
            }
        }
    }
}
