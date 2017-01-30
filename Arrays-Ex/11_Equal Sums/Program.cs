using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _11_Equal_Sums
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] array = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int separator;
            int sumLeft = 0;
            int sumRight = 0;

            for (int i = 0; i < array.Length; i++)
            {
                separator = i;

                for (int j = 0; j < separator; j++)
                {
                    sumLeft += array[j];
                }

                for (int j = separator + 1; j < array.Length; j++)
                {
                    sumRight+= array[j];
                }

                if (SumPartOfArray(array, 0, separator) == sumRight)
                {
                    Console.WriteLine(separator);
                    return;
                }

                sumLeft = 0;
                sumRight = 0;
            }
            Console.WriteLine("no");
        }

        private static int SumPartOfArray(int[] array, int startIndex, int endIndex)
        {
            for (int i = startIndex; i < endIndex; i++)
            {
                sumLeft += array[i];
            }
        }
    }
}