using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_04___Histogram
{
    class Program
    {
        static void Main(string[] args)
        {
            //10 min.
            int n = int.Parse(Console.ReadLine());
            double p1 = 0;
            double p2 = 0;
            double p3 = 0;
            double p4 = 0;
            double p5 = 0;

            for (int i = 0; i < n; i++)
            {
                int nn = int.Parse(Console.ReadLine());
                if (nn<200)
                {
                    p1 += 1;
                }
                else if (nn >= 200 && nn<400)
                {
                    p2 += 1;
                }
                else if (nn >= 400 && nn < 600)
                {
                    p3 += 1;
                }
                else if (nn >= 600 && nn < 800)
                {
                    p4 += 1;
                }
                else if (nn >= 800 && nn <= 1000)
                {
                    p5 += 1;
                }
            }
            p1 = p1 / n * 100;
            p2 = p2 / n * 100;
            p3 = p3 / n * 100;
            p4 = p4 / n * 100;
            p5 = p5 / n * 100;
            
            Console.WriteLine("{0:f2}%", p1);
            Console.WriteLine("{0:f2}%", p2);
            Console.WriteLine("{0:f2}%", p3);
            Console.WriteLine("{0:f2}%", p4);
            Console.WriteLine("{0:f2}%", p5);
        }
    }
}
