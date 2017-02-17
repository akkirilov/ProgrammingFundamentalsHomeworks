using System;
using System.Text.RegularExpressions;

namespace _02_Extract_Sentences_By_Keyword
{
    public class ExtractSentencesByKeyword
    {
        public static void Main()
        {
            string key = Console.ReadLine();
            string pattern = @"(\w[^.!?]*?\b" + key + @"\b[^.!?]*)";

            MatchCollection sentences = new Regex(pattern).Matches(Console.ReadLine());
            for (int i = 0; i < sentences.Count; i++)
            {
                Console.WriteLine(sentences[i]);
            }
        }
    }
}