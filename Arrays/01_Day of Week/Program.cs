using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01_Day_of_Week
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] daysOfWeek = new string[] { "Invalid Day!", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
            int n = int.Parse(Console.ReadLine());
            if (n > 7 || n < 0)
            {
                Console.WriteLine(daysOfWeek[0]);
            }
            else
            {
                Console.WriteLine(daysOfWeek[n]);
            }
        }
    }
}