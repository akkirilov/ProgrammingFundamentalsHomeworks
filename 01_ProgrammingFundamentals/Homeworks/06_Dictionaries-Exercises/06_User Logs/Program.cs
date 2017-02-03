using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06_User_Logs
{
    class Program
    {
        static void Main(string[] args)
        {
            SortedDictionary<string, Dictionary<string, int>> usersBook = new SortedDictionary<string, Dictionary<string, int>>();

            string input = Console.ReadLine();

            while (input != "end")
            {
                List<string> inputEll = input.Split().ToList();

                string ipAddress = inputEll[0].Substring(3);
                string user = inputEll[2].Substring(5);

                if (usersBook.ContainsKey(user))
                {
                    if (usersBook[user].ContainsKey(ipAddress))
                    {
                        usersBook[user][ipAddress]++; 
                    }
                    else
                    {
                        usersBook[user][ipAddress] = 1;
                    }
                }
                else
                {
                    Dictionary<string, int> temp = new Dictionary<string, int>();
                    temp[ipAddress] = 1;
                    usersBook[user] = temp;
                }

                input = Console.ReadLine();
            }

            foreach (var user in usersBook)
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