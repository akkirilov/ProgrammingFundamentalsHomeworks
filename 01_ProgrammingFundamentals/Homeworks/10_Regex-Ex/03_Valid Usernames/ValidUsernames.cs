using System;
using System.Text.RegularExpressions;

namespace _03_Valid_Usernames
{
    public class ValidUsernames
    {
        public static void Main()
        {
            MatchCollection validUserNames = new Regex(@"\b[A-Za-z]\w{2,24}\b").Matches(Console.ReadLine());

            int maxSum = 0;
            string first = "";
            string second = "";

            for (int i = 1; i < validUserNames.Count; i++)
            {
                if (validUserNames[i - 1].Length + validUserNames[i].Length > maxSum)
                {
                    maxSum = validUserNames[i - 1].Length + validUserNames[i].Length;
                    first = validUserNames[i - 1].ToString();
                    second = validUserNames[i].ToString();
                }
            }

            Console.WriteLine(first);
            Console.WriteLine(second);
        }
    }
}