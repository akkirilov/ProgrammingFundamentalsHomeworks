using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _12_Master_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            long n = long.Parse(Console.ReadLine());

            for (long i = 1; i < n; i++)
            {
                if (IsPolindrome(i) && IsDigitsSumEqualSeven(i) && IsHoldEvenDigit(i))
                {
                    Console.WriteLine(i);
                }
            } 
        }

        private static bool IsHoldEvenDigit(long number)
        {
            while (number > 0)
            {
                if(number % 2 == 0)
                {
                    return true;
                }
                number /= 10;
            }
            return false;
        }

        private static bool IsDigitsSumEqualSeven(long number)
        {
            int sum = 0;
            while (number > 0)
            {
                sum += (int)(number % 10);
                number /= 10;
            }

            if (sum % 7 == 0)
            {
                return true;
            }

            return false;
        }

        private static bool IsPolindrome(long number)
        {
            string toCheck = number.ToString();
            bool isPolindrome = true;

            int last = toCheck.Length - 1;
            for (int first = 0; first <= toCheck.Length / 2; first++, last--)
            {
                if (toCheck[first] != toCheck[last])
                {
                    isPolindrome = false;
                }
            }

            return isPolindrome;
        }
    }
}