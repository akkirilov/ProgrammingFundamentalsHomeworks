using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _20160612_03_Football_League
{
    class Program
    {
        public static Dictionary<string, int> teamPoints = new Dictionary<string, int>();
        public static Dictionary<string, long> teamGoals = new Dictionary<string, long>();

        static void Main(string[] args)
        {
            string[] separator = Console.ReadLine().Split().ToArray();

            string[] input = Console.ReadLine().Split(separator, StringSplitOptions.None).ToArray();

            while (input[0] != "final")
            {
                string teamA = String.Format(String.Join("", input[1].ToUpper().Reverse().ToArray()));
                string teamB = String.Format(String.Join("", input[3].ToUpper().Reverse().ToArray()));
                string[] scoreFull = input[4].Split().ToArray();
                long[] score = (scoreFull.Length == 1 ? scoreFull[0] : scoreFull[1]).Split(':').Select(long.Parse).ToArray();

                AddGoals(teamA, score[0]);
                AddGoals(teamB, score[1]);

                CalculateAndAddPoints(teamA, teamB, score[0], score[1]);

                input = Console.ReadLine().Split(separator, StringSplitOptions.None).ToArray();
            }

            int count = 1;
            Console.WriteLine("League standings:");
            foreach (var team in teamPoints.OrderByDescending(x => x.Value).ThenBy(x => x.Key))
            {
                Console.WriteLine($"{count++}. {team.Key} {team.Value}");
            }

            Console.WriteLine("Top 3 scored goals:");
            foreach (var team in teamGoals.OrderByDescending(x => x.Value).ThenBy(x => x.Key).Take(3))
            {
                Console.WriteLine($"- {team.Key} -> {team.Value}");
            }
        }

        private static void CalculateAndAddPoints(string teamA, string teamB, long scoreA, long scoreB)
        {
            if (scoreA > scoreB)
            {
                scoreA = 3;
                scoreB = 0;
            }
            else if (scoreA < scoreB)
            {
                scoreA = 0;
                scoreB = 3;
            }
            else
            {
                scoreA = 1;
                scoreB = 1;
            }

            AddPoints(teamA, scoreA);
            AddPoints(teamB, scoreB);
        }

        private static void AddPoints(string team, long points)
        {
            if (teamPoints.ContainsKey(team))
            {
                teamPoints[team] += (int)points;
                return;
            }
            teamPoints[team] = (int)points;
        }

        private static void AddGoals(string team, long score)
        {
            if (teamGoals.ContainsKey(team))
            {
                teamGoals[team] += score;
                return; 
            }
            teamGoals[team] = score;
        }
    }
}