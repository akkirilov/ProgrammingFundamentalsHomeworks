using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06_Fold_and_Sum
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> sequence = Console.ReadLine().Split().Select(int.Parse).ToList();

            int quarter = sequence.Count / 4;

            List<int> numbersToSum = sequence.Take(quarter).ToList();
            numbersToSum.Reverse();

            for (int j = sequence.Count - 1 ; j >= quarter * 3; j--)
            {
                numbersToSum.Add(sequence[j]);
            }

            sequence.RemoveRange(quarter * 3, quarter);
            sequence.RemoveRange(0, quarter);

            for (int i = 0; i < numbersToSum.Count; i++)
            {
                sequence[i] += numbersToSum[i];
            }
            
            Console.WriteLine(String.Join(" ", sequence));
        }
    }
}