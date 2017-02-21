using System;
using System.Globalization;

namespace _01_Sino_The_Walker
{
    class Program
    {
        static void Main(string[] args)
        {
            string timeFormat = @"HH:mm:ss";

            DateTime time = DateTime.ParseExact(Console.ReadLine(), timeFormat, CultureInfo.InvariantCulture);

            long steps = long.Parse(Console.ReadLine()) % 86400;
            long secondsPerStep = long.Parse(Console.ReadLine()) % 86400;

            time = time.AddSeconds((ulong)(steps * secondsPerStep));

            Console.WriteLine("Time Arrival: {0}", time.ToString(timeFormat));
        }
    }
}