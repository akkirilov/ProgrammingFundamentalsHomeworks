using System;
using System.Text.RegularExpressions;

namespace _08_Letters_Change_Numbers
{
    class LettersChangeNumbers
    {
        static void Main()
        {
            string input = Console.ReadLine();
            decimal result = 0;

            MatchCollection matches = new Regex(@"(\w)(\d+)(\w)").Matches(input);

            for (int i = 0; i < matches.Count; i++)
            {
                char firstChar = (matches[i].Groups[1]).ToString()[0];
                decimal number = decimal.Parse(matches[i].Groups[2].ToString());
                char secondChar = (matches[i].Groups[3]).ToString()[0];
                decimal tempResult = 0;

                if (char.IsUpper(firstChar))
                {
                    tempResult = number / (int)(firstChar - 'A' + 1);
                }
                else if (char.IsLower(firstChar))
                {
                    tempResult = number * (int)(firstChar - 'a' + 1);
                }

                if (char.IsUpper(secondChar))
                {
                    tempResult -= (int)(secondChar - 'A' + 1);
                }
                else if (char.IsLower(secondChar))
                {
                    tempResult += (int)(secondChar - 'a' + 1);
                }

                result += tempResult;
            }

            Console.WriteLine($"{result:f2}");
        }
    }
}