using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_02___SleepyTomCat
{
    class Program
    {
        static void Main(string[] args)
        {
            //14 min.
            int p = int.Parse(Console.ReadLine());
            int r = (365 - p) * 63;
            p *= 127;
            int o = p + r;
            int chasove = 0;
            int minuti = 0;

            if (o>=30000)
            {
                o -= 30000;
                chasove = o / 60;
                minuti = o % 60;

                Console.WriteLine("Tom will run away");
                Console.WriteLine("{0} hours and {1} minutes more for play", chasove, minuti);
            }
            else if (o < 30000)
            {
                o = 30000 - o;
                chasove = o / 60;
                minuti = o % 60;

                Console.WriteLine("Tom sleeps well");
                Console.WriteLine("{0} hours and {1} minutes less for play", chasove, minuti);
            }
        }
    }
}