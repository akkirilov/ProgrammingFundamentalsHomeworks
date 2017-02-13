using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _20161002_02_Array_Manipulator
{
    class ArrayManipulator
    {
        static void Main()
        {
            int[] array = Console.ReadLine().Split().Select(int.Parse).ToArray();

            string[] input = Console.ReadLine().Split();
            while (!input[0].Equals("end"))
            {
                switch (input[0])
                {
                    case "exchange":
                        ExchangeElementsOfArray(array, int.Parse(input[1]));
                        break;
                    case "max":
                        int type = OddOrEven(input[1]);
                        GetMaxIndex(array, type);
                        break;
                    case "min":
                        type = OddOrEven(input[1]);
                        GetMinIndex(array, type);
                        break;
                    case "first":
                        type = OddOrEven(input[2]);
                        GetFirst(array, int.Parse(input[1]), type);
                        break;
                    case "last":
                        type = OddOrEven(input[2]);
                        GetLast(array, int.Parse(input[1]), type);
                        break;
                }

                input = Console.ReadLine().Split();
            }

            Console.WriteLine($"[{String.Join(", ", array)}]");
        }

        private static int OddOrEven(string type)
        {
            if (type.Equals("even"))
            {
               return 0;
            }
            return 1;
        }

        private static void GetLast(int[] array, int count, int type)
        {
            if (count > array.Length)
            {
                Console.WriteLine("Invalid count");
                return;
            }

            List<int> tempArray = new List<int>();
            int j = 0;
            for (int i = array.Length - 1; i >= 0 && j < count; i--)
            {
                if (array[i] % 2 == type)
                {
                    tempArray.Insert(0, array[i]);
                    j++;
                }
            }

            Console.WriteLine($"[{String.Join(", ", tempArray)}]");
        }

        private static void GetFirst(int[] array, int count, int type)
        {
            if (count > array.Length)
            {
                Console.WriteLine("Invalid count");
                return;
            }

            List<int> tempArray = new List<int>();
            int j = 0;
            for (int i = 0; i < array.Length && j < count; i++)
            {
                if (array[i] % 2 == type)
                {
                    tempArray.Add(array[i]);
                    j++;
                }
            }

            Console.WriteLine($"[{String.Join(", ", tempArray)}]");
        }

        private static void GetMinIndex(int[] array, int type)
        {
            int minIndex = -1;
            int minNumber = int.MaxValue;
            for (int i = 0; i < array.Length; i++)
            {
                if (array[i] % 2 == type)
                {
                    if (array[i] <= minNumber)
                    {
                        minNumber = array[i];
                        minIndex = i;
                    }
                }
            }

            if (minIndex == -1)
            {
                Console.WriteLine("No matches");
                return;
            }

            Console.WriteLine(minIndex);
        }

        private static void GetMaxIndex(int[] array, int type)
        {
            int maxIndex = -1;
            int maxNumber = int.MinValue;
            for (int i = 0; i < array.Length; i++)
            {
                if (array[i] % 2 == type)
                {
                    if (array[i] >= maxNumber)
                    {
                        maxNumber = array[i];
                        maxIndex = i;
                    }
                }
            }

            if (maxIndex == -1)
            {
                Console.WriteLine("No matches");
                return;
            }

            Console.WriteLine(maxIndex);
        }

        private static void ExchangeElementsOfArray(int[] array, int index)
        {
            if (index >= array.Length || index < 0)
            {
                Console.WriteLine("Invalid index");
                return;
            }
            
            int[] tempArray = new int[array.Length];
            int j = 0;
            for (int i = index + 1; i < array.Length; i++, j++)
            {
                tempArray[j] = array[i];
            }
            
            for (int i = 0; j < array.Length; i++, j++)
            {
                tempArray[j] = array[i];
            }

            for (int i = 0; i < array.Length; i++)
            {
                array[i] = tempArray[i];
            }
        }
    }
}