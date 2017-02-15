using System;

namespace _03_Unicode_Characters
{
    public class UnicodeCharacters
    {
        public static void Main()
        {
            char[] textToChar = Console.ReadLine().ToCharArray();

            for (int i = 0; i < textToChar.Length; i++)
            {
                Console.Write("\\u{0:x4}",(int)textToChar[i]);
            }
            Console.WriteLine();
        }
    }
}