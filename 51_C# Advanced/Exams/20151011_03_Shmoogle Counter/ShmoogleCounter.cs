using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace _20151011_03_Shmoogle_Counter
{
    public class ShmoogleCounter
    {
        public static void Main()
        {
            List<string> doubles = new List<string>();
            List<string> ints = new List<string>();

            string input = Console.ReadLine();
            while (!input.Equals("//END_OF_CODE"))
            {
                string doublePattern = @"double ([a-z]\w*)";
                string intPattern = @"int ([a-z]\w*)";

                MatchCollection doublesMatches = new Regex(doublePattern).Matches(input);
                for (int i = 0; i < doublesMatches.Count; i++)
                {
                    doubles.Add(doublesMatches[i].Groups[1].ToString());
                }

                MatchCollection intsMatches = new Regex(intPattern).Matches(input);
                for (int i = 0; i < intsMatches.Count; i++)
                {
                    ints.Add(intsMatches[i].Groups[1].ToString());
                }

                input = Console.ReadLine();
            }

            if (doubles.Count == 0)
            {
                Console.WriteLine("Doubles: None");
            }
            else
            {
                Console.WriteLine($"Doubles: {String.Join(", ", doubles.OrderBy(x => x))}");
            }

            if (ints.Count == 0)
            {
                Console.WriteLine("Ints: None");
            }
            else
            {
                Console.WriteLine($"Ints: {String.Join(", ", ints.OrderBy(x => x))}");
            }
        }
    }
}