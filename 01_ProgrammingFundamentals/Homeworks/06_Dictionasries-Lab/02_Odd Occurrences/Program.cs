using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02_Odd_Occurrences
{
    class Program
    {
        static void Main(string[] args)
        {
            List<string> wordsText = Console.ReadLine().ToLower().Split().ToList();

            Dictionary<string, int> wordsCount = new Dictionary<string, int>();
            for (int i = 0; i < wordsText.Count; i++)
            {
                if (wordsCount.ContainsKey(wordsText[i]))
                {
                    wordsCount[wordsText[i]]++;
                    continue;
                }

                wordsCount[wordsText[i]] = 1;
            }

            wordsText.Clear();
            foreach (var word in wordsCount)
            {
                if (word.Value % 2 != 0)
                {
                    wordsText.Add(word.Key);
                }
            }

            Console.WriteLine(String.Join(", ", wordsText));
        }
    }
}