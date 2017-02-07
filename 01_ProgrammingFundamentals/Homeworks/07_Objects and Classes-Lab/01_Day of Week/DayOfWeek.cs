using System;
using System.Globalization;

namespace _01_Day_of_Week
{
    class DayOfWeek
    {
        static void Main()
        {
            DateTime date = DateTime.ParseExact(Console.ReadLine(), "d-M-yyyy", CultureInfo.InvariantCulture);
            Console.WriteLine(date.DayOfWeek);
        }
    }
}