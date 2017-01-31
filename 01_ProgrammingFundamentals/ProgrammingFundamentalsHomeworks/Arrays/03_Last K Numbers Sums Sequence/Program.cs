using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03_Last_K_Numbers_Sums_Sequence
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int sequence = int.Parse(Console.ReadLine());
            long[] arrayOfNumbers = new long[n];
            arrayOfNumbers[0] = 1;

            for (int i = 1; i < n; i++)
            {
                int seq = 0;
                if (sequence < i)
                {
                    seq = i - sequence;
                }
                for (int j = i; j >= seq; j--)
                {
                    arrayOfNumbers[i] += arrayOfNumbers[j];
                }
            }
            Console.WriteLine(String.Join(" ", arrayOfNumbers));
        }
    }
}