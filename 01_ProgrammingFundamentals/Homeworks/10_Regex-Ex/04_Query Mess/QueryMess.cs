using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace _04_Query_Mess
{
    public class QueryMess
    {
        public static void Main()
        {
            string input = Console.ReadLine();
            while (!input.Equals("END"))
            {
                Dictionary<string, List<string>> result = new Dictionary<string, List<string>>();

                List<string> findMatch = input.Split('&').ToList();
                for (int i = 0; i < findMatch.Count; i++)
                {
                    string key = new Regex(@"([^?]+)=").Match(findMatch[i]).Groups[1].ToString();
                    key = new Regex(@"\+|%20").Replace(key, " ");
                    key = new Regex(@"\s+").Replace(key, " ").Trim();

                    string value = new Regex(@"=([^?]+)").Match(findMatch[i]).Groups[1].ToString();
                    value = new Regex(@"\+|%20").Replace(value, " ");
                    value = new Regex(@"\s+").Replace(value, " ").Trim();

                    if (result.ContainsKey(key))
                    {
                        result[key].Add(value);
                    }
                    else
                    {
                        result[key] = new List<string>();
                        result[key].Add(value);
                    }
                }

                foreach (var item in result)
                {
                    Console.Write($"{item.Key}=[{String.Join(", ", item.Value)}]");
                }
                Console.WriteLine();

                input = Console.ReadLine();
            }
        }
    }
}