using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02_Command_Interpreter
{
    public class CommandInterpreter
    {
        public static void Main()
        {
            List<string> sequence = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .ToList();

            string[] command = Console.ReadLine()
                .Split()
                .ToArray();

            while (!command[0].Equals("end"))
            {
                switch (command[0])
                {
                    case "reverse":
                        ReverseOrSortPartOfSequence(sequence, command);
                        break;
                    case "sort":
                        ReverseOrSortPartOfSequence(sequence, command);
                        break;
                    case "rollLeft":
                        RollLeftSequence(sequence, int.Parse(command[1]));
                        break;
                    case "rollRight":
                        RollRightSequence(sequence, int.Parse(command[1]));
                        break;
                }

                command = Console.ReadLine()
                    .Split()
                    .ToArray();
            }

            Console.WriteLine($"[{String.Join(", ", sequence)}]");
        }

        public static void RollLeftSequence(List<string> sequence, int count)
        {
            if (count < 0)
            {
                Console.WriteLine("Invalid input parameters.");
                return;
            }

            for (int i = 0; i < count % sequence.Count; i++)
            {
                sequence.Add(sequence[0]);
                sequence.RemoveAt(0);
            }
        }

        public static void RollRightSequence(List<string> sequence, int count)
        {
            if (count < 0)
            {
                Console.WriteLine("Invalid input parameters.");
                return;
            }

            for (int i = 0; i < count % sequence.Count; i++)
            {
                sequence.Insert(0, sequence[sequence.Count - 1]);
                sequence.RemoveAt(sequence.Count - 1);
            }
        }

        public static void ReverseOrSortPartOfSequence(List<string> sequence, string[] command)
        {
            int startIndex = int.Parse(command[2]);
            int count = int.Parse(command[4]);

            if (startIndex < 0 || startIndex >= sequence.Count || count < 0 || count > sequence.Count || startIndex + count > sequence.Count)
            {
                Console.WriteLine("Invalid input parameters.");
                return;
            }

            List<string> sequenceTemp = new List<string>();
            for (int i = startIndex; i < startIndex + count; i++)
            {
                sequenceTemp.Add(sequence[i]);
            }

            if (command[0].Equals("reverse"))
            {
                sequenceTemp.Reverse();
            }
            else if (command[0].Equals("sort"))
            {
                sequenceTemp = sequenceTemp.OrderBy(x => x).ToList();
            }

            sequence.RemoveRange(startIndex, count);
            sequence.InsertRange(startIndex, sequenceTemp);
        }
    }
}