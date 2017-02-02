using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03_A_Miner_Task
{
    class Program
    {
        static void Main(string[] args)
        {
            Dictionary<string, decimal> minerBook = new Dictionary<string, decimal>();

            string resource = Console.ReadLine();
            if (resource == "stop")
            {
                return;
            }

            string quantity = Console.ReadLine();

            while (true)
            {
                if (minerBook.ContainsKey(resource))
                {
                    minerBook[resource] += decimal.Parse(quantity);
                }
                else
                {
                    minerBook.Add(resource, decimal.Parse(quantity));
                }

                resource = Console.ReadLine();
                if (resource == "stop")
                {
                    break;
                }

                quantity = Console.ReadLine();
            }

            PrintMinerBook(minerBook);
        }

        private static void PrintMinerBook(Dictionary<string, decimal> minerBook)
        {
            foreach (var item in minerBook)
            {
                Console.WriteLine($"{item.Key} -> {item.Value}");
            }
        }
    }
}