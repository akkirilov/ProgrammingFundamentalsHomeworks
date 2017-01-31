using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07_03_Powers_of_Two
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int t = 1;

            for (int i = t; i <= n; i++)
            //За Джъджа иска това:
            //for (int i = t; i <= n + 1; i++)
            {
                Console.WriteLine(t);
                t *= 2;
            }
        }
    }
}
