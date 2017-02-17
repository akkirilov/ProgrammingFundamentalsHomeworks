using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace _07_MultiplyBigNumber
{
    public class MultiplyBigNumber
    {
        public static void Main()
        {
            List<char> firstNumber = Console.ReadLine().TrimStart('0').ToCharArray().ToList();
            List<char> secondNumber = Console.ReadLine().TrimStart('0').ToCharArray().ToList();

            List<string> resultToSum = new List<string>();

            int zeros = 0;
            for (int s = secondNumber.Count - 1; s >= 0; s--)
            {
                int reminder = 0;
                StringBuilder temp = new StringBuilder();
                for (int f = firstNumber.Count - 1; f >= 0; f--)
                {
                    int tempResult = ((int)(firstNumber[f] - '0') * (int)(secondNumber[s] - '0')) + reminder;
                    temp.Insert(0, (tempResult % 10).ToString());
                    reminder = tempResult / 10;
                }
                if (reminder != 0)
                {
                    temp.Insert(0, reminder.ToString());
                }

                temp.Insert(temp.Length, new string('0', zeros));
                zeros++;
                resultToSum.Add(temp.ToString());
            }

            string result = "0";
            for (int i = 0; i < resultToSum.Count; i++)
            {
                result = SumBigNumbers(result, resultToSum[i]);
            }

            Console.WriteLine(result);
        }

        public static string SumBigNumbers(string first, string second)
        {
            List<char> firstNumber = first.TrimStart('0').ToCharArray().ToList();
            List<char> secondNumber = second.TrimStart('0').ToCharArray().ToList();
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

           return result.ToString();
        }

        public static void InsertZeros(List<char> chars, int diff)
        {
            for (int i = 0; i < diff; i++)
            {
                chars.Insert(0, '0');
            }
        }
    }
}