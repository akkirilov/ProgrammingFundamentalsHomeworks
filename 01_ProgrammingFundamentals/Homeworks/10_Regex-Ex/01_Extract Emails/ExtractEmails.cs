using System;
using System.Text.RegularExpressions;

namespace _01_Extract_Emails
{
    public class ExtractEmails
    {
        public static void Main()
        {
            string pattern = @"((?<=\s)[a-zA-Z0-9]+([-.]\w*)*@[a-zA-Z]+?([.-][a-zA-Z]*)*(\.[a-z]{2,}))";

            MatchCollection emails = new Regex(pattern).Matches(Console.ReadLine());
            for (int i = 0; i < emails.Count; i++)
            {
                Console.WriteLine(emails[i]);
            }
        }
    }
}