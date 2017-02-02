using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02_Longest_Increasing_Subsequence
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] numbers = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int length = numbers.Length;
            int[] len = new int[length];
            int[] prev = new int[length];
            int maxLen = int.MinValue;
            int maxIndex = 0;
            List<int> seq = new List<int>();

            for (int i = 0; i < length; i++)
            {
                prev[i] = -1;
                len[i] = 1;
                for (int j = 0; j < i; j++)
                {
                    if (numbers[j] < numbers[i] && len[j] + 1 > len[i])
                    {
                        len[i] = len[j] + 1;
                        prev[i] = j;
                    }
                }
                if (len[i] > maxLen)
                {
                    maxLen = len[i];
                    maxIndex = i;
                }
            }
            while (maxIndex != -1)
            {
                seq.Add(numbers[maxIndex]);
                maxIndex = prev[maxIndex];
            }
            seq.Reverse();    

            Console.WriteLine(String.Join(" ", seq));
        }
    }
}