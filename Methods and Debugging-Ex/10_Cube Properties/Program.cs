using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _10_Cube_Properties
{
    class Program
    {
        static void Main(string[] args)
        {
            double side = double.Parse(Console.ReadLine());
            string operation = Console.ReadLine();

            double result = 0;

            switch (operation)
            {
                case "face":
                    result = PrintFace(side);
                    break;
                case "space":
                    result = PrintSpace(side);
                    break;
                case "volume":
                    result = PrintVolume(side);
                    break;
                case "area":
                    result = PrintArea(side);
                    break;
            }

            Console.WriteLine("{0:f2}", result);
        }

        private static double PrintArea(double side)
        {
            return (6 * Math.Pow(side, 2));
        }

        private static double PrintVolume(double side)
        {
            return Math.Pow(side, 3);
        }

        private static double PrintSpace(double side)
        {
            return Math.Sqrt(3 * Math.Pow(side, 2));
        }

        private static double PrintFace(double side)
        {
            return Math.Sqrt( 2 * Math.Pow(side, 2));
        }
    }
}