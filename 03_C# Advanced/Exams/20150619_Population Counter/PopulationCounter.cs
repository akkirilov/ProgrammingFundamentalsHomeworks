using System;
using System.Collections.Generic;
using System.Linq;
using System.Numerics;

namespace _20150619_Population_Counter
{
    public class PopulationCounter
    {
        public static void Main()
        {
            List<Country> countries = new List<Country>();
            string[] input = Console.ReadLine().Split('|').Select(x => x.Trim()).ToArray();
            while (!input[0].Equals("report"))
            {
                if (countries.Any(x => x.Name.Equals(input[1])))
                {
                    int index = countries.FindIndex(x => x.Name.Equals(input[1]));
                    countries[index].Cities.Add(input[0], int.Parse(input[2]));
                }
                else
                {
                    Country temp = new Country()
                    {
                        Name = input[1],
                        Cities = new Dictionary<string, int>()
                        {
                            [input[0]] = int.Parse(input[2])
                        }
                    };

                    countries.Add(temp);
                }

                input = Console.ReadLine().Split('|').Select(x => x.Trim()).ToArray();
            }

            foreach (var country in countries)
            {
                foreach (var city in country.Cities.OrderByDescending(x => x.Value))
                {
                    country.Population += city.Value;
                }
            }

            foreach (var country in countries.OrderByDescending(x => x.Population))
            {
                Console.WriteLine($"{country.Name} (total population: {country.Population})");
                foreach (var city in country.Cities.OrderByDescending(x => x.Value))
                {
                    Console.WriteLine($"=>{city.Key}: {city.Value}");
                }
            }
        }
    }
}