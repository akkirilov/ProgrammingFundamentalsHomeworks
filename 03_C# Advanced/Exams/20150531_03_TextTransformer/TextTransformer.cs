using System;
using System.Text;
using System.Text.RegularExpressions;

namespace _20150531_03_TextTransformer
{
    public class TextTransformer
    {
        public static void Main()
        {
            StringBuilder text = new StringBuilder();

            string input = Console.ReadLine();
            while (!input.Equals("burp"))
            {
                text.Append(input);
                input = Console.ReadLine();
            }

            string textToString = new Regex(@"\s{2,}").Replace(text.ToString(), " ");
            MatchCollection matches = new Regex(@"([\$'&%])([^\$'&%]+?)\1").Matches(textToString);

            text.Clear();
            for (int i = 0; i < matches.Count; i++)
            {
                text.Append(GetCorrectString(matches[i]));
                text.Append(" ");
            }

            Console.WriteLine(text.ToString());
        }

        public static string GetCorrectString(Match match)
        {
            int weight = 1;
            switch (match.Groups[1].ToString()[0])
            {
                case '%':
                    weight = 2;
                    break;
                case '&':
                    weight = 3;
                    break;
                case '\'':
                    weight = 4;
                    break;
            }

            string uncorrected = match.Groups[2].ToString();
            StringBuilder corrected = new StringBuilder();

            for (int i = 0; i < uncorrected.Length; i++)
            {
                if (i % 2 == 0)
                {
                    corrected.Append((char)(uncorrected[i] + weight));
                }
                else
                {
                    corrected.Append((char)(uncorrected[i] - weight));
                }
            }

            return corrected.ToString();
        }
    }
}