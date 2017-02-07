using System;
using System.Collections.Generic;
using System.Linq;

namespace _05_Closest_Two_Points
{
    class ClosestTwoPoints
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            List<Point> points = new List<Point>();

            for (int i = 0; i < n; i++)
            {
                double[] coordinates = Console.ReadLine().Split().Select(double.Parse).ToArray();

                points.Add(new Point { X = coordinates[0], Y = coordinates[1] });
            }

            PrintClosestDistance(points);
        }

        private static void PrintClosestDistance(List<Point> points)
        {
            Point firstPoint = new Point();
            Point secondPoint = new Point();
            double distanceMin = double.MaxValue;

            for (int i = 0; i < points.Count - 1; i++)
            {
                for (int j = i + 1; j < points.Count; j++)
                {
                    double currentDistance = GetDistance(points[i], points[j]);

                    if (currentDistance < distanceMin)
                    {
                        distanceMin = currentDistance;
                        firstPoint = points[i];
                        secondPoint = points[j];
                    }
                }
            }

            Console.WriteLine($"{distanceMin:f2}");
            Console.WriteLine($"({firstPoint.X}, {firstPoint.Y})");
            Console.WriteLine($"({secondPoint.X}, {secondPoint.Y})");
        }

        private static double GetDistance(Point firstPoint, Point secondPoint)
        {
            return Math.Sqrt((Math.Pow((firstPoint.X - secondPoint.X), 2)) + (Math.Pow((firstPoint.Y - secondPoint.Y), 2)));
        }
    }
}