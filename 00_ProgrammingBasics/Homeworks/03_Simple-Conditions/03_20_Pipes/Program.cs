using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03_20_Pipes
{
    class Program
    {
        static void Main(string[] args)
        {
            int v = int.Parse(Console.ReadLine());
            int p1 = int.Parse(Console.ReadLine());
            int p2 = int.Parse(Console.ReadLine());
            double H = double.Parse(Console.ReadLine());

            double debitP1 = p1 * H;
            double debitP2 = p2 * H;
            double debitAll = debitP1 + debitP2;
            double prinosP1 = 0.00;
            double prinosP2 = 0.00;
            
            prinosP1 = Math.Floor((debitP1 / debitAll) * 100);
            prinosP2 = Math.Floor(((debitP2 / debitAll) * 100));
            double full = Math.Floor((debitAll / v) * 100);

            double overLiters = debitAll - v;

            if (debitAll <= v)
            {
                Console.WriteLine("The pool is {0}% full. Pipe 1: {1}%. Pipe 2: {2}%.", full, prinosP1, prinosP2);
            }

            if (debitAll > v)
            {
                Console.WriteLine("For {0} hours the pool overflows with {1} liters.", H, overLiters);
            }
        }
    }
}
