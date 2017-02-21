using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace _02_SoftUni_Karaoke
{
    class SoftUniKaraoke
    {
        static void Main()
        {
            string participantsString = Console.ReadLine();
            participantsString = new Regex(@"\s{2,}").Replace(participantsString, " ");
            List<string> participants = participantsString.Split(',').Select(x => x.Trim()).ToList();

            string songsString = Console.ReadLine();
            songsString = new Regex(@"\s{2,}").Replace(songsString, " ");
            List<string> songs = songsString.Split(',').Select(x => x.Trim()).ToList();

            Dictionary<string, SortedSet<string>> winners = new Dictionary<string, SortedSet<string>>();

            string input = Console.ReadLine();
            while (!input.Equals("dawn"))
            {
                input = new Regex(@"\s{2,}").Replace(input, " ");
                string[] inputEll = input.Split(',').Select(x => x.Trim()).ToArray();

                if (participants.Contains(inputEll[0]) && songs.Contains(inputEll[1]))
                {
                    if (winners.ContainsKey(inputEll[0]))
                    {
                        winners[inputEll[0]].Add(inputEll[2]);
                    }
                    else
                    {
                        winners[inputEll[0]] = new SortedSet<string>() { inputEll[2] };
                    }
                }
                
                input = Console.ReadLine();
            }

            if (winners.Count < 1)
            {
                Console.WriteLine("No awards");
                return;
            }

            foreach (var participant in winners.OrderByDescending(x => x.Value.Distinct().Count()).ThenBy(x => x.Key))
            {
                Console.WriteLine($"{participant.Key}: {participant.Value.Count} awards");
                foreach (var award in participant.Value.OrderBy(x => x))
                {
                    Console.WriteLine($"--{award}");
                }
            }
        }
    }
}