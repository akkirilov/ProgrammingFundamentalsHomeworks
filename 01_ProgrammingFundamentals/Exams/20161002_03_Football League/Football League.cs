using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

namespace _20161002_03_Football_League
{

    class Program
    {
        static void Main()
        {
            string separator = GetSeparatorForRegex(Console.ReadLine().ToCharArray());

            List<Team> teams = new List<Team>();

            string input = Console.ReadLine();
            while (!input.Equals("final"))
            {
                string patternTeams = $"{separator}(\\w+){separator}|{separator}{separator}";
                string patternGoals = @"(\d+):(\d+)";

                MatchCollection currentTeams = new Regex(patternTeams).Matches(input);
                MatchCollection currentGoals = new Regex(patternGoals).Matches(input);

                Team teamA = new Team
                {
                    Name = GetName(currentTeams[0].Groups[1].ToString().ToUpper()),
                    Goals = int.Parse(currentGoals[0].Groups[1].ToString()),
                    Points = 0
                };
                Team teamB = new Team
                {
                    Name = GetName(currentTeams[1].Groups[1].ToString().ToUpper()),
                    Goals = int.Parse(currentGoals[0].Groups[2].ToString()),
                    Points = 0
                };
                CountPoints(teamA, teamB);

                CountGoalsAndPoints(teamA, teams);
                CountGoalsAndPoints(teamB, teams);

                input = Console.ReadLine();
            }

            Console.WriteLine("League standings:");
            int counter = 1;
            foreach (var team in teams.OrderByDescending(x => x.Points).ThenBy(x => x.Name))
            {
                Console.WriteLine($"{counter++}. {team.Name} {team.Points}");
            }

            Console.WriteLine("Top 3 scored goals:");
            foreach (var team in teams.OrderByDescending(x => x.Goals).ThenBy(x => x.Name).Take(3))
            {
                Console.WriteLine($"- {team.Name} -> {team.Goals}");
            }
        }

        private static string GetName(string name)
        {
            if (name == null)
            {
                return "";
            }
            StringBuilder reversedName = new StringBuilder();
            for (int i = name.Length - 1; i >= 0; i--)
            {
                reversedName.Append(name[i]);
            }

            return reversedName.ToString();
        }

        private static string GetSeparatorForRegex(char[] str)
        {
            StringBuilder separator = new StringBuilder();
            for (int i = 0; i < str.Length; i++)
            {
                if (str[i].Equals('?') || str[i].Equals('^') || 
                    str[i].Equals(':') || str[i].Equals('\\') || 
                    str[i].Equals('*') || str[i].Equals('+'))
                {
                    separator.Append("\\");
                    separator.Append(str[i].ToString());
                }
                else
                {
                    separator.Append(str[i]);
                }
            }
            return separator.ToString();
        }

        private static void CountGoalsAndPoints(Team team, List<Team> teams)
        {
            if (teams.Select(x => x).Any(x => x.Name.Equals(team.Name)))
            {
                int index = teams.FindIndex(x => x.Name.Equals(team.Name));
                teams[index].Goals += team.Goals;
                teams[index].Points += team.Points;
            }
            else
            {
                teams.Add(team);
            }
        }

        private static void CountPoints(Team teamA, Team teamB)
        {
            if (teamA.Goals > teamB.Goals)
            {
                teamA.Points += 3;
            }
            else if (teamA.Goals < teamB.Goals)
            {
                teamB.Points += 3;
            }
            else
            {
                teamA.Points += 1;
                teamB.Points += 1;
            }
        }
    }
}