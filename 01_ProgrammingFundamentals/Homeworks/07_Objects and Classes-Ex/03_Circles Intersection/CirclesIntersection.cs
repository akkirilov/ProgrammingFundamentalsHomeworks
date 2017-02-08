using System;
using System.Linq;

namespace _03_Circles_Intersection
{
    class CirclesIntersection
    {
        static void Main()
        {
            double[] input = Console.ReadLine().Split().Select(double.Parse).ToArray();
            Circle firsCircle = new Circle { X = input[0], Y = input[1], Radius = input[2]};

            input = Console.ReadLine().Split().Select(double.Parse).ToArray();
            Circle secondCircle = new Circle { X = input[0], Y = input[1], Radius = input[2] };

            double distanceBetweenCenters = GetDistance(firsCircle, secondCircle);

            if (distanceBetweenCenters <= (firsCircle.Radius + secondCircle.Radius))
            {
                Console.WriteLine("Yes");
                return;
            }
            Console.WriteLine("No");
        }

        private static double GetDistance(Circle firsCircle, Circle secondCircle)
        {
            return Math.Sqrt(((Math.Pow((firsCircle.X - secondCircle.X), 2)) + (Math.Pow((firsCircle.Y - secondCircle.Y), 2))));
        }
    }
}