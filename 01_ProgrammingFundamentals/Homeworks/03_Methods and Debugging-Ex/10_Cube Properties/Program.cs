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
                    result = CountFace(side);
                    break;
                case "space":
                    result = CountSpace(side);
                    break;
                case "volume":
                    result = CountVolume(side);
                    break;
                case "area":
                    result = CountArea(side);
                    break;
            }

            Console.WriteLine("{0:f2}", result);
        }

        private static double CountArea(double side)
        {
            return (6 * Math.Pow(side, 2));
        }

        private static double CountVolume(double side)
        {
            return Math.Pow(side, 3);
        }

        private static double CountSpace(double side)
        {
            return Math.Sqrt(3 * Math.Pow(side, 2));
        }

        private static double CountFace(double side)
        {
            return Math.Sqrt( 2 * Math.Pow(side, 2));
        }
    }
}