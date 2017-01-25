using System;
using System.Numerics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _14_Factorial_Trailing_Zeroes
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            BigInteger factorial = 1;
            for (int i = 1; i <= n; i++)
            {
                factorial *= i;
            }

            string factorialDigits = factorial.ToString();
            int zerosLength = 1;
            int bestZerosLength = 1;
            if (!factorialDigits.Contains("0"))
            {
                Console.WriteLine(0);
            }
            for (int i = 1; i < factorialDigits.Length; i++)
            {
                if (factorialDigits[i - 1] == '0')
                {
                    if (factorialDigits[i] == '0')
                    {
                        zerosLength++;
                    }
                    else
                    {
                        zerosLength = 1;
                    }
                }
                if (zerosLength > bestZerosLength && (i == factorialDigits.Length - 1 || factorialDigits[i + 1] != '0'))
                {
                    bestZerosLength = zerosLength;
                    zerosLength = 1;
                }
            }

            Console.WriteLine(bestZerosLength);
        }
    }
}