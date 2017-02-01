using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03_Array_Manipulator
{
    class Program
    {
        public static List<int> sequence = new List<int>();
        static void Main(string[] args)
        {
            sequence = Console.ReadLine().Split().Select(int.Parse).ToList();

            string[] input = Console.ReadLine().Split().ToArray();
            while (input[0] != "print")
            {
                switch (input[0])
                {
                    case "add": AddNumber(input);
                        break;
                    case "addMany": AddManyNumbers(input);
                        break;
                    case "remove": RemoveNumbers(input);
                        break;
                    case "sumPairs": SumPairsOfTheArray(input);
                        break;
                    case "shift": ShiftNumbersOfTheArray(input);
                        break;
                    case "contains": IsArrayContainsNumber(input);
                        break;
                }
                
                input = Console.ReadLine().Split().ToArray();
            }
            Console.WriteLine("[{0}]", String.Join(", ", sequence));
        }

        public static void AddNumber(string[] input)
        {
            int index = int.Parse(input[1]);
            int number = int.Parse(input[2]);
            sequence.Insert(index, number);
        }

        public static void AddManyNumbers(string[] input)
        {
            int index = int.Parse(input[1]);
            List<int> temp = new List<int>();
            for (int i = 2; i < input.Length; i++)
            {
                temp.Add(int.Parse(input[i]));
            }
            sequence.InsertRange(index, temp);
        }

        private static void RemoveNumbers(string[] input)
        {
            sequence.RemoveAt(int.Parse(input[1]));
        }

        private static void SumPairsOfTheArray(string[] input)
        {
            List<int> temp = new List<int>();
            for (int i = 0; i < (sequence.Count % 2 == 0 ? sequence.Count - 1 : sequence.Count - 2); i += 2)
            {
                temp.Add(sequence[i] + sequence[i + 1]);
            }
            if (sequence.Count % 2 != 0)
            {
                temp.Add(sequence[sequence.Count - 1]);
            }
            sequence = temp.ToList();
        }

        private static void ShiftNumbersOfTheArray(string[] input)
        {
            int index = int.Parse(input[1]);
            for (int i = 0; i < index % sequence.Count; i++)
            {
                sequence.Add(sequence[0]);
                sequence.RemoveAt(0);
            }
        }

        private static void IsArrayContainsNumber(string[] input)
        {
            int checkedNumber = int.Parse(input[1]);
            for (int i = 0; i < sequence.Count; i++)
            {
                if (sequence[i] == checkedNumber)
                {
                    Console.WriteLine(i);
                    return;
                }
            }
            Console.WriteLine("-1");
        }
    }
}