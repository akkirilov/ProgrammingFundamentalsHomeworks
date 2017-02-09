using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _09_Teamwork_Projects
{
    public class TeamworkProjects
    {
        public static void Main()
        {
            List<Team> teams = new List<Team>();

            int n = int.Parse(Console.ReadLine());
            string input;
            for (int i = 0; i < n; i++)
            {
                input = Console.ReadLine();
                string[] inputEll = input.Split('-').ToArray();

                Team currentTeam = new Team
                {
                    Name = inputEll[1],
                    Creator = inputEll[0],
                    Members = new List<string>()
                };

                if (!teams.Select(x => x.Name).Contains(inputEll[1]))
                {
                    if (!teams.Select(x => x.Creator).Contains(inputEll[0]))
                    {
                        teams.Add(currentTeam);
                        Console.WriteLine($"Team {inputEll[1]} has been created by {inputEll[0]}!");
                    }
                    else
                    {
                        Console.WriteLine($"{inputEll[0]} cannot create another team!");
                    }
                }
                else
                {
                    Console.WriteLine($"Team {inputEll[1]} was already created!");
                }
            }

            input = Console.ReadLine();
            while (input != "end of assignment")
            {
                string[] inputEll = input.Split(new string[] { "->" }, StringSplitOptions.None).ToArray();
                if (!teams.Select(x => x.Name).Contains(inputEll[1]))
                {
                    Console.WriteLine($"Team {inputEll[1]} does not exist!");
                }
                else if (teams.Select(x => x.Members).Any(x => x.Contains(inputEll[0])) || teams.Select(x => x.Creator).Contains(inputEll[0]))
                {
                    Console.WriteLine($"Member {inputEll[0]} cannot join team {inputEll[1]}!");
                }
                else
                {
                    int teamToJoinIndex = teams.FindIndex(x => x.Name == inputEll[1]);
                    teams[teamToJoinIndex].Members.Add(inputEll[0]);
                }
                
                input = Console.ReadLine();
            }

            foreach (var team in teams.OrderByDescending(x => x.Members.Count).ThenBy(x => x.Name))
            {
                if (team.Members.Count > 0)
                {
                    Console.WriteLine($"{team.Name}");
                    Console.WriteLine($"- {team.Creator}");
                    foreach (var member in team.Members.OrderBy(x => x))
                    {
                        Console.WriteLine($"-- {member}");
                    }
                }
            }

            Console.WriteLine("Teams to disband:");
            foreach (var team in teams.OrderBy(x => x.Name))
            {
                if (team.Members.Count == 0)
                {
                    Console.WriteLine($"{team.Name}");
                }
            }
        }
    }
}