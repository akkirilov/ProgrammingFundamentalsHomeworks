using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07_Population_Counter
{
    class Program
    {
        static void Main(string[] args)
        {
            Dictionary<string, Dictionary<string, long>> citiesPopulation = new Dictionary <string, Dictionary<string, long>>();
            Dictionary<string, long> countriesPopulation = new Dictionary<string, long>();

            string input = Console.ReadLine();

            while (input != "report")
            {
                List<string> inputEll = input.Split('|').ToList();

                string country = inputEll[1];
                string city = inputEll[0];
                long population = long.Parse(inputEll[2]);

                if (citiesPopulation.ContainsKey(country))
                {
                    citiesPopulation[country][city] = population;
                    countriesPopulation[country] += population;
                }
                else
                {
                    Dictionary<string, long> tempCity = new Dictionary<string, long>();
                    tempCity[city] = population;
                    citiesPopulation[country] = tempCity;
                    countriesPopulation[country] = population;
                }

                input = Console.ReadLine();
            }

            foreach (var country in countriesPopulation.OrderByDescending(x => x.Value).ThenBy(x => x.Key))
            {
                Console.WriteLine($"{country.Key} (total population: {country.Value})");

                foreach (var city in citiesPopulation[country.Key].OrderByDescending(x => x.Value).ThenBy(x => x.Key))
                {
                    Console.WriteLine($"=>{city.Key}: {city.Value}");
                }
            }
        }
    }
}