using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace _04_Files
{
    class Files
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            List<string> inputs = new List<string>();
            for (int i = 0; i < n; i++)
            {
                inputs.Add(Console.ReadLine());
            }

            string[] parameters = Console.ReadLine().Split().Select(x => x.Trim()).ToArray();

            Dictionary<string, ulong> files = new Dictionary<string, ulong>();
            for (int i = 0; i < n; i++)
            {
                Match match = new Regex(@"^(\w+:*)\\*.*\\([^\\]+\.)(\w+);(\d+)$").Match(inputs[i]);

                if (parameters[2].Equals(match.Groups[1].ToString()) && parameters[0].Equals(match.Groups[3].ToString()))
                {
                    files[(match.Groups[2].ToString() + match.Groups[3].ToString()).ToString()] = ulong.Parse(match.Groups[4].ToString());
                }
            }

            if (files.Count == 0)
            {
                Console.WriteLine("No");
                return;
            }

            foreach (var file in files.OrderByDescending(x => x.Value).ThenBy(x => x.Key))
            {
                Console.WriteLine($"{file.Key} - {file.Value} KB");
            }
        }
    }
}