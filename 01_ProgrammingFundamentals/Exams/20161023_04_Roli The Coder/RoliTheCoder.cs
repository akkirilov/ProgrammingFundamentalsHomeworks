using System;
using System.Collections.Generic;
using System.Linq;

namespace _20161023_04_Roli_The_Coder
{
    public class RoliTheCoder
    {
        public static void Main()
        {
            List<Event> events = new List<Event>();

            string request = Console.ReadLine();
            while (!request.Equals("Time for Code"))
            {
                List<string> requestEll = request.Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).ToList();

                string id = requestEll[0];
                string name = requestEll[1];
                List<string> currentParticipants = requestEll.Skip(2).ToList();

                if (!name.StartsWith("#") || (events.Any(e => e.ID == id && e.Name != name.TrimStart('#'))))
                {
                    request = Console.ReadLine();
                    continue;
                }

                if (events.Any(x => x.ID == id))
                {
                    int index = events.FindIndex(x => x.ID == id);
                    for (int i = 0; i < currentParticipants.Count; i++)
                    {
                        events[index].Participants.Add(currentParticipants[i]);
                    }
                }
                else
                {
                    events.Add(new Event()
                    {
                        ID = id,
                        Name = name.TrimStart('#'),
                        Participants = new SortedSet<string>(currentParticipants)
                    });
                }

                request = Console.ReadLine();
            }

            foreach (var item in events.OrderByDescending(x => x.Participants.Count).ThenBy(x => x.Name))
            {
                Console.WriteLine($"{item.Name} - {item.Participants.Count}");
                foreach (var participant in item.Participants.OrderBy(x => x))
                {
                    Console.WriteLine($"{participant}");
                }
            }
        }
    }
}