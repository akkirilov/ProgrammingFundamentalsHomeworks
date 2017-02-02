using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _20160602_04_SoftUni_Coffee_Supplies
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] delimiters = Console.ReadLine().Split().ToArray();
            Dictionary<string, string> teamMembers = new Dictionary<string, string>();
            Dictionary<string, int> coffeeTypes = new Dictionary<string, int>();

            string input = Console.ReadLine();
            while (input != "end of info")
            {
                if (input.Contains(delimiters[0]))
                {
                    string[] inputEll = input.Split(new[] { delimiters[0] }, StringSplitOptions.None);
                    string person = inputEll[0];
                    string preferredCoffee = inputEll[1];
                    teamMembers.Add(person, preferredCoffee);
                }
                else
                {
                    string[] inputEll = input.Split(new[] { delimiters[1] }, StringSplitOptions.None);
                    string coffee = inputEll[0];
                    int amount = int.Parse(inputEll[1]);
                    if (coffeeTypes.ContainsKey(coffee))
                    {
                        coffeeTypes[coffee] += amount;
                    }
                    else
                    {
                        coffeeTypes.Add(coffee, amount);
                    }

                }
                input = Console.ReadLine();
            }

            foreach (var item in teamMembers)
            {
                if (!coffeeTypes.ContainsKey(item.Value))
                {
                    coffeeTypes.Add(item.Value,0);
                    Console.WriteLine("Out of " + item.Value);
                }
            }

            input = Console.ReadLine();
            while (input != "end of week")
            {
                string[] inputEll = input.Split().ToArray();
                string person = inputEll[0];
                int drunkCoffee = int.Parse(inputEll[1]);

                coffeeTypes[teamMembers[person]] -= drunkCoffee;
                if (coffeeTypes[(teamMembers[person])] <= 0)
                {
                    Console.WriteLine("Out of " + teamMembers[person]);
                }
                input = Console.ReadLine();
            }
            Console.WriteLine("Coffee Left:");
            foreach (var item in coffeeTypes.OrderByDescending(x => x.Value))
            {
                if (item.Value > 0)
                {
                    Console.WriteLine(item.Key + " " + item.Value);
                }
            }
            Console.WriteLine("For:");
            foreach (var item in teamMembers.OrderBy(x => x.Value).ThenByDescending(x => x.Key))
            {
                if (coffeeTypes[item.Value] > 0)
                {
                    Console.WriteLine(item.Key + " " + item.Value);
                }
            }
        }
    }
}