using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03_Sum__Min__Max__Average
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            List<int> sequence = new List<int>();
            for (int i = 0; i < n; i++)
            {
                sequence.Add(int.Parse(Console.ReadLine()));
            }

            PrintSum(sequence);
            PrintMin(sequence);
            PrintMax(sequence);
            PrintAverage(sequence);
        }

        private static void PrintSum(List<int> sequence)
        {
            Console.WriteLine("Sum = {0}", sequence.Sum());
        }

        private static void PrintMin(List<int> sequence)
        {
            Console.WriteLine("Min = {0}", sequence.Min());
        }

        private static void PrintMax(List<int> sequence)
        {
            Console.WriteLine("Max = {0}", sequence.Max());
        }

        private static void PrintAverage(List<int> sequence)
        {
            Console.WriteLine("Average = {0}", sequence.Average());
        }
    }
}