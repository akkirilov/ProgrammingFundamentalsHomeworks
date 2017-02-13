using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

namespace _20161001_03_Rage_Quit
{
    class RageQuit
    {
        static void Main()
        {
            string input = Console.ReadLine().ToUpper();

            string pattern = @"(.+?)(\d+)";
            MatchCollection allSubStrings = new Regex(pattern).Matches(input);

            StringBuilder rageText = new StringBuilder();
            foreach (Match subString in allSubStrings)
            {
                for (int i = 0; i < int.Parse(subString.Groups[2].ToString()); i++)
                {
                    rageText.Append(subString.Groups[1].ToString()); 
                }
            }

            List<char> uniqueSymbols = rageText.ToString().Distinct().ToList();

            Console.WriteLine($"Unique symbols used: {uniqueSymbols.Count}");
            Console.WriteLine(rageText.ToString());
        }
    }
}