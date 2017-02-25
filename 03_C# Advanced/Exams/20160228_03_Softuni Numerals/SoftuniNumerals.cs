using System;
using System.Numerics;

namespace _20160228_03_Softuni_Numerals
{
    public class SoftuniNumerals
    {
        public static void Main()
        {
            string softUniNumber = ToFiveSystem(Console.ReadLine());
            Console.WriteLine(ToDecimalSystem(softUniNumber));
        }

        public static BigInteger ToDecimalSystem(string softUniNumber)
        {
            BigInteger result = 0;
            int pow = 0;
            for (int i = softUniNumber.Length - 1; i >= 0; i--)
            {
                BigInteger digit = softUniNumber[i] - '0';
                result += digit * BigInteger.Pow(5, pow);
                pow++;
            }

            return result;
        }

        public static string ToFiveSystem(string input)
        {
            string result = "";
            string[] softUniNumbers = new string[] 
            {
                "aa",
                "aba",
                "bcc",
                "cc",
                "cdc"
            };

            while(input.Length > 0)
            {
                for (int i = 0; i < softUniNumbers.Length; i++)
                {
                    if (input.StartsWith(softUniNumbers[i]))
                    {
                        result += i;
                        input = input.Substring(softUniNumbers[i].Length);
                    }
                }
            }

            return result;
        }
    }
}