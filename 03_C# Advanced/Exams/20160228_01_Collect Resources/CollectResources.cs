using System;
using System.Collections.Generic;
using System.Linq;

namespace _20160228_01_Collect_Resources
{
    public class CollectResources
    {
        public static void Main()
        {
            string[] totalRecources = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(x => x.Trim())
                .ToArray();

            List<string> validRecources = new List<string>()
            {
                "stone",
                "gold",
                "wood",
                "food"
            };

            List<double> quantities = new List<double>();

            int n = int.Parse(Console.ReadLine().Trim());
            for (int i = 0; i < n; i++)
            {
                string[] path = Console.ReadLine()
                    .Split()
                    .Select(x => x.Trim())
                    .ToArray();

                if (path.Length != 2)
                {
                    continue;
                }

                List<long> indexesOfCollectedRecources = new List<long>();

                long start = long.Parse(path[0]);
                long step = long.Parse(path[1]);
                double currentResult = 0;
                while (true)
                {
                    if (start >= totalRecources.Length)
                    {
                        start %= totalRecources.Length;
                    }

                    if (indexesOfCollectedRecources.Any(x => x.Equals(start)))
                    {
                        break;
                    }

                    string[] recourceEll = totalRecources[start]
                        .Split('_')
                        .Select(x => x.Trim())
                        .ToArray();

                    if (validRecources.Any(x => x.Equals(recourceEll[0])))
                    {
                        double value = 1;
                        if (recourceEll.Length == 2)
                        {
                            value = double.Parse(recourceEll[1]);
                        }

                        currentResult += value;
                        indexesOfCollectedRecources.Add(start);
                    }

                    start += step;
                }

                quantities.Add(currentResult);
            }

            Console.WriteLine($"{quantities.Max()}");
        }
    }
}