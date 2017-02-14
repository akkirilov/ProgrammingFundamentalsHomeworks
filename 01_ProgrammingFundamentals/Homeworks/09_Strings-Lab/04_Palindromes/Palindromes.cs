using System;
using System.Collections.Generic;
using System.Linq;

namespace _04_Palindromes
{
    class Palindromes
    {
        static void Main()
        {
            string[] words = Console.ReadLine()
                .Trim()
                .Split(new char[] { ' ', ',', '!', '?', '.', '(', ')', '\"', '\'', '[', ']', '{', '}', '*', '%', '#', '@', '\\', '/', '|', '&', '$', '-', '_', ';', '+' }, StringSplitOptions.RemoveEmptyEntries)
                .ToArray();

            List<string> polindromes = new List<string>();

            for (int i = 0; i < words.Length; i++)
            {
                bool isPolindromes = true;

                for (int j = 0; j < words[i].Length / 2; j++)
                {
                    if (!(words[i].Trim()[j] == words[i].Trim()[words[i].Length - 1 - j]) || !char.IsLetter(words[i].Trim()[j]))
                    {
                        isPolindromes = false;
                    }
                }

                if (isPolindromes)
                {
                    polindromes.Add(words[i]);
                }
            }

            Console.WriteLine(String.Join(", ", polindromes.Distinct().OrderBy(x => x)));
        }
    }
}