using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03_09_MetricConverter
{
    class Program
    {
        static void Main(string[] args)
        {

            double inputNum = double.Parse(Console.ReadLine());
            string inputMetric = Console.ReadLine();
            string outputMetric = Console.ReadLine();

            if (inputMetric == "m")
            {
                if (outputMetric == "m")
                {
                    Console.WriteLine((inputNum * 1) + " " + outputMetric);
                }
                else if (outputMetric == "mm")
                {
                    Console.WriteLine((inputNum * 1000) + " " + outputMetric);
                }
                else if (outputMetric == "cm")
                {
                    Console.WriteLine((inputNum * 100) + " " + outputMetric);
                }
                else if (outputMetric == "mi")
                {
                    Console.WriteLine((inputNum * 0.000621371192) + " " + outputMetric);
                }
                else if (outputMetric == "in")
                {
                    Console.WriteLine((inputNum * 39.3700787) + " " + outputMetric);
                }
                else if (outputMetric == "km")
                {
                    Console.WriteLine((inputNum * 0.001) + " " + outputMetric);
                }
                else if (outputMetric == "ft")
                {
                    Console.WriteLine((inputNum * 3.2808399) + " " + outputMetric);
                }
                else if (outputMetric == "yd")
                {
                    Console.WriteLine((inputNum * 1.0936133) + " " + outputMetric);
                }
            }
            else if (inputMetric == "mm")
            {
                if (outputMetric == "m")
                {
                    Console.WriteLine(((inputNum * 1) / 1000) + " " + outputMetric);
                }
                else if (outputMetric == "mm")
                {
                    Console.WriteLine((inputNum * 1) + " " + outputMetric);
                }
                else if (outputMetric == "cm")
                {
                    Console.WriteLine(((inputNum * 100) / 1000) + " " + outputMetric);
                }
                else if (outputMetric == "mi")
                {
                    Console.WriteLine(((inputNum * 0.000621371192) / 1000) + " " + outputMetric);
                }
                else if (outputMetric == "in")
                {
                    Console.WriteLine(((inputNum * 39.3700787) / 1000) + " " + outputMetric);
                }
                else if (outputMetric == "km")
                {
                    Console.WriteLine(((inputNum * 0.001) / 1000) + " " + outputMetric);
                }
                else if (outputMetric == "ft")
                {
                    Console.WriteLine(((inputNum * 3.2808399) / 1000) + " " + outputMetric);
                }
                else if (outputMetric == "yd")
                {
                    Console.WriteLine(((inputNum * 1.0936133) / 1000) + " " + outputMetric);
                }
            }
            else if (inputMetric == "cm")
            {
                if (outputMetric == "m")
                {
                    Console.WriteLine(((inputNum * 1) / 100) + " " + outputMetric);
                }
                else if (outputMetric == "mm")
                {
                    Console.WriteLine(((inputNum * 1000) / 100) + " " + outputMetric);
                }
                else if (outputMetric == "cm")
                {
                    Console.WriteLine(((inputNum * 100) / 100) + " " + outputMetric);
                }
                else if (outputMetric == "mi")
                {
                    Console.WriteLine(((inputNum * 0.000621371192) / 100) + " " + outputMetric);
                }
                else if (outputMetric == "in")
                {
                    Console.WriteLine(((inputNum * 39.3700787) / 100) + " " + outputMetric);
                }
                else if (outputMetric == "km")
                {
                    Console.WriteLine(((inputNum * 0.001) / 100) + " " + outputMetric);
                }
                else if (outputMetric == "ft")
                {
                    Console.WriteLine(((inputNum * 3.2808399) / 100) + " " + outputMetric);
                }
                else if (outputMetric == "yd")
                {
                    Console.WriteLine(((inputNum * 1.0936133) / 100) + " " + outputMetric);
                }
            }
            else if (inputMetric == "mi")
            {
                if (outputMetric == "m")
                {
                    Console.WriteLine(((inputNum * 1) / 0.000621371192) + " " + outputMetric);
                }
                else if (outputMetric == "mm")
                {
                    Console.WriteLine(((inputNum * 1000) / 0.000621371192) + " " + outputMetric);
                }
                else if (outputMetric == "cm")
                {
                    Console.WriteLine(((inputNum * 100) / 0.000621371192) + " " + outputMetric);
                }
                else if (outputMetric == "mi")
                {
                    Console.WriteLine(((inputNum * 0.000621371192) / 0.000621371192) + " " + outputMetric);
                }
                else if (outputMetric == "in")
                {
                    Console.WriteLine(((inputNum * 39.3700787) / 0.000621371192) + " " + outputMetric);
                }
                else if (outputMetric == "km")
                {
                    Console.WriteLine(((inputNum * 0.001) / 0.000621371192) + " " + outputMetric);
                }
                else if (outputMetric == "ft")
                {
                    Console.WriteLine(((inputNum * 3.2808399) / 0.000621371192) + " " + outputMetric);
                }
                else if (outputMetric == "yd")
                {
                    Console.WriteLine(((inputNum * 1.0936133) / 0.000621371192) + " " + outputMetric);
                }
            }
            else if (inputMetric == "in")
            {
                if (outputMetric == "m")
                {
                    Console.WriteLine(((inputNum * 1) / 39.3700787) + " " + outputMetric);
                }
                else if (outputMetric == "mm")
                {
                    Console.WriteLine(((inputNum * 1000) / 39.3700787) + " " + outputMetric);
                }
                else if (outputMetric == "cm")
                {
                    Console.WriteLine(((inputNum * 100) / 39.3700787) + " " + outputMetric);
                }
                else if (outputMetric == "mi")
                {
                    Console.WriteLine(((inputNum * 0.000621371192) / 39.3700787) + " " + outputMetric);
                }
                else if (outputMetric == "in")
                {
                    Console.WriteLine(((inputNum * 39.3700787) / 39.3700787) + " " + outputMetric);
                }
                else if (outputMetric == "km")
                {
                    Console.WriteLine(((inputNum * 0.001) / 39.3700787) + " " + outputMetric);
                }
                else if (outputMetric == "ft")
                {
                    Console.WriteLine(((inputNum * 3.2808399) / 39.3700787) + " " + outputMetric);
                }
                else if (outputMetric == "yd")
                {
                    Console.WriteLine(((inputNum * 1.0936133) / 39.3700787) + " " + outputMetric);
                }
            }
            else if (inputMetric == "km")
            {
                if (outputMetric == "m")
                {
                    Console.WriteLine(((inputNum * 1) / 0.001) + " " + outputMetric);
                }
                else if (outputMetric == "mm")
                {
                    Console.WriteLine(((inputNum * 1000) / 0.001) + " " + outputMetric);
                }
                else if (outputMetric == "cm")
                {
                    Console.WriteLine(((inputNum * 100) / 0.001) + " " + outputMetric);
                }
                else if (outputMetric == "mi")
                {
                    Console.WriteLine(((inputNum * 0.000621371192) / 0.001) + " " + outputMetric);
                }
                else if (outputMetric == "in")
                {
                    Console.WriteLine(((inputNum * 39.3700787) / 0.001) + " " + outputMetric);
                }
                else if (outputMetric == "km")
                {
                    Console.WriteLine(((inputNum * 0.001) / 0.001) + " " + outputMetric);
                }
                else if (outputMetric == "ft")
                {
                    Console.WriteLine(((inputNum * 3.2808399) / 0.001) + " " + outputMetric);
                }
                else if (outputMetric == "yd")
                {
                    Console.WriteLine(((inputNum * 1.0936133) / 0.001) + " " + outputMetric);
                }
            }
            else if (inputMetric == "ft")
            {
                if (outputMetric == "m")
                {
                    Console.WriteLine(((inputNum * 1) / 3.2808399) + " " + outputMetric);
                }
                else if (outputMetric == "mm")
                {
                    Console.WriteLine(((inputNum * 1000) / 3.2808399) + " " + outputMetric);
                }
                else if (outputMetric == "cm")
                {
                    Console.WriteLine(((inputNum * 100) / 3.2808399) + " " + outputMetric);
                }
                else if (outputMetric == "mi")
                {
                    Console.WriteLine(((inputNum * 0.000621371192) / 3.2808399) + " " + outputMetric);
                }
                else if (outputMetric == "in")
                {
                    Console.WriteLine(((inputNum * 39.3700787) / 3.2808399) + " " + outputMetric);
                }
                else if (outputMetric == "km")
                {
                    Console.WriteLine(((inputNum * 0.001) / 3.2808399) + " " + outputMetric);
                }
                else if (outputMetric == "ft")
                {
                    Console.WriteLine(((inputNum * 3.2808399) / 3.2808399) + " " + outputMetric);
                }
                else if (outputMetric == "yd")
                {
                    Console.WriteLine(((inputNum * 1.0936133) / 3.2808399) + " " + outputMetric);
                }
            }
            else if (inputMetric == "yd")
            {
                if (outputMetric == "m")
                {
                    Console.WriteLine(((inputNum * 1) / 1.0936133) + " " + outputMetric);
                }
                else if (outputMetric == "mm")
                {
                    Console.WriteLine(((inputNum * 1000) / 1.0936133) + " " + outputMetric);
                }
                else if (outputMetric == "cm")
                {
                    Console.WriteLine(((inputNum * 100) / 1.0936133) + " " + outputMetric);
                }
                else if (outputMetric == "mi")
                {
                    Console.WriteLine(((inputNum * 0.000621371192) / 1.0936133) + " " + outputMetric);
                }
                else if (outputMetric == "in")
                {
                    Console.WriteLine(((inputNum * 39.3700787) / 1.0936133) + " " + outputMetric);
                }
                else if (outputMetric == "km")
                {
                    Console.WriteLine(((inputNum * 0.001) / 1.0936133) + " " + outputMetric);
                }
                else if (outputMetric == "ft")
                {
                    Console.WriteLine(((inputNum * 3.2808399) / 1.0936133) + " " + outputMetric);
                }
                else if (outputMetric == "yd")
                {
                    Console.WriteLine(((inputNum * 1.0936133) / 1.0936133) + " " + outputMetric);
                }
            }
        }
    }
}
