using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _08_Most_Frequent_Number
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] array = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int count = 0;
            int bestCount = 0;
            int mosFrequentNumber = 0;

            for (int i = 0; i < array.Length; i++)
            {
                for (int j = 0; j < array.Length; j++)
                {
                    if (array[i] == array[j])
                    {
                        count++;
                    }
                }
                if (count > bestCount)
                {
                    bestCount = count;
                    mosFrequentNumber = array[i];
                }
                    count = 0;
            }
            Console.WriteLine(mosFrequentNumber);
        }
    }
}