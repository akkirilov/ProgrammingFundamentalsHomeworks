using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05_Short_Words_Sorted
{
    class Program
    {
        static void Main(string[] args)
        {
            char[] separators = new char[] { '.', ',', ':', ';', '(', ')', '[', ']', '"', '\'', '\\', '/', '!', '?', ' ' };

            List<string> text = Console.ReadLine()
                .ToLower()
                .Split(separators, StringSplitOptions.RemoveEmptyEntries)
                .Where(x => x.Length < 5)
                .ToList();

            List<string> words = new List<string>();

            for (int i = 0; i < text.Count; i++)
            {
                if (!words.Contains(text[i]))
                {
                    words.Add(text[i]);
                }
            }

            words = words.OrderBy(x => x).ToList();

            Console.WriteLine(String.Join(", ", words));
        }
    }
}