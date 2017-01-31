using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_04___Division
{
    class Program
    {
        static void Main(string[] args)
        {
            //6 min.
            int n = int.Parse(Console.ReadLine());
            double p2 = 0d;
            double p3 = 0d;
            double p4 = 0d;

            for (int i = 0; i < n; i++)
            {
                int nn = int.Parse(Console.ReadLine());
                if (nn % 2 == 0)
                {
                    p2++;
                }
                if (nn % 3 == 0)
                {
                    p3++;
                }
                if (nn % 4 == 0)
                {
                    p4++;
                }
            }
            Console.WriteLine("{0:f2}%", ((p2 / n) * 100));
            Console.WriteLine("{0:f2}%", ((p3 / n) * 100));
            Console.WriteLine("{0:f2}%", ((p4 / n) * 100));
        }
    }
}
