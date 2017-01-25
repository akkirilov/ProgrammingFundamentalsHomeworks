using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _11_Geometry_Calculator
{
    class Program
    {
        static void Main(string[] args)
        {
            string figureType = Console.ReadLine();
            double area = 0;
            switch (figureType)
            {
                case "triangle":
                    area = GetTriangleArea();
                    break;
                case "square":
                    area = GetSquareArea();
                    break;
                case "circle":
                    area = GetCircleArea();
                    break;

            } //, square, rectangle and circle
            Console.WriteLine("{0:f2}", area);
        }

        private static double GetCircleArea()
        {
            double radius = double.Parse(Console.ReadLine());

            return (radius * radius);
        }

        private static double GetSquareArea()
        {
            double side = double.Parse(Console.ReadLine());

            return (side * side);
        }

        private static double GetTriangleArea()
        {
            double side = double.Parse(Console.ReadLine());
            double height = double.Parse(Console.ReadLine());

            return ((side * height) / 2); 
        }
    }
}