using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07_Max_Sequence_of_Increasing_Elements
{
    class Program
    {
        static void Main(string[] args)
        {
            long[] array = Console.ReadLine().Split().Select(long.Parse).ToArray();
            List<long> sequence = new List<long>();
            sequence.Add(array[0]);
            List<long> maxSequence = sequence.ToList();

            for (int i = 1; i < array.Length; i++)
            {
                if (array[i] - array[i - 1] >= 1)
                {
                    sequence.Add(array[i]);
                }
                else
                {
                    if (sequence.Count > maxSequence.Count)
                    {
                        maxSequence = sequence.ToList();
                    }
                    sequence.Clear();
                    sequence.Add(array[i]);
                }
            }

            if (sequence.Count > maxSequence.Count)
            {
                maxSequence = sequence.ToList();
            }

            Console.WriteLine(String.Join(" ", maxSequence));
        }
    }
}