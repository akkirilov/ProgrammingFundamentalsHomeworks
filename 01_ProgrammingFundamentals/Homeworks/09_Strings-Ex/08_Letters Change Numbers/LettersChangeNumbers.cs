using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
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
                decimal tempResult = 0;
                char firstLetter = (matches[i].Groups[1]).ToString()[0];
                Console.WriteLine("f: " + firstLetter);
                Console.WriteLine("n: " + matches[i].Groups[2].ToString());
                char secondLetter = (matches[i].Groups[3]).ToString()[0];
                Console.WriteLine("s: " + secondLetter);
                Console.WriteLine();


            }



        }
    }
}