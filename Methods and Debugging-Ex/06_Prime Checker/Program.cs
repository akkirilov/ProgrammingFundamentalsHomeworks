using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06_Prime_Checker
{
    class Program
    {
        static void Main(string[] args)
        {
            long n = long.Parse(Console.ReadLine());

            bool isPrimeNumber = IsPrime(n);

            Console.WriteLine(isPrimeNumber);
        }

        private static bool IsPrime(long n)
        {
            if (n <= 1 || (n % 2 == 0 && n != 2))
            {
                return false;
            }
            else
            {
                for (int i = 3; i <= (int)Math.Sqrt(n); i++)
                {
                    if (n % i == 0)
                    {
                        return false;
                    }
                }
                return true;
            }
        }
    }
}