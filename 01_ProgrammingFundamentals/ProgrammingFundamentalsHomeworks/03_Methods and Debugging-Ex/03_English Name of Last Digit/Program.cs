using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03_English_Name_of_Last_Digit
{
    class Program
    {
        static void Main(string[] args)
        {
            long number = long.Parse(Console.ReadLine());

            long lastDigit = GetLastDigit(number);

            string digitName = GetDigitName(lastDigit);

            Console.WriteLine(digitName);
        }

        private static string GetDigitName(long lastDigit)
        {
            string digitName = "10";
            switch (lastDigit)
            {
                case 0:
                    digitName = "zero";
                    break;
                case 1:
                    digitName = "one";
                    break;
                case 2:
                    digitName = "two";
                    break;
                case 3:
                    digitName = "three";
                    break;
                case 4:
                    digitName = "four";
                    break;
                case 5:
                    digitName = "five";
                    break;
                case 6:
                    digitName = "six";
                    break;
                case 7:
                    digitName = "seven";
                    break;
                case 8:
                    digitName = "eight";
                    break;
                case 9:
                    digitName = "nine";
                    break;
            }
            return digitName;
        }

        private static long GetLastDigit(long number)
        {
            long lastDigit = (Math.Abs(number % 10));
            return lastDigit;
        }
    }
}