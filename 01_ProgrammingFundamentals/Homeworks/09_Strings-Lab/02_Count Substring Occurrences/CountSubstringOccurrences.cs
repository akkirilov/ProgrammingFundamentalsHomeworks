using System;

namespace _02_Count_Substring_Occurrences
{
    class CountSubstringOccurrences
    {
        static void Main()
        {
            string input = Console.ReadLine().ToLower();
            string keyWord = Console.ReadLine().ToLower();

            int count = 0;
            int index = 0;
            int found = 0;

            while (true)
            {
                found = input.IndexOf(keyWord, index);
                if (found >= 0)
                {
                    count++;
                    index = found + 1; 
                }
                else
                {
                    break;
                }
            }

            Console.WriteLine(count);
        }
    }
}