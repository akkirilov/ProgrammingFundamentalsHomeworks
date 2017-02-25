using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace _20160228_04_Events
{
    public class Program
    {
        public static void Main()
        {
            SortedDictionary<string, Dictionary<string, List<DateTime>>> events = new SortedDictionary<string, Dictionary<string, List<DateTime>>>();

            string pattern = @"^#([A-Za-z]+):\s*@([A-Za-z]+)\s*([0-9]{1,2})\:([0-9]{1,2})$";

            int n = int.Parse(Console.ReadLine());
            for (int i = 0; i < n; i++)
            {
                string input = Console.ReadLine();
                Regex regex = new Regex(pattern);
                if (regex.IsMatch(input))
                {
                    Match match = regex.Match(input);
                    string place = match.Groups[2].ToString();
                    string person = match.Groups[1].ToString();
                    int hour = int.Parse(match.Groups[3].ToString());
                    int minutes = int.Parse(match.Groups[4].ToString());

                    if (hour > 23 || minutes > 59)
                    {
                        continue;
                    }

                    DateTime currentTime = DateTime.Parse((hour + ":" + minutes).ToString());
                    if (events.ContainsKey(place))
                    {
                        if (events[place].ContainsKey(person))
                        {
                            events[place][person].Add(currentTime);
                        }
                        else
                        {
                            events[place].Add(person, new List<DateTime>() { currentTime });
                        }
                    }
                    else
                    {
                        events.Add(place, new Dictionary<string, List<DateTime>>() { [person] = new List<DateTime>() { currentTime } });
                    }
                }
            }

            string[] filter = Console.ReadLine().Split(',').Select(x => x.Trim()).ToArray();

            foreach (var ev in events)
            {
                if (filter.Contains(ev.Key))
                {
                    int count = 1;
                    Console.WriteLine($"{ev.Key}:");
                    foreach (var person in ev.Value.OrderBy(x => x.Key))
                    {
                        List<string> times = person.Value.OrderBy(x => x).Select(x => x.ToString("HH:mm")).ToList();
                        Console.WriteLine($"{count++}. {person.Key} -> {String.Join(", ", times)}");
                    }
                }
            }
        }
    }
}