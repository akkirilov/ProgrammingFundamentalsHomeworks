using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04_Roli_The_Coder
{
    public class RoliTheCoder
    {
        public static void Main()
        {
            Dictionary<string, string> idName = new Dictionary<string, string>();
            Dictionary<string, SortedSet<string>> nameParticipants = new Dictionary<string, SortedSet<string>>();

            string input = Console.ReadLine();
            while (!input.Equals("Time for Code"))
            {
                if (!input.Contains('#'))
                {
                    input = Console.ReadLine();
                    continue;
                }

                string[] getID = input.Split('#').Select(x => x.Trim()).ToArray();
                string id = getID[0];
                string name = getID[1].Split()[0].Trim();
                string[] getParticipants = getID[1].Split().Skip(1).Select(x => x.Trim()).ToArray();

                if (idName.ContainsKey(id))
                {
                    if (idName[id].Equals(name))
                    {
                        for (int i = 0; i < getParticipants.Length; i++)
                        {
                            nameParticipants[name].Add(getParticipants[i]);
                        }
                    }
                    else
                    {
                        input = Console.ReadLine();
                        continue;
                    }
                }
                else
                {
                    idName[id] = name;
                    nameParticipants[name] = new SortedSet<string>();
                    for (int i = 0; i < getParticipants.Length; i++)
                    {
                        nameParticipants[name].Add(getParticipants[i]);
                    }
                }

                input = Console.ReadLine();
            }

            foreach (var eventInfo in nameParticipants.OrderByDescending(x => x.Value.Count).ThenBy(x => x.Key))
            {
                Console.WriteLine($"{eventInfo.Key} - {eventInfo.Value.Count}");
                foreach (var participant in eventInfo.Value)
                {
                    Console.WriteLine(participant);
                }
            }

        }
    }
}