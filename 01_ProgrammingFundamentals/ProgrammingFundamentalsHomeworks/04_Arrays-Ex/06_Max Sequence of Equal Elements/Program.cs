using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06_Max_Sequence_of_Equal_Elements
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] array = Console.ReadLine().Split().Select(int.Parse).ToArray();
            List<int> sequence = new List<int>();

            sequence.Add(array[0]);
            List<int> maxSequence = sequence.ToList();

            for (int i = 1; i < array.Length; i++)
            {
                if (array[i] == array[i - 1])
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