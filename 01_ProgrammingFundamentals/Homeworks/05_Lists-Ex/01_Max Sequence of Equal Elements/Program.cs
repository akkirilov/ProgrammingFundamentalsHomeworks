using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01_Max_Sequence_of_Equal_Elements
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> numbers = Console.ReadLine().Split().Select(int.Parse).ToList();

            List<int> seq = new List<int>();
            List<int> bestSeq = new List<int>();
            seq.Add(numbers[0]);

            for (int i = 1; i < numbers.Count; i++)
            {
                if (numbers[i] == numbers[i - 1])
                {
                    seq.Add(numbers[i]);
                }
                else
                {
                    if (seq.Count > bestSeq.Count)
                    {
                        bestSeq = seq.ToList();
                    }
                    seq.Clear();
                    seq.Add(numbers[i]);
                }
            }

            if (seq.Count > bestSeq.Count)
            {
                bestSeq = seq.ToList();
            }
            bestSeq.ForEach(x => Console.Write(x + " "));
            Console.WriteLine();
        }
    }
}