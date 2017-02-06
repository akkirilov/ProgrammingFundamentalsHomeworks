using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _09_Legendary_Farming
{
    class Program
    {
        public static Dictionary<string, int> keyMaterials = new Dictionary<string, int>
        { {"fragments", 0}, {"motes", 0}, { "shards", 0} };

        public static SortedDictionary<string, int> junk = new SortedDictionary<string, int>();

        static void Main(string[] args)
        {

            while (true)
            {
                string[] input = Console.ReadLine().ToLower().Split().ToArray();

                for (int i = 0; i < input.Length; i += 2)
                {

                    if (keyMaterials.ContainsKey(input[i + 1]))
                    {
                        keyMaterials[input[i + 1]] += int.Parse(input[i]);
                    }
                    else
                    {
                        if (junk.ContainsKey(input[i + 1]))
                        {
                            junk[input[i + 1]] += int.Parse(input[i]);
                        }
                        else
                        {
                            junk[input[i + 1]] = int.Parse(input[i]);
                        }
                    }

                    foreach (var item in keyMaterials)
                    {
                        if (item.Value >= 250)
                        {
                            PrintResult(item.Key);
                            return;
                        }
                    }
                }
            }
        }

        private static void PrintResult(string key)
        {
            switch (key)
            {
                case "shards":
                    Console.WriteLine($"Shadowmourne obtained!");
                    break;
                case "fragments":
                    Console.WriteLine($"Valanyr obtained!");
                    break;
                case "motes":
                    Console.WriteLine($"Dragonwrath obtained!");
                    break;
            }

            keyMaterials[key] -= 250;
            foreach (var item in keyMaterials.OrderByDescending(x => x.Value).ThenBy(x => x.Key))
            {
                Console.WriteLine($"{item.Key}: {item.Value}");
            }

            foreach (var item in junk.OrderBy(x => x.Key))
            {
                Console.WriteLine($"{item.Key}: {item.Value}");
            }
        }
    }
}