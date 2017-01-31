using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04_Elevator
{
    class Program
    {
        static void Main(string[] args)
        {
            int persons = int.Parse(Console.ReadLine());
            int capacity = int.Parse(Console.ReadLine());
            int fullcourses = persons / capacity;

            if (persons % capacity == 0)
            {
                Console.WriteLine("{0}", (persons / fullcourses));
            }
            else
            {
                int lastcourse = persons % capacity;
                Console.WriteLine("{0}", (fullcourses + 1));
            }
        }
    }
}