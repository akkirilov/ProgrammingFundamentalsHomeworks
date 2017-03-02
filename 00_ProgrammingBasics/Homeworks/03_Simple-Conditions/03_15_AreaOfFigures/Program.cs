using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03_15_AreaOfFigures
{
    class Program
    {
        static void Main(string[] args)
        {
            string type = Console.ReadLine();

            if (type == "square")
            {
                double side = double.Parse(Console.ReadLine());
                double area = side * side;
                Console.WriteLine("{0:0.000}", area);
            }
            else if (type == "rectangle")
            {
                double side = double.Parse(Console.ReadLine());
                double side0 = double.Parse(Console.ReadLine());
                double area = side * side0;
                Console.WriteLine("{0:0.000}", area);
            }
            else if (type == "circle")
            {
                double radius = double.Parse(Console.ReadLine());
                double area = Math.PI * radius * radius;
                Console.WriteLine("{0:0.000}", area);
            }
            else if (type == "triangle")
            {
                double side = double.Parse(Console.ReadLine());
                double height = double.Parse(Console.ReadLine());
                double area = side * (height / 2);
                Console.WriteLine("{0:0.000}", area);
            }
        }
    }
}
