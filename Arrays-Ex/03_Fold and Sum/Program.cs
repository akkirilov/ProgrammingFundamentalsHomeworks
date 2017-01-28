using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03_Fold_and_Sum
{
    class Program
    {
        static void Main(string[] args)
        {
            long[] numbers = Console.ReadLine().Split().Select(long.Parse).ToArray();

            int quarter = numbers.Length / 4;
            long[] sum = new long[quarter * 2];

            int endIndex = numbers.Length - 1;
            int startSumStart = quarter * 2 - 1;
            int startSumEnd = 2 * quarter;

            for (int startIndex = 0; startIndex < quarter; startIndex++)
            {
                sum[quarter - startIndex - 1] = numbers[startSumStart] + numbers[startIndex];
                sum[quarter + startIndex] = numbers[startSumEnd] + numbers[endIndex];

                startSumStart--;
                startSumEnd++;
                endIndex--;
            }

            Console.WriteLine(String.Join(" ", sum));
        }
    }
}