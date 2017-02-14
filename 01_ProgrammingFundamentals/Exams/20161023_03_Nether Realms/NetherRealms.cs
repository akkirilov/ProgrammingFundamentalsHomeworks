using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace _20161023_03_Nether_Realms
{
    public class NetherRealms
    {
        public static void Main()
        {
            List<string> demons = Console.ReadLine().Split(new char[] { ' ', ',' }, StringSplitOptions.RemoveEmptyEntries).ToList();

            List<Demon> demonsList = new List<Demon>();

            for (int i = 0; i < demons.Count; i++)
            {
                string demagePattern = @"(\+\d+\.\d+|-\d+\.\d+|\d+\.\d+|\+\d+|-\d+|\d+)";
                string healthPattern = @"[^\d\.\-\+\/\*\,]";

                Demon currentDemon = new Demon
                {
                    Name = demons[i],
                    Health = 0,
                    Damage = 0
                };

                MatchCollection healthMatches = new Regex(healthPattern).Matches(currentDemon.Name);
                for (int j = 0; j < healthMatches.Count; j++)
                {
                    currentDemon.Health += (int)(healthMatches[j].ToString()[0]);
                }

                MatchCollection damageMatches = new Regex(demagePattern).Matches(currentDemon.Name);
                for (int j = 0; j < damageMatches.Count; j++)
                {
                    currentDemon.Damage += decimal.Parse(damageMatches[j].ToString());
                }

                MultiplyOrDivideDamage(currentDemon);

                demonsList.Add(currentDemon);
            }

            foreach (var demon in demonsList.OrderBy(x => x.Name))
            {
                Console.WriteLine($"{demon.Name} - {demon.Health} health, {demon.Damage:f2} damage ");
            }
        }

        private static void MultiplyOrDivideDamage(Demon currentDemon)
        {
            int index = 0;

            while (true)
            {
                int found = currentDemon.Name.IndexOf('*', index);
                if (found >= 0)
                {
                    currentDemon.Damage *= 2;
                    index = found + 1;
                }
                else
                {
                    break;
                }
            }

            index = 0;
            while (true)
            {
                int found = currentDemon.Name.IndexOf('/', index);
                if (found >= 0)
                {
                    currentDemon.Damage /= 2;
                    index = found + 1;
                }
                else
                {
                    break;
                }
            }
        }
    }
}