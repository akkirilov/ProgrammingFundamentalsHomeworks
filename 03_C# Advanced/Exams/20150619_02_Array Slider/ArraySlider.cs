using System;
using System.Linq;
using System.Numerics;

namespace _20150619_02_Array_Slider
{
    public class ArraySlider
    {
        public static void Main()
        {
            BigInteger[] array = Console.ReadLine()
                .Split(new char[] { ' ', '\t' },StringSplitOptions.RemoveEmptyEntries)
                .Select(BigInteger.Parse)
                .ToArray();

            int currentIndex = 0;

            string[] input = Console.ReadLine()
                .Split()
                .Select(x => x.Trim())
                .ToArray();
            while (!input[0].Equals("stop"))
            {
                int offset = int.Parse(input[0]);
                char action = char.Parse(input[1]);
                int number = int.Parse(input[2]);

                if (offset >= 0)
                {
                    currentIndex = (currentIndex + offset) % array.Length; 
                }
                else
                {
                    offset %= array.Length;
                    currentIndex += offset;
                    if (currentIndex < 0)
                    {
                        currentIndex = array.Length + currentIndex;
                    }
                }

                switch (action)
                {
                    case '&':
                        array[currentIndex] &= number;
                        break;
                    case '^':
                        array[currentIndex] ^= number;
                        break;
                    case '|':
                        array[currentIndex] |= number;
                        break;
                    case '+':
                        array[currentIndex] += number;
                        break;
                    case '-':
                        array[currentIndex] -= number;
                        break;
                    case '*':
                        array[currentIndex] *= number;
                        break;
                    case '/':
                        array[currentIndex] /= number;
                        break;
                }

                if (array[currentIndex] < 0)
                {
                    array[currentIndex] = 0;
                }

                input = Console.ReadLine()
                    .Split()
                    .Select(x => x.Trim())
                    .ToArray();
            }

            Console.WriteLine($"[{String.Join(", ", array)}]");
        }
    }
}