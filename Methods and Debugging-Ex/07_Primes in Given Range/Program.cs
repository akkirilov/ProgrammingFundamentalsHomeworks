using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07_Primes_in_Given_Range
{
    class Program
    {
        private static long i;

        static void Main(string[] args)
        {
            long startNumber = long.Parse(Console.ReadLine());
            long endNumber = long.Parse(Console.ReadLine());
            List<long> primeNumbers = PrimeNumbersRange(startNumber, endNumber);
            Console.WriteLine(String.Join(", ", primeNumbers));
        }

        private static List<long> PrimeNumbersRange(long startNumber, long endNumber)
        {
            if (startNumber <= 1)
            {
                startNumber = 2;
            }

            List<long> primeNumbers = new List<long>();
            for (long number = startNumber; number <= endNumber; number++)
            {
                bool isPrime = true;
                if (number % 2 == 0 && number != 2)
                {
                    continue;
                }
                for (long divisor = 3; divisor <= Math.Sqrt(number); divisor++)
                {
                    if (number % divisor == 0)
                    {
                        isPrime = false;
                    }
                }
                if (isPrime)
                {
                    primeNumbers.Add(number);
                }
            }

            return primeNumbers;
        }
    }
}