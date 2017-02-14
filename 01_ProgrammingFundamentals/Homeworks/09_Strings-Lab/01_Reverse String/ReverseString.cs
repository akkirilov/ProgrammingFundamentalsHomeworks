using System;
using System.Linq;

namespace _01_Reverse_String
{
    class ReverseString
    {
        static void Main()
        {
            string input = Console.ReadLine();

            string result = GetReversedString(input);
            Console.WriteLine(result);
        }

        private static string GetReversedString(string input)
        {
            char[] temp = input.ToCharArray();
            return (String.Join("", temp.Reverse()));
        }
    }
}