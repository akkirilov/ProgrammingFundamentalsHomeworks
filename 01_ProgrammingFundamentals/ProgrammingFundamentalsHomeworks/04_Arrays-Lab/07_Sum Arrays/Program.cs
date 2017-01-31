using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07_Sum_Arrays
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr1 = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int[] arr2 = Console.ReadLine().Split().Select(int.Parse).ToArray();

            int[] result = new int[Math.Max(arr1.Length, arr2.Length)];
            
            for (int i = 0; i < result.Length; i++)
            {
                int a = arr1[i % arr1.Length];
                int b = arr2[i % arr2.Length];
                result[i] = a + b;
            }
            Console.WriteLine(String.Join(" ", result));
        }
    }
}