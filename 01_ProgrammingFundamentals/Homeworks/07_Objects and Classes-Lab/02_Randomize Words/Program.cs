using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02_Randomize_Words
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] words = Console.ReadLine().Split().ToArray();

            Random random = new Random();

            for (int i = 0; i < words.Length; i++)
            {
                int randomIndex = random.Next(0, words.Length);
                SwapElements(words, i, randomIndex);
            }

            foreach (var word in words)
            {
                Console.WriteLine(word);
            }
        }

        private static void SwapElements(string[] text, int i, int randomIndex)
        {
            string tempWord = text[i];
            text[i] = text[randomIndex];
            text[randomIndex] = tempWord;
        }
    }
}