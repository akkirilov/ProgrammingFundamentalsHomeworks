using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07_04_Even_Powers_of_2
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int t = 1;

            for (int i = 0; i <= n; i+=2)
            {
                Console.WriteLine(t);
                t *= 4;
            }
        }
    }
}
