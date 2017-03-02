using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04_13_Volleyball
{
    class Program
    {
        static void Main(string[] args)
        {
            string type = Console.ReadLine().ToLower();
            int hollyDays = int.Parse(Console.ReadLine());
            int birdTown = int.Parse(Console.ReadLine());
             

            if (type == "normal")
            {
                double result = (
                    ((48 - birdTown) * (3.00 / 4.00))
                    + ((2.00 / 3.00) * hollyDays)
                    + birdTown);

                result = Math.Floor(result);
                Console.WriteLine(result);
            }
            else if (type == "leap")
            {
                double result = (1.15*(((48 - birdTown) * (3.00 / 4.00))
                    + ((2.00 / 3.00) * hollyDays)
                    + birdTown));

                result = Math.Floor(result);
                Console.WriteLine(result);
            }
        }
    }
}
