using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_01___Traveller_Bob
{
    class Program
    {
        static void Main(string[] args)
        {
            //13 min.
            string yearType = Console.ReadLine();
            int contractMonths = int.Parse(Console.ReadLine());
            int familyMonths = int.Parse(Console.ReadLine());
            int normalMonths = (12 - contractMonths - familyMonths);

            double travels = (contractMonths * 12) + (familyMonths * 4) + ((normalMonths * 12d) * (3d / 5d));
            if (yearType == "leap")
            {
                travels *= 1.05;
            }
            Console.WriteLine("{0}",Math.Floor(travels));
        }
    }
}