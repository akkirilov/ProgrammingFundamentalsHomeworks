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

            for (int p = 2; p < isPrimes.Length; p++)
            {
                if (isPrimes[p] == true)
                {
                    for (int i = p; i < isPrimes.Length; i++)
                    {
                        if (i * p < isPrimes.Length)
                        {
                            isPrimes[i * p] = false;
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