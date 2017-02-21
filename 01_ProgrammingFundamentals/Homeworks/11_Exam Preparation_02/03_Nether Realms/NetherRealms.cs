using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

namespace _03_Nether_Realms
{
    public class NetherRealms
    {
        public static void Main()
        {
            string[] demons = Console.ReadLine().Split(',').Select(x => x.Trim()).ToArray();

            SortedDictionary<string, int> demonHealth = new SortedDictionary<string, int>();
            SortedDictionary<string, double> demonDamage = new SortedDictionary<string, double>();
            for (int i = 0; i < demons.Length; i++)
            {
                int health = 0;
                string healthPattern = @"([^\d\*\/\+-\.,])";
                MatchCollection healthMatches = new Regex(healthPattern).Matches(demons[i]);
                for (int h = 0; h < healthMatches.Count; h++)
                {
                    health += (int)((char)(healthMatches[h].Groups[1].ToString()[0]));
                }
                demonHealth[demons[i]] = health;

                double damage = 0;
                string damagePattern = @"(\d+\.\d+|-\d+\.\d+|\+\d+\.\d+|\d+|-\d+|\+\d+)";
                MatchCollection damageMatches = new Regex(damagePattern).Matches(demons[i]);
                for (int d = 0; d < damageMatches.Count; d++)
                {
                    damage += double.Parse(damageMatches[d].Groups[1].ToString());
                }
                for (int j = 0; j < demons[i].Length; j++)
                {
                    if (demons[i][j] == '*')
                    {
                        damage *= 2;
                    }
                    else if (demons[i][j] == '/')
                    {
                        damage /= 2;
                    }
                }
                demonDamage[demons[i]] = damage;
            }

            foreach (var demon in demonHealth)
            {
                Console.WriteLine($"{demon.Key} - {demon.Value} health, {demonDamage[demon.Key]:f2} damage");
            }
        }
    }
}