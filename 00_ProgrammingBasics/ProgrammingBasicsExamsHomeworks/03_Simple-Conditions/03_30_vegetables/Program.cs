using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03_30_vegetables
{
    class Program
    {
        static void Main(string[] args)
        {
            double n = double.Parse(Console.ReadLine());
            double m = double.Parse(Console.ReadLine());
            int nkg = int.Parse(Console.ReadLine());
            int mkg = int.Parse(Console.ReadLine());

            double eu = 1.94;

            Console.WriteLine(((n * nkg) + (m * mkg)) / eu);
        }
    }
}
