using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace _20151011_04_Srabsko_Unleashed
{
    public class SrabskoUnleashed
    {
        public static void Main(string[] args)
        {
            Dictionary<string, Dictionary<string, ulong>> venues = new Dictionary<string, Dictionary<string, ulong>>();

            string pattern = @"\b([\w+|\s*]+) @([\w+|\s*]+) (\d+) (\d+)\b";
            Regex regex = new Regex(pattern);

            string input = Console.ReadLine();
            while (!input.Equals("End"))
            {
                if (regex.IsMatch(input))
                {
                    Match match = regex.Match(input);

                    string venue = match.Groups[2].ToString();
                    string singer = match.Groups[1].ToString();
                    int tickets = int.Parse(match.Groups[3].ToString());
                    int ticketPrice = int.Parse(match.Groups[4].ToString());

                    if (venues.ContainsKey(venue))
                    {
                        if (venues[venue].ContainsKey(singer))
                        {
                            venues[venue][singer] += (ulong)(tickets * ticketPrice);
                        }
                        else
                        {
                            venues[venue].Add(singer, (ulong)(tickets * ticketPrice));
                        }
                    }
                    else
                    {
                        venues[venue] = new Dictionary<string, ulong>()
                        {
                            [singer] = (ulong)(tickets * ticketPrice)
                        };
                    }
                }

                input = Console.ReadLine();
            }

            foreach (var venue in venues)
            {
                Console.WriteLine($"{venue.Key}");
                foreach (var singer in venue.Value.OrderByDescending(x=> x.Value))
                {
                    Console.WriteLine($"#  {singer.Key} -> {singer.Value}");
                }
            }
        }
    }
}