using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07_05_Sequence_2k_1
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int num = 1;

            for (int i = 0; i <= n+1; i++)
            {
                Console.WriteLine(num);
                num = num * 2 + 1;
                i = num;
            }
        }
    }
}
