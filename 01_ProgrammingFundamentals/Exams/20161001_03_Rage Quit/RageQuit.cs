using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _20161001_03_Rage_Quit
{
    class RageQuit
    {
        static void Main()
        {
            string input = Console.ReadLine().ToUpper();

            string pattern = @"(.+?)(\d+)";
            MatchCollection allSusStrings = new Regex(pattern).Matches(input);

            StringBuilder text = new StringBuilder();
            foreach (Match subString in allSusStrings)
            {
                for (int i = 0; i < int.Parse(subString.Groups[2].ToString()); i++)
                {
                    text.Append(subString.Groups[1].ToString()); 
                }
            }

            List<char> justToCount = text.ToString().Distinct().ToList();

            Console.WriteLine($"Unique symbols used: {justToCount.Count}");
            Console.WriteLine(text.ToString());
        }
    }
}