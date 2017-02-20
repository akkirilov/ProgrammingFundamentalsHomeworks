using System;
using System.Collections.Generic;
using System.Linq;

namespace _20170106_03_Endurance_Rally
{
    public class EnduranceRally
    {
        public static void Main()
        {
            List<string> drivers = Console.ReadLine()
                .Split()
                .Select(x => x.Trim())
                .ToList();

            List<double> track = Console.ReadLine()
                .Split()
                .Select(double.Parse)
                .ToList();

            List<int> checkPoints = Console.ReadLine()
                .Split()
                .Select(int.Parse)
                .ToList();

            for (int d = 0; d < drivers.Count; d++)
            {
                double dFuel = (double)drivers[d][0];
                for (int t = 0; t < track.Count; t++)
                {
                    if (checkPoints.Contains(t))
                    {
                        dFuel += track[t]; 
                    }
                    else
                    {
                        dFuel -= track[t];

                        if (dFuel <= 0)
                        {
                            Console.WriteLine($"{drivers[d]} - reached {t}");
                            break;
                        }
                    }
                }

                if (dFuel > 0)
                {
                    Console.WriteLine($"{drivers[d]} - fuel left {dFuel:f2}");
                }
            }
        }
    }
}