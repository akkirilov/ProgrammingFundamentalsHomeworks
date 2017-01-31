using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _20160612_01_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] numbers = Console.ReadLine().Split().Select(int.Parse).ToArray();
            double average = GetAverage(numbers);
            Array.Sort(numbers);
            int count = 1;
            for (int i = numbers.Length - 1; i >= 0; i--)
            {
                if (numbers[i] > average && count <= 5)
                {
                    Console.Write(numbers[i] + " ");
                    count++;
                }
            }

            if (count == 1)
            {
                Console.WriteLine("No");
            }
        }

        private static double GetAverage(int[] numbers)
        {
            double result = 0;
            for (int i = 0; i < numbers.Length; i++)
            {
                result += numbers[i];
            }
            return result / numbers.Length;
        }
    }
}