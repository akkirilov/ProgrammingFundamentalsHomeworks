using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace _06_Sum_Big_Numbers
{
    class SumBigNumbers
    {
        static void Main(string[] args)
        {
            List<char> firstNumber = Console.ReadLine().TrimStart('0').ToCharArray().ToList();
            List<char> secondNumber = Console.ReadLine().TrimStart('0').ToCharArray().ToList();
            int diff = Math.Max(firstNumber.Count, secondNumber.Count) - Math.Min(firstNumber.Count, secondNumber.Count);

            if (firstNumber.Count > secondNumber.Count)
            {
                InsertZeros(secondNumber, diff);
            }
            else if (firstNumber.Count < secondNumber.Count)
            {
                InsertZeros(firstNumber, diff);
            }

            StringBuilder result = new StringBuilder();
            int reminder = 0;
            for (int i = firstNumber.Count - 1; i >= 0; i--)
            {
                int a = (int)(firstNumber[i] - '0');
                int b = (int)(secondNumber[i] - '0');
                int tempResult = a + b + reminder;

                result.Insert(0, (tempResult % 10).ToString());
                reminder = tempResult / 10;
            }

            if (reminder != 0)
            {
                result.Insert(0, reminder.ToString());
            }

            Console.WriteLine(result.ToString());
        }

        private static void InsertZeros(List<char> chars, int diff)
        {
            for (int i = 0; i < diff; i++)
            {
                chars.Insert(0, '0');
            }
        }
    }
}