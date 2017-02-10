using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _20161001_02_Command_Interpreter
{
    class CommandInterpreter
    {
        static void Main()
        {
            List<string> collection = Console.ReadLine()
                .Trim()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .ToList();

            string[] command = Console.ReadLine().Trim().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).ToArray();

            while (!command[0].Equals("end"))
            {
                switch (command[0])
                {
                    case "reverse":
                        ReverseOrSortPortionOfCollection(collection, command);
                        break;
                    case "sort":
                        ReverseOrSortPortionOfCollection(collection, command);
                        break;
                    case "rollLeft":
                        RollLeftCollection(collection, command);
                        break;
                    case "rollRight":
                        RollRightCollection(collection, command);
                        break;
                }

                command = Console.ReadLine().Trim().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).ToArray();
            }

            Console.WriteLine($"[{String.Join(", ", collection)}]");
        }

        private static void RollLeftCollection(List<string> collection, string[] command)
        {
            int count = int.Parse(command[1]);

            if (count < 0)
            {
                Console.WriteLine("Invalid input parameters.");
                return;
            }
            for (int i = 0; i < count % collection.Count; i++)
            {
                collection.Add(collection[0]);
                collection.RemoveAt(0);
            }
        }

        private static void RollRightCollection(List<string> collection, string[] command)
        {
            int count = int.Parse(command[1]);

            if (count < 0)
            {
                Console.WriteLine("Invalid input parameters.");
                return;
            }

            for (int i = 0; i < count % collection.Count; i++)
            {
                collection.Insert(0, collection[collection.Count - 1]);
                collection.RemoveAt(collection.Count - 1);
            }
        }

        private static void ReverseOrSortPortionOfCollection(List<string> collection, string[] command)
        {
            int startIndex = int.Parse(command[2]);
            int count = int.Parse(command[4]);

            if (startIndex + count > collection.Count || startIndex < 0 || count < 0 || startIndex >= collection.Count || count > collection.Count)
            {
                Console.WriteLine("Invalid input parameters.");
                return;
            }

            List<string> temp = new List<string>();

            for (int i = 0; i < count; i++)
            {
                temp.Add(collection[startIndex]);
                collection.RemoveAt(startIndex);
            }

            if (command[0].Equals("reverse"))
            {
                temp.Reverse();
            }
            else
            {
                temp.Sort();
            }

            collection.InsertRange(startIndex, temp);
        }
    }
}