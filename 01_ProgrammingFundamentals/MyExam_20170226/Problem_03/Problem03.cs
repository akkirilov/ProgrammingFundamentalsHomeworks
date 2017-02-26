using System;
using System.Collections.Generic;
using System.Linq;

namespace Problem_03
{
    public class Problem03
    {
        public static void Main()
        {
            List<long> bees = new List<long>();
            List<long> hornets = new List<long>();
            string input = Console.ReadLine();
            if (!String.IsNullOrEmpty(input))
            {
                bees = input.Split().Select(x => x.Trim()).Select(long.Parse).ToList();
            }
            input = Console.ReadLine();
            if (!String.IsNullOrEmpty(input))
            {
                hornets = input.Split().Select(x => x.Trim()).Select(long.Parse).ToList();
            }

            long power = hornets.Sum();
            int powerIndex = 0;

            for (int i = 0; i < bees.Count; i++)
            {
                if (power <= bees[i])
                {
                    bees[i] -= power;
                    if (power > 0)
                    {
                        power -= hornets[powerIndex];
                        powerIndex++;
                    }
                }
                else
                {
                    bees[i] = 0;
                }
            }

            long beesPower = 0;
            for (int i = 0; i < bees.Count; i++)
            {
                if (bees[i] > 0)
                {
                    beesPower += bees[i];
                }
            }

            if (beesPower > 0)
            {
                for (int i = 0; i < bees.Count; i++)
                {
                    if (bees[i] > 0)
                    {
                        Console.Write(bees[i] + " ");
                    }
                }
                Console.WriteLine();
            }
            else
            {
                hornets.RemoveRange(0, powerIndex);
                Console.WriteLine($"{String.Join(" ", hornets)}");
            }
        }
    }
}