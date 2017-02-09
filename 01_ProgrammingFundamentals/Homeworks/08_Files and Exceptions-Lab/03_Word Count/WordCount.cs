using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

namespace _03_Word_Count
{
    class WordCount
    {
        static void Main()
        {
            string[] textWords = File.ReadAllText("text.txt")
                .ToLower()
                .Split(new char[] { ' ', ',', '.', '!', '?', '&', '%', '#', '\r', '\n', '-', '_', '+' }, StringSplitOptions.RemoveEmptyEntries)
                .ToArray();

            string[] keyWords = File.ReadAllText("words.txt")
                .ToLower()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .ToArray();

            Dictionary<string, int> countWords = new Dictionary<string, int>();

            for (int i = 0; i < keyWords.Length; i++)
            {
                countWords[keyWords[i]] = 0;

                for (int j = 0; j < textWords.Length; j++)
                {
                    if (keyWords[i] == textWords[j])
                    {
                        countWords[keyWords[i]]++;
                    }
                }
            }

            File.WriteAllLines("result.txt", countWords.OrderByDescending(x => x.Value).Select(x => $"{x.Key} - {x.Value}"));
        }
    }
}