using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _10_Srbsko_Unleashed
{
    class Program
    {
        public static Dictionary<string, Dictionary<string, long>> srbsko = new Dictionary<string, Dictionary<string, long>>();
        static void Main(string[] args)
        {
            while (true)
            {
                string[] input = Console.ReadLine().Split('@').ToArray();
                if (input[0] == "End")
                {
                    break;
                }
               
                if (input.Length != 2)
                {
                    continue;
                }

                string[] right = input[1].Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).ToArray();
                if (right.Length < 3)
                {
                    continue;
                }

                long ticketPrice, ticketCount, totalProfit;
                if (long.TryParse(right[right.Length - 2], out ticketPrice) && long.TryParse(right[right.Length - 1], out ticketCount))
                {
                    totalProfit = ticketCount * ticketPrice;
                }
                else
                {
                    continue;
                }

                if (input[0][input[0].Length - 1] != ' ')
                {
                    continue;
                }
                string[] left = input[0].Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).ToArray();

                string singer = String.Join(" ", left);

                string vanue = String.Join(" ", right, 0, right.Length - 2);

                if (!srbsko.ContainsKey(vanue))
                {
                    Dictionary<string, long> temp = new Dictionary<string, long>();
                    temp.Add(singer, totalProfit);
                    srbsko[vanue] = temp;
                }
                else
                {
                    if (!srbsko[vanue].ContainsKey(singer))
                    {
                        srbsko[vanue][singer] = totalProfit;
                    }
                    else
                    {
                        srbsko[vanue][singer] += totalProfit;
                    }
                }
            }

            foreach (var venue in srbsko)
            {
                Console.WriteLine(venue.Key);

                foreach (var singer in venue.Value.OrderByDescending(x => x.Value))
                {
                    Console.WriteLine($"#  {singer.Key} -> {singer.Value}");
                }
            }
        }
    }
}