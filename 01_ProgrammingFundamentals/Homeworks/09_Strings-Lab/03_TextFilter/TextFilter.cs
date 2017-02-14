using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03_TextFilter
{
    class TextFilter
    {
        static void Main()
        {
            string[] banWords = Console.ReadLine()
                .Split(new char[] { ' ', ',' }, StringSplitOptions.RemoveEmptyEntries)
                .ToArray();

            string text = Console.ReadLine();

            foreach (var banWord in banWords)
            {
                text = text.Replace(banWord, new string('*', banWord.Length));
            }

            Console.WriteLine(text);
        }
    }
}