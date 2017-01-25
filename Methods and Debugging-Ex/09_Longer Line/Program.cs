using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _09_Longer_Line
{
    class Program
    {
        static void Main(string[] args)
        {
            double c1 = double.Parse(Console.ReadLine());
            double d1 = double.Parse(Console.ReadLine());
            double c2 = double.Parse(Console.ReadLine());
            double d2 = double.Parse(Console.ReadLine());

            double a1 = double.Parse(Console.ReadLine());
            double b1 = double.Parse(Console.ReadLine());
            double a2 = double.Parse(Console.ReadLine());
            double b2 = double.Parse(Console.ReadLine());

            double distanceAB = GetDistance(a1, b1, a2, b2);
            double distanceCD = GetDistance(c1, d1, c2, d2);

            if (distanceAB >= distanceCD)
            {
                PrintLongerLine(a1, b1, a2, b2);
            }
            else
            {
                PrintLongerLine(c1, d1, c2, d2);
            }
        }

        private static void PrintLongerLine(double x1, double y1, double x2, double y2)
        {
            double distanceXY1 = GetDistanceFromZero(x1, y1);
            double distanceXY2 = GetDistanceFromZero(x2, y2);

            if (distanceXY1 <= distanceXY2)
            {
                Console.WriteLine($"({x1}, {y1})({x2}, {y2})");
            }
            else
            {
                Console.WriteLine($"({x2}, {y2})({x1}, {y1})");
            }
        }

        private static double GetDistance(double x1, double y1, double x2, double y2)
        {
            return Math.Sqrt(Math.Pow((x2 - x1), 2) + Math.Pow((y2 - y1), 2));
        }

        private static double GetDistanceFromZero(double x, double y)
        {
            return Math.Sqrt(Math.Pow(x, 2) + Math.Pow(y, 2));
        }
    }
}