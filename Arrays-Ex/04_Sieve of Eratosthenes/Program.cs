using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04_Sieve_of_Eratosthenes
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            bool[] isPrimes = new bool[n + 1];
            for (int i = 2; i < isPrimes.Length; i++)
            {
                isPrimes[i] = true;
            }

            for (int m = 2; m < isPrimes.Length; m++)
            {
                if (isPrimes[m] == true)
                {
                    for (int i = m; i < isPrimes.Length; i++)
                    {
                        if (i + m < isPrimes.Length)
                        {
                            isPrimes[i + m] = false;
                            i += m - 1;
                        }
                    }
                }
            }

            for (int i = 0; i < isPrimes.Length; i++)
            {
                if (isPrimes[i] == true)
                {
                    Console.Write(i + " ");
                }
            }
            Console.WriteLine();
        }
    }
}