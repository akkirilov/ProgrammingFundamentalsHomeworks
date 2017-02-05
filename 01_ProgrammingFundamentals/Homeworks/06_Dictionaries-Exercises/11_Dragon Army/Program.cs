using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _11_Dragon_Army
{
    class Program
    {
        static void Main(string[] args)
        {
            Dictionary<string, Dictionary<string, List<int>>> dragonType = new Dictionary<string, Dictionary<string, List<int>>>();

            int n = int.Parse(Console.ReadLine());
            for (int i = 0; i < n; i++)
            {
                string[] input = Console.ReadLine().Split().ToArray();

                string type = input[0];
                string name = input[1];
                int damage = GetDamage(input[2]);
                int health = GetHealth(input[3]);
                int armor = GetArmor(input[4]);
                
                if (!dragonType.ContainsKey(type))
                {
                    Dictionary<string, List<int>> temp = new Dictionary<string, List<int>>();
                    temp.Add(name, GetDragonStats(damage, health, armor));
                    dragonType[type] = temp;
                }
                else
                {
                    if (!dragonType[type].ContainsKey(name))
                    {
                        dragonType[type].Add(name, GetDragonStats(damage, health, armor));
                    }
                    else
                    {
                        dragonType[type][name] = GetDragonStats(damage, health, armor);
                    }
                }
            }

            foreach (var type in dragonType)
            {
                Dictionary<string, List<int>> damageType = new Dictionary<string, List<int>>() { { type.Key, new List<int>() } };
                Dictionary<string, List<int>> healthType = new Dictionary<string, List<int>>() { { type.Key, new List<int>() } }; 
                Dictionary<string, List<int>> armorType = new Dictionary<string, List<int>>() { { type.Key, new List<int>() } }; 

                foreach (var dragon in type.Value)
                {
                    damageType[type.Key].Add(dragon.Value[0]);
                    healthType[type.Key].Add(dragon.Value[1]);
                    armorType[type.Key].Add(dragon.Value[2]);
                }

                Console.WriteLine("{0}::({1:f2}/{2:f2}/{3:f2})", type.Key, damageType[type.Key].Average(), healthType[type.Key].Average(), armorType[type.Key].Average());

                foreach (var dragon in type.Value.OrderBy(x => x.Key))
                {
                    Console.WriteLine("-{0} -> damage: {1}, health: {2}, armor: {3}", dragon.Key, dragon.Value[0], dragon.Value[1], dragon.Value[2]);
                }
            }
        }

        private static int GetDamage(string damage)
        {
            if (damage == "null")
            {
                damage = "45";
            }

            return int.Parse(damage);
        }

        private static int GetHealth(string health)
        {
            if (health == "null")
            {
                health = "250";
            }

            return int.Parse(health);
        }

        private static int GetArmor(string armor)
        {
            if (armor == "null")
            {
                armor = "10";
            }

            return int.Parse(armor);
        }

        private static List<int> GetDragonStats(int damage, int health, int armor)
        {
            List<int> tempStats = new List<int>();
            tempStats.Add(damage);
            tempStats.Add(health);
            tempStats.Add(armor);

            return tempStats;
        }
    }
}