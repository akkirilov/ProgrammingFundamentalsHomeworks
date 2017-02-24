using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

namespace _03_Rage_Quit
{
    public class RageQuit
    {
        public static void Main()
        {
            string input = Console.ReadLine();

            MatchCollection matches = new Regex(@"([^\d]+)(\d+)").Matches(input);
            StringBuilder rageText = new StringBuilder();

            for (int m = 0; m < matches.Count; m++)
            {
                for (int i = 0; i < int.Parse(matches[m].Groups[2].ToString()); i++)
                {
                    rageText.Append(matches[m].Groups[1].ToString().ToUpper());
                }
            }

            List<char> uniqueChars = rageText.ToString().ToCharArray().Distinct().ToList();
            Console.WriteLine($"Unique symbols used: {uniqueChars.Count}");

            Console.WriteLine(rageText.ToString());
        }
    }
}