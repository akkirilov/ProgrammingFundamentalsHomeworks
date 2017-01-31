using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_03___King_of_Thieves
{
    class Program
    {
        static void Main(string[] args)
        {
            //6 min.
            int n = int.Parse(Console.ReadLine());
            char c = char.Parse(Console.ReadLine());

            int lineCount = n/2;
            int symbolCount = 1;
            for (int i = 0; i < n/2; i++)
            {
                Console.Write(new string('-',lineCount));
                Console.Write(new string(c, symbolCount));
                Console.Write(new string('-', lineCount));
                Console.WriteLine();
                symbolCount += 2;
                lineCount--;
            }

            Console.Write(new string(c, n));
            Console.WriteLine();

            symbolCount -= 2;
            lineCount++;
            for (int i = 0; i < n / 2; i++)
            {
                Console.Write(new string('-', lineCount));
                Console.Write(new string(c, symbolCount));
                Console.Write(new string('-', lineCount));
                Console.WriteLine();
                symbolCount -= 2;
                lineCount++;
            }
        }
    }
}