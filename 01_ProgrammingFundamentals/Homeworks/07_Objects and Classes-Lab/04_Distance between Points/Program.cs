using System;
using System.Linq;

namespace _04_Distance_between_Points
{
    class Program
    {
        static void Main()
        {
            double[] input = Console.ReadLine().Split().Select(double.Parse).ToArray();
            Point firstPoint = new Point { X = input[0], Y = input[1] };

            input = Console.ReadLine().Split().Select(double.Parse).ToArray();
            Point secondPoint = new Point { X = input[0], Y = input[1] };

            Console.WriteLine("{0:f3}", GetDistanceBetweenPoints(firstPoint, secondPoint));
        }

        private static double GetDistanceBetweenPoints(Point firstPoint, Point secondPoint)
        {
            return Math.Sqrt((Math.Pow((firstPoint.X - secondPoint.X), 2)) + (Math.Pow((firstPoint.Y - secondPoint.Y), 2)));
        }
    }
}