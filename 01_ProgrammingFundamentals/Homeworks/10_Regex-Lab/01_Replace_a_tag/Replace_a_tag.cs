using System;
using System.Text.RegularExpressions;

namespace _01_Replace_a_tag
{
    public class Replace_a_Tag
    {
        public static void Main()
        {
            string pattern = @"(.*)<a\s*(.+.\w+.)>(.+)<\/a>(.*)";

            string input = Console.ReadLine();
            while (!input.Equals("end"))
            {
                Console.WriteLine(new Regex(pattern).Replace(input, @"$1[URL $2]$3[/URL]$4"));

                input = Console.ReadLine();
            }
        }
    }
}