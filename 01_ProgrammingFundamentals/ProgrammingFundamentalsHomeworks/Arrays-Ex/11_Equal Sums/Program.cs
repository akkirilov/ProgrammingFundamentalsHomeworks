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

            for (int i = 0; i < array.Length; i++)
            {
                separator = i;

                if (SumPartOfArray(array, 0, separator) == SumPartOfArray(array, separator + 1, array.Length))
                {
                    Console.WriteLine(separator);
                    return;
                }
            }
            Console.WriteLine("no");
        }

        private static int SumPartOfArray(int[] array, int startIndex, int endIndex)
        {
            int sum = 0;
            for (int i = startIndex; i < endIndex; i++)
            {
                sum += array[i];
            }

            return sum;
        }
    }
}