using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace _20150531_04_Olympics_Are_Coming
{
    public class OlympicsAreComing
    {
        public static void Main()
        {
            List<Country> countries = new List<Country>();

            string input = Console.ReadLine();
            while (!input.Equals("report"))
            {
                input = new Regex(@"\s{2,}").Replace(input, " ");
                string[] inputEll = input
                    .Split('|')
                    .Select(x => x.Trim())
                    .ToArray();

                if (countries.Any(x => x.Name.Equals(inputEll[1])))
                {
                    int index = countries.FindIndex(x => x.Name.Equals(inputEll[1]));
                    countries[index].TotalAthletesWins.Add(inputEll[0]);
                }
                else
                {
                    countries.Add(new Country
                    {
                        Name = inputEll[1],
                        TotalAthletesWins = new List<string>(),
                    });

                    countries.Last().TotalAthletesWins.Add(inputEll[0]);
                }

                input = Console.ReadLine();
            }

            foreach (var country in countries.OrderByDescending(x => x.TotalAthletesWins.Count))
            {
                Console.WriteLine($"{country.Name} ({country.UniqueAthletes} participants): {country.TotalAthletesWins.Count} wins");
            }
        }
    }
}