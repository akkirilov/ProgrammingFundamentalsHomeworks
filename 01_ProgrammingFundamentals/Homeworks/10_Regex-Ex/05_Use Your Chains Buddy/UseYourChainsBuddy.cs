using System;
using System.Collections.Generic;
using System.Text;
using System.Text.RegularExpressions;

namespace _05_Use_Your_Chains_Buddy
{
    public class UseYourChainsBuddy
    {
        public static void Main()
        {
            string encryptedText = Console.ReadLine();

            MatchCollection matchedSentence = new Regex(@"<p>(.+?)<\/p>").Matches(encryptedText);

            List<string> decryptedText = new List<string>();
            for (int i = 0; i < matchedSentence.Count; i++)
            {
                string tempSentence = new Regex(@"[^a-z0-9]+").Replace(matchedSentence[i].Groups[1].ToString(), " ");
                tempSentence = new Regex(@"\s+").Replace(tempSentence, " ");

                StringBuilder decryptedSentence = new StringBuilder();
                for (int j = 0; j < tempSentence.Length; j++)
                {
                    if (tempSentence[j] >= 'a' && tempSentence[j] <= 'm')
                    {
                        decryptedSentence.Append((char)(tempSentence[j] + 13));
                    }
                    else if (tempSentence[j] >= 'n' && tempSentence[j] <= 'z')
                    {
                        decryptedSentence.Append((char)(tempSentence[j] - 13));
                    }
                    else
                    {
                        decryptedSentence.Append(tempSentence[j]);
                    }
                }

                decryptedText.Add(decryptedSentence.ToString());
            }

            Console.WriteLine(String.Join("", decryptedText));
        }
    }
}