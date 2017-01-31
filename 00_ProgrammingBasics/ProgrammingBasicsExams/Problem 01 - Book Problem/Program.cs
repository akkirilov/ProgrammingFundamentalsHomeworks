using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_01___Book_Problem
{
    class Program
    {
        static void Main(string[] args)
        {
            //60 min.
            double pages = int.Parse(Console.ReadLine());
            double daysOff = int.Parse(Console.ReadLine());
            double normalRead = int.Parse(Console.ReadLine());

            double daysRead = 30 - daysOff;

            if (daysRead<=0)
            {
                Console.WriteLine("never");
            }
            else
            {
                double mounthOfReads = (pages / (daysRead*normalRead));

                double years = Math.Floor((mounthOfReads)/12);
                double mounths = Math.Ceiling((mounthOfReads-(years*12)));

                Console.WriteLine("{0} years {1} months", years, mounths);
            }
        }
    }
}