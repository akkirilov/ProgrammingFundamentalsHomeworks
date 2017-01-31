using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _18_Sequence_of_Commands___debugging
{
    class Program
    {
        private const char ArgumentsDelimiter = ' ';
        public static void Main()
        {
            int sizeOfArray = int.Parse(Console.ReadLine());

            long[] array = Console.ReadLine()
                .Split(ArgumentsDelimiter)
                .Select(long.Parse)
                .ToArray();

            string command = Console.ReadLine();

            while (command != "stop")
            {
                string[] commandEll = command.Split();
                int[] args = new int[2];

                if (commandEll[0] == "add" || commandEll[0] == "subtract" || commandEll[0] == "multiply")
                {
                    args[0] = int.Parse(commandEll[1]);
                    args[1] = int.Parse(commandEll[2]);

                    PerformAction(array, commandEll[0], args);
                }
                else if (commandEll[0] == "rshift")
                {
                    ArrayShiftRight(array);
                }
                else if (commandEll[0] == "lshift")
                {
                    ArrayShiftLeft(array);
                }

                PrintArray(array);

                command = Console.ReadLine();
            }
        }

        static void PerformAction(long[] array, string action, int[] args)
        {
            int pos = args[0] - 1;
            int value = args[1];

            switch (action)
            {
                case "multiply":
                    array[pos] *= value;
                    break;
                case "add":
                    array[pos] += value;
                    break;
                case "subtract":
                    array[pos] -= value;
                    break;
            }
        }

        private static void ArrayShiftRight(long[] array)
        {
            long temp = array[array.Length - 1];
            for (int i = array.Length - 1; i > 0; i--)
            {
                array[i] = array[i - 1];
            }
            array[0] = temp;
        }

        private static void ArrayShiftLeft(long[] array)
        {
            long temp = array[0];
            for (int i = 0; i < array.Length - 1; i++)
            {
                array[i] = array[i + 1];
            }
            array[array.Length - 1] = temp;
        }

        private static void PrintArray(long[] array)
        {
            for (int i = 0; i < array.Length; i++)
            {
                Console.Write(array[i] + " ");
            }
            Console.WriteLine();
        }
    }
}
