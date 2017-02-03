using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07_Population_Counter
{
    class Program
    {
        static void Main(string[] args)
        {
            SortedDictionary<string, Dictionary<string, int>> populationBook = new SortedDictionary<string, Dictionary<string, int>>();

            string input = Console.ReadLine();

            while (input != "end")
            {
                List<string> inputEll = input.Split().ToList();

                string ipAddress = inputEll[0].Substring(3);
                string city = inputEll[2].Substring(5);

                if (populationBook.ContainsKey(city))
                {
                    if (populationBook[city].ContainsKey(ipAddress))
                    {
                        populationBook[city][ipAddress]++;
                    }
                    else
                    {
                        populationBook[city][ipAddress] = 1;
                    }
                }
                else
                {
                    Dictionary<string, int> temp = new Dictionary<string, int>();
                    temp[ipAddress] = 1;
                    populationBook[city] = temp;
                }

                input = Console.ReadLine();
            }

            foreach (var user in populationBook)
            {
                Console.WriteLine(user.Key + ":");

                List<string> userIP = new List<string>();
                foreach (var ip in user.Value)
                {
                    userIP.Add(String.Format($"{ip.Key} => {ip.Value}"));
                }

                Console.WriteLine("{0}.", String.Join(", ", userIP));
            }
        }
    }
}
