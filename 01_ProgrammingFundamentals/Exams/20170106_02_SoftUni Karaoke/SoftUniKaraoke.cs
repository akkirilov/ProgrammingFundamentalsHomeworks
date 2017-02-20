using System;
using System.Collections.Generic;
using System.Linq;

namespace _20170106_02_SoftUni_Karaoke
{
    public class SoftUniKaraoke
    {
        public static void Main()
        {
            List<string> participants = Console.ReadLine()
                .Split(',')
                .Select(x => x.Trim())
                .ToList();

            List<string> songs = Console.ReadLine()
                .Split(',')
                .Select(x => x.Trim())
                .ToList();

            Dictionary<string, SortedSet<string>> participantsResult = new Dictionary<string, SortedSet<string>>();

            List<string> input = Console.ReadLine()
                .Split(',')
                .Select(x => x.Trim())
                .ToList();
            while (!input[0].Equals("dawn"))
            {
                if (!participants.Any(x => x.Equals(input[0])) || !songs.Any(x => x.Equals(input[1])))
                {
                    input = Console.ReadLine()
                        .Split(',')
                        .Select(x => x.Trim())
                        .ToList();
                    continue;
                }

                if (participantsResult.ContainsKey(input[0]))
                {
                    participantsResult[input[0]].Add(input[2]);
                }
                else
                {
                    participantsResult[input[0]] = new SortedSet<string>()
                    {
                        input[2]
                    };
                }

                input = Console.ReadLine()
                    .Split(',')
                    .Select(x => x.Trim())
                    .ToList();
            }

            if (participantsResult.Count == 0)
            {
                Console.WriteLine("No awards");
            }

            foreach (var participant in participantsResult.OrderByDescending(x => x.Value.Count))
            {
                Console.WriteLine($"{participant.Key}: {participant.Value.Count} awards");
                foreach (var award in participant.Value)
                {
                    Console.WriteLine($"--{award}");
                }
            }
        }
    }
}