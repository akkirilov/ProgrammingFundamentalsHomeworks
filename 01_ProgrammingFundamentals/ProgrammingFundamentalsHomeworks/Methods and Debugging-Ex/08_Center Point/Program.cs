using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _08_Center_Point
{
    class Program
    {
        static void Main(string[] args)
        {
            double x1 = double.Parse(Console.ReadLine());
            double y1 = double.Parse(Console.ReadLine());
            double x2 = double.Parse(Console.ReadLine());
            double y2 = double.Parse(Console.ReadLine());

            double distanceXY1 = GetDistanceFromZero(x1, y1);
            double distanceXY2 = GetDistanceFromZero(x2, y2);

            if (distanceXY1 < distanceXY2)
            {
                Console.WriteLine($"({x1}, {y1})");
            }
            else
            {
                Console.WriteLine($"({x2}, {y2})");
            }
        }

        private static double GetDistanceFromZero(double x, double y)
        {
            return Math.Sqrt(Math.Pow(x, 2) + Math.Pow(y, 2));
        }
    }
}