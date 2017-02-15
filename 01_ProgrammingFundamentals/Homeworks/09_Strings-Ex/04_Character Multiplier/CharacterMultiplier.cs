using System;

namespace _04_Character_Multiplier
{
    public class CharacterMultiplier
    {
        public static void Main()
        {
            string[] strings = Console.ReadLine().Split();

            ulong result = 0;

            for (int i = 0; i < Math.Min(strings[0].Length, strings[1].Length); i++)
            {
                result += (ulong)(strings[0][i] * strings[1][i]);
            }

            if (strings[0].Length > strings[1].Length)
            {
                for (int i = strings[1].Length; i < strings[0].Length; i++)
                {
                    result += (ulong)strings[0][i];
                }
            }
            else if (strings[0].Length < strings[1].Length)
            {
                for (int i = strings[0].Length; i < strings[1].Length; i++)
                {
                    result += (ulong)strings[1][i];
                }
            }

            Console.WriteLine(result);
        }
    }
}