using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_01____Currency_Check
{
    class Program
    {
        static void Main(string[] args)
        {
            //9 min.
            double rus = (double.Parse(Console.ReadLine()) / 100) * 3.5;
            double us = double.Parse(Console.ReadLine()) * 1.5;
            double eu = double.Parse(Console.ReadLine()) * 1.95;
            double bgS = double.Parse(Console.ReadLine()) / 2;
            double bg = double.Parse(Console.ReadLine());

            Console.WriteLine("{0:f2}", (Math.Min(Math.Min(Math.Min(rus, us), Math.Min(eu, bgS)), bg)));
        }
    }
}