using System;
using System.Linq;

namespace _20161023_02_Ladybugs
{
    class Ladybugs
    {
        static void Main()
        {
            int size = int.Parse(Console.ReadLine());
            int[] indexes = Console.ReadLine()
                .Trim()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();

            int[] field = new int[size];
            for (int i = 0; i < indexes.Length; i++)
            {
                if (indexes[i] >= 0 && indexes[i] < field.Length)
                {
                    field[indexes[i]] = 1;
                }
            }

            string[] input = Console.ReadLine()
                .Trim()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .ToArray();
            while (!input[0].Equals("end"))
            {
                int bugIndex = int.Parse(input[0].Trim());
                string direction = input[1].Trim();
                int count = int.Parse(input[2].Trim());

                if (bugIndex < 0 || bugIndex >= field.Length || field[bugIndex] != 1)
                {
                    input = Console.ReadLine()
                        .Trim()
                        .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                        .ToArray();
                    continue;
                }

                if (direction == "right")
                {
                    GoToRight(field, bugIndex, count);
                }
                else if(direction == "left")
                {
                    GoToLeft(field, bugIndex, count);
                }

                input = Console.ReadLine()
                    .Trim()
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                    .ToArray();
            }

            Console.WriteLine(String.Join(" ", field));
        }

        private static void GoToLeft(int[] field, int bugIndex, int count)
        {
            if (count < 0)
            {
                GoToRight(field, bugIndex, Math.Abs(count));
                return;
            }
            else
            {
                field[bugIndex] = 0;
            }

            while (bugIndex - count >= 0 && bugIndex - count < field.Length)
            {
                if (field[bugIndex - count] == 1)
                {
                    bugIndex -= count;
                }
                else
                {
                    field[bugIndex - count] = 1;
                    return;
                }
            }
        }

        private static void GoToRight(int[] field, int bugIndex, int count)
        {
            if (count < 0)
            {
                GoToLeft(field, bugIndex, Math.Abs(count));
                return;
            }
            else
            {
                field[bugIndex] = 0;
            }

            while (bugIndex + count < field.Length && bugIndex + count >= 0)
            {
                if (field[bugIndex + count] == 1)
                {
                    bugIndex += count;
                }
                else
                {
                    field[bugIndex + count] = 1;
                    return;
                }
            }
        }
    }
}