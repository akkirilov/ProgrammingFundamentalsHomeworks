using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_01__Training_Lab
{
    class Program
    {
        static void Main(string[] args)
        {
            //15 min.
            double h = double.Parse(Console.ReadLine());
            double w = double.Parse(Console.ReadLine()) - 1d;

            double hM = Math.Floor(h / 1.2d);
            double wM = Math.Floor(w / 0.7d);
            double m = hM * wM - 3;
            Console.WriteLine(m);
        }
    }
}