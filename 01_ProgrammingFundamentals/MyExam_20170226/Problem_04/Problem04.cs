using System;
using System.Collections.Generic;
using System.Linq;

namespace Problem_04
{
    public class Problem04
    {
        public static void Main()
        {
            List<Legion> legions = new List<Legion>();

            int n = int.Parse(Console.ReadLine());
            for (int i = 0; i < n; i++)
            {
                string[] input = Console.ReadLine().Split(new[] { ' ', '-', '>', '=', ':' }, StringSplitOptions.RemoveEmptyEntries).Select(x => x.Trim()).ToArray();
                string name = input[1];
                string soldiers = input[2];
                long activity = long.Parse(input[0]);
                long soldiersCount = long.Parse(input[3]);

                if (legions.Any(x => x.Name.Equals(name)))
                {
                    int index = legions.FindIndex(x => x.Name.Equals(name));
                    if (legions[index].Soldiers.ContainsKey(soldiers))
                    {
                        legions[index].Soldiers[soldiers] += soldiersCount;
                    }
                    else
                    {
                        legions[index].Soldiers[soldiers] = soldiersCount;
                    }

                    if (activity > legions[index].LastActivity)
                    {
                        legions[index].LastActivity = activity;
                    }
                }
                else
                {
                    Legion temp = new Legion()
                    {
                        Name = name,
                        LastActivity = activity,
                        Soldiers = new Dictionary<string, long>()
                        {
                            [soldiers] = soldiersCount
                        }
                    };

                    legions.Add(temp);
                }
            }

            string[] parameters = Console.ReadLine().Split('\\').Select(x => x.Trim()).ToArray();

            if (parameters.Length == 1)
            {
                foreach (var legion in legions.OrderByDescending(x => x.LastActivity))
                {
                    if (legion.Soldiers.ContainsKey(parameters[0]))
                    {
                        Console.WriteLine($"{legion.LastActivity} : {legion.Name}");
                    }
                }
            }
            else
            {
                Dictionary<string, long> soldiers = new Dictionary<string, long>();
                foreach (var legion in legions)
                {
                    if (legion.Soldiers.ContainsKey(parameters[1]) && legion.LastActivity < long.Parse(parameters[0]))
                    {
                        soldiers.Add(legion.Name, legion.Soldiers[parameters[1]]);
                    }
                }

                foreach (var legion in soldiers.OrderByDescending(x => x.Value))
                {
                    {
                        Console.WriteLine($"{legion.Key} -> {legion.Value}");
                    }
                }
            }
        }
    }
}