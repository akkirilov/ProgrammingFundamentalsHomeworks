using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02_Rotate_and_Sum
{
    class Program
    {
        static void Main(string[] args)
        {
            long[] numbers1 = Console.ReadLine().Split().Select(long.Parse).ToArray();
            long[] numbers2 = new long[numbers1.Length];

            long[] sum = new long[numbers1.Length];

            int cicles = int.Parse(Console.ReadLine());

            while (cicles > 0)
            {
                numbers2[0] = numbers1[numbers1.Length - 1];
                sum[0] += numbers2[0];
                for (int i = 1; i < numbers1.Length; i++)
                {
                    numbers2[i] = numbers1[i - 1];
                    sum[i] += numbers2[i];
                }

                numbers1 = numbers2.ToArray();
                cicles--;
            }
            Console.WriteLine(String.Join(" ", sum));
        }
    }
}