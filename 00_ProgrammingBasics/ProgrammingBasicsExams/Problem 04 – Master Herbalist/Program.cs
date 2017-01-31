using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_04___Master_Herbalist
{
    class Program
    {
        static void Main(string[] args)
        {
            int dayli = int.Parse(Console.ReadLine());
            string line = Console.ReadLine();
            decimal earn = 0;
            int count = 0;
            decimal p = 0;

            while (line != "Season Over")
            {
                string[] lineEll = line.Split(' ');
                int hour = int.Parse(lineEll[0]);
                string path = lineEll[1];
                int price = int.Parse(lineEll[2]);

                for (int i = 0; i < hour; i++)
                {
                    if (path[i%path.Length] == 'H')
                    {
                        earn += price;
                    }
                }
                count++;
                line = Console.ReadLine();
            }

            if ((earn/count)>=dayli)
            {
                Console.WriteLine("Times are good. Extra money per day: {0:f2}.", ((earn / count) - dayli));
            }
            if ((earn / count) < dayli)
            {
                Console.WriteLine("We are in the red. Money needed: {0}.", Math.Round(((dayli*count)  - earn)));
            }
        }
    }
}
