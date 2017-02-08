using System;
using System.Collections.Generic;
using System.Globalization;

namespace _01_Count_Working_Days
{
    class CountWorkingDays
    {
        static void Main()
        {
            DateTime startDate = DateTime.ParseExact(Console.ReadLine(), "dd-MM-yyyy", CultureInfo.InvariantCulture);
            DateTime endDate = DateTime.ParseExact(Console.ReadLine(), "dd-MM-yyyy", CultureInfo.InvariantCulture);

            List<DateTime> officialHolidays = new List<DateTime>
            {
                new DateTime(startDate.Year,1,1),
                new DateTime(startDate.Year,3,3),
                new DateTime(startDate.Year,5,1),
                new DateTime(startDate.Year,5,6),
                new DateTime(startDate.Year,5,24),
                new DateTime(startDate.Year,9,6),
                new DateTime(startDate.Year,9,22),
                new DateTime(startDate.Year,11,1),
                new DateTime(startDate.Year,12,24),
                new DateTime(startDate.Year,12,25),
                new DateTime(startDate.Year,12,26)
            };

            int counter = 0;
            for (DateTime currentDate = startDate; currentDate <= endDate; currentDate = currentDate.AddDays(1)) 
            {
                if (officialHolidays[0].Year < currentDate.Year)
                {
                    for (int i = 0; i < officialHolidays.Count; i++)
                    {
                        officialHolidays[i] = officialHolidays[i].AddYears(1);
                    }
                }

                if (currentDate.DayOfWeek != DayOfWeek.Saturday && currentDate.DayOfWeek != DayOfWeek.Sunday && !officialHolidays.Contains(currentDate))
                {
                    counter++;
                }
            }

            Console.WriteLine(counter);
        }
    }
}