using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_03___Plaid_Towel
{
    class Program
    {
        static void Main(string[] args)
        {
            //35 min.
            int n = int.Parse(Console.ReadLine());
            char backgroundSymbol = char.Parse(Console.ReadLine());
            char symbol = char.Parse(Console.ReadLine());

            int bOut = n;
            int bIn = 0;
            int bMid = n + (n - 1);
            Console.Write(new string(backgroundSymbol, bOut));
            Console.Write(new string(symbol, 1));
            Console.Write(new string(backgroundSymbol, bMid));
            Console.Write(new string(symbol, 1));
            Console.Write(new string(backgroundSymbol, bOut));
            Console.WriteLine();

            bOut = n - 1;
            bIn = 1; ;
            bMid = (n + (n - 1)) - 2;
            for (int i = 0; i < n; i++)
            {
                Console.Write(new string(backgroundSymbol, bOut));
                Console.Write(new string(symbol, 1));
                Console.Write(new string(backgroundSymbol, bIn));
                Console.Write(new string(symbol, 1));
                if (i != n - 1)
                {
                    Console.Write(new string(backgroundSymbol, bMid));
                    Console.Write(new string(symbol, 1));
                    Console.Write(new string(backgroundSymbol, bIn));
                }
                else
                {
                    Console.Write(new string(backgroundSymbol, bIn));
                }
                Console.Write(new string(symbol, 1));
                Console.Write(new string(backgroundSymbol, bOut));
                Console.WriteLine();

                bOut--;
                bIn += 2;
                bMid -= 2;
            }

            bOut++;
            bIn -= 2;
            bMid += 2;
            for (int i = 0; i < n; i++)
            {
                bOut++;
                bIn -= 2;
                bMid += 2;
                if (bIn <= 0)
                {
                    bIn = 0;
                }
                Console.Write(new string(backgroundSymbol, bOut));
                Console.Write(new string(symbol, 1));
                Console.Write(new string(backgroundSymbol, bIn));
                if (i != n - 1)
                {
                    Console.Write(new string(symbol, 1));
                    Console.Write(new string(backgroundSymbol, bMid));
                    Console.Write(new string(symbol, 1));
                    Console.Write(new string(backgroundSymbol, bIn));
                }
                else
                {
                    Console.Write(new string(backgroundSymbol, bMid));
                }
                Console.Write(new string(symbol, 1));
                Console.Write(new string(backgroundSymbol, bOut));
                Console.WriteLine();
            }

            bOut = n - 1;
            bIn = 1; ;
            bMid = (n + (n - 1)) - 2;
            for (int i = 0; i < n; i++)
            {
                Console.Write(new string(backgroundSymbol, bOut));
                Console.Write(new string(symbol, 1));
                Console.Write(new string(backgroundSymbol, bIn));
                Console.Write(new string(symbol, 1));
                if (i != n - 1)
                {
                    Console.Write(new string(backgroundSymbol, bMid));
                    Console.Write(new string(symbol, 1));
                    Console.Write(new string(backgroundSymbol, bIn));
                }
                else
                {
                    Console.Write(new string(backgroundSymbol, bIn));
                }
                Console.Write(new string(symbol, 1));
                Console.Write(new string(backgroundSymbol, bOut));
                Console.WriteLine();

                bOut--;
                bIn += 2;
                bMid -= 2;
            }

            bOut++;
            bIn -= 2;
            bMid += 2;
            for (int i = 0; i < n; i++)
            {
                bOut++;
                bIn -= 2;
                bMid += 2;
                if (bIn <= 0)
                {
                    bIn = 0;
                }
                Console.Write(new string(backgroundSymbol, bOut));
                Console.Write(new string(symbol, 1));
                Console.Write(new string(backgroundSymbol, bIn));
                if (i != n - 1)
                {
                    Console.Write(new string(symbol, 1));
                    Console.Write(new string(backgroundSymbol, bMid));
                    Console.Write(new string(symbol, 1));
                    Console.Write(new string(backgroundSymbol, bIn));
                }
                else
                {
                    Console.Write(new string(backgroundSymbol, bMid));
                }
                Console.Write(new string(symbol, 1));
                Console.Write(new string(backgroundSymbol, bOut));
                Console.WriteLine();
            }
        }
    }
}