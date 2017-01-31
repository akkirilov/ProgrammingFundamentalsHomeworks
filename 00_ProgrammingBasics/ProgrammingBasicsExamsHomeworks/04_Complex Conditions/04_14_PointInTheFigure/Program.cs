using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04_14_PointInTheFigure
{
    class Program
    {
        static void Main(string[] args)
        {
            double h = double.Parse(Console.ReadLine());
            double x = double.Parse(Console.ReadLine());
            double y = double.Parse(Console.ReadLine());

            double x1 = 0;
            double y1 = 0;
            double x2 = 3 * h;
            double y2 = 1 * h;

            double xx1 = h;
            double yy1 = h;
            double xx2 = 2 * h;
            double yy2 = 4 * h;

            if (
                ((x > x1) && (x < x2) && (y > y1) && (y < y2))
                || ((x > xx1) && (x < xx2) && (y > yy1) && (y < yy2))
                || ((x > y2) && (x < xx2) && (y == y2)))
            {
                Console.WriteLine("inside");
            }

            else if (((x >= x1) && (x <= x2) && (y == y1))
                || ((y >= y1) && (y <= y2) && (x == x1))
                ||((x >= x1) && (x <= x2) && (y == y2))
                || ((y >= y1) && (y <= y2) && (x == x2))
                || ((x >= xx1) && (x <= xx2) && (y == yy1))
                || ((y >= yy1) && (y <= yy2) && (x == xx1))
                || ((x >= xx1) && (x <= xx2) && (y == yy2))
                || ((y >= yy1) && (y <= yy2) && (x == xx2)))
            {
                Console.WriteLine("border");
            }
            else
            {
                Console.WriteLine("outside");
            }
        }
    }
}
