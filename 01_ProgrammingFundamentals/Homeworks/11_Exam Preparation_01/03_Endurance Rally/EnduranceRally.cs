using System;
using System.Collections.Generic;
using System.Linq;

namespace _03_Endurance_Rally
{
    public class EnduranceRally
    {
        public static void Main()
        {
            List<string> drivers = Console.ReadLine().Split().Select(x => x.Trim()).ToList();

            double[] trackPoints = Console.ReadLine().Split().Select(x => x.Trim()).Select(double.Parse).ToArray();
            int[] checkPoints = Console.ReadLine().Split().Select(x => x.Trim()).Select(int.Parse).ToArray();

            for (int d = 0; d < drivers.Count; d++)
            {
                double driverFuel = (int)drivers[d][0];
                bool haveFuel = true;
                for (int t = 0; t < trackPoints.Length; t++)
                {
                    if (checkPoints.Contains(t))
                    {
                        driverFuel += trackPoints[t];
                    }
                    else
                    {
                        driverFuel -= trackPoints[t];
                        if (driverFuel <= 0)
                        {
                            Console.WriteLine($"{drivers[d]} - reached {t}");
                            haveFuel = false;
                            break;
                        }
                    }
                }

                if (haveFuel)
                {
                    Console.WriteLine($"{drivers[d]} - fuel left {driverFuel:f2}");
                }
            }
        }
    }
}