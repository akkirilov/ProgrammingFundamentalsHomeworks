using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _15_Fast_Prime_Checker___Refactor
{
    class Program
    {
        static void Main(string[] args)
        {
            int endNumber = int.Parse(Console.ReadLine());
            for (int numberToCheck = 2; numberToCheck <= endNumber; numberToCheck++)
            {
                bool isPrime = true;
                for (int divisor = 2; divisor <= Math.Sqrt(numberToCheck); divisor++)
                {
                    if (numberToCheck % divisor == 0)
                    {
                        isPrime = false;
                        break;
                    }
                }
                Console.WriteLine($"{numberToCheck} -> {isPrime}");
            }
        }
    }
}