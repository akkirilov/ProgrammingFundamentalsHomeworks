using System;

namespace _09_Melrah_Shake
{
    public class MelrahShake
    {
        public static void Main()
        {
            string input = Console.ReadLine();
            string pattern = Console.ReadLine();

            if (String.IsNullOrEmpty(pattern))
            {
                Console.WriteLine("No shake.");
                Console.WriteLine(input);
                return;
            }

            int shakeCount = 0;

            while (input.Contains(pattern))
            {
                int firstIndex = -1;
                int lastIndex = -1;
                shakeCount = 0;

                firstIndex = input.IndexOf(pattern);
                if (firstIndex != -1)
                {
                    input = input.Remove(firstIndex, pattern.Length);
                    shakeCount++;
                }

                lastIndex = input.LastIndexOf(pattern);
                if (lastIndex != -1)
                {
                    input = input.Remove(lastIndex, pattern.Length);
                    shakeCount++;
                }

                if (shakeCount == 2)
                {
                    Console.WriteLine("Shaked it.");
                }
                else
                {
                    Console.WriteLine("No shake.");
                }

                if (pattern.Length == 1)
                {
                    break;
                }
                else
                {
                    pattern = pattern.Remove(pattern.Length / 2, 1);
                }
            }

            if (shakeCount == 2)
            {
                Console.WriteLine("No shake.");
            }
            Console.WriteLine(input);
        }
    }
}