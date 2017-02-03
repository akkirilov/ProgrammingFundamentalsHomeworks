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
            Dictionary<string, int> minerBook = new Dictionary<string, int>();

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
                    minerBook[resource] += int.Parse(quantity);
                }
                else
                {
                    minerBook.Add(resource, int.Parse(quantity));
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

        private static void PrintMinerBook(Dictionary<string, int> minerBook)
        {
            foreach (var item in minerBook)
            {
                Console.WriteLine($"{item.Key} -> {item.Value}");
            }
        }
    }
}