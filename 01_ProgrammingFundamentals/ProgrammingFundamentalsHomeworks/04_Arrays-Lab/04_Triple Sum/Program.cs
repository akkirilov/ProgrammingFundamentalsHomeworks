using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04_Triple_Sum
{
    class Program
    {
        static void Main(string[] args)
        {
            long[] array = Console.ReadLine().Split().Select(long.Parse).ToArray();
            bool found = false;
            for (int i = 0; i < array.Length; i++)
            {
                long a = array[i];
                for (int j = i + 1; j < array.Length; j++)
                {
                    long b = array[j];
                    for (int k = 0; k < array.Length; k++)
                    {
                        long sum = array[k];
                        if (sum == a + b)
                        {
                            Console.WriteLine($"{a} + {b} == {sum}");
                            found = true;
                            break;
                        }
                    }
                }
            }

            if (!found)
            {
                Console.WriteLine("No");
            }
        }
    }
}