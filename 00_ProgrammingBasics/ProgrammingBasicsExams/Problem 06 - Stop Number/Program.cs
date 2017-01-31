using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_06___Stop_Number
{
    class Program
    {
        static void Main(string[] args)
        {
            //5 min.
            int n1 = int.Parse(Console.ReadLine());
            int n2 = int.Parse(Console.ReadLine());
            int s = int.Parse(Console.ReadLine());

            for (int i = n2; i >= n1; i--)
            {
                if (i%2 == 0 && i % 3 == 0)
                {
                    if (i == s)
                    {
                        return;
                    }
                    Console.Write(i + " ");
                }
            }
        }
    }
}