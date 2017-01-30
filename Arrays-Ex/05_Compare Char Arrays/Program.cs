using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05_Compare_Char_Arrays
{
    class Program
    {
        static void Main(string[] args)
        {
            char[] firstArray = Console.ReadLine().Split().Select(char.Parse).ToArray();
            char[] secondArray = Console.ReadLine().Split().Select(char.Parse).ToArray();

            for (int i = 0; i < Math.Min(firstArray.Length, secondArray.Length); i++)
            {
                if (firstArray[i] < secondArray[i])
                {
                    Console.WriteLine(String.Join(" ", firstArray));
                    Console.WriteLine(String.Join(" ", secondArray));
                    return;
                }
                else if (firstArray[i] > secondArray[i])
                {
                    Console.WriteLine(String.Join(" ", secondArray));
                    Console.WriteLine(String.Join(" ", firstArray));
                    return;
                }

                if (i == Math.Min(firstArray.Length, secondArray.Length) - 1)
                {
                    if (firstArray.Length < secondArray.Length)
                    {
                        Console.WriteLine(String.Join(" ", firstArray));
                        Console.WriteLine(String.Join(" ", secondArray));
                    }
                    else
                    {
                        Console.WriteLine(String.Join(" ", secondArray));
                        Console.WriteLine(String.Join(" ", firstArray));
                    }
                }
            }
        }
    }
}