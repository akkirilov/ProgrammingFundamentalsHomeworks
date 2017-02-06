using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _08_Logs_Aggregator
{
    class Program
    {
        static void Main(string[] args)
        {
            SortedDictionary<string, long> userDuration = new SortedDictionary<string, long>();
            Dictionary<string, List<string>> userIP = new Dictionary<string, List<string>>();

            int n = int.Parse(Console.ReadLine());
            for (int i = 0; i < n; i++)
            {
                string[] input = Console.ReadLine().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).ToArray();
                string user = input[1];
                string ip = input[0];
                long duration = long.Parse(input[2]);

                List<string> tempIP = new List<string>();

                if (userIP.ContainsKey(user))
                {
                    userIP[user].Add(ip);
                    userDuration[user] += duration;
                }
                else
                {
                    tempIP.Add(ip);
                    userIP[user] = tempIP;
                    userDuration.Add(user, duration);
                }
            }

            foreach (var user in userDuration.OrderBy(x => x.Key))
            {
                Console.WriteLine($"{user.Key}: {user.Value} [{String.Join(", ", userIP[user.Key].OrderBy(x => x).Distinct())}]");
            }
        }
    }
}