using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07_Andrey_and_billiard
{
    public class AndreyAndBilliard
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            Dictionary<string, decimal> entities = new Dictionary<string, decimal>();

            for (int i = 0; i < n; i++)
            {
                string[] input = Console.ReadLine().Split('-').ToArray();

                entities[input[0]] = decimal.Parse(input[1]);
            }

            List<Costumer> myCostumers = new List<Costumer>();

            decimal totalBill = 0;

            string[] clientOrders = Console.ReadLine().Split(new char[] { ',', '-' }).ToArray();
            while (clientOrders[0] != "end of clients")
            {
                bool exist = false;
                if (entities.ContainsKey(clientOrders[1]))
                {
                    Costumer currentCostumer = new Costumer { Name = clientOrders[0], Orders = new Dictionary<string, int> { { clientOrders[1], int.Parse(clientOrders[2]) } } };
                    currentCostumer.Bill = entities[clientOrders[1]] * int.Parse(clientOrders[2]);
                    for (int i = 0; i < myCostumers.Count; i++)
                    {
                        if (myCostumers[i].Name == currentCostumer.Name)
                        {
                            if (!myCostumers[i].Orders.ContainsKey(clientOrders[1]))
                            {
                                myCostumers[i].Orders.Add(clientOrders[1], int.Parse(clientOrders[2]));
                            }
                            else
                            {
                                myCostumers[i].Orders[clientOrders[1]] += int.Parse(clientOrders[2]);
                            }
                            myCostumers[i].Bill += entities[clientOrders[1]] * int.Parse(clientOrders[2]);
                            totalBill += entities[clientOrders[1]] * int.Parse(clientOrders[2]);
                            exist = true;
                            break;
                        }
                    }
                    if (!exist)
                    {
                        myCostumers.Add(currentCostumer);
                        totalBill += entities[clientOrders[1]] * int.Parse(clientOrders[2]);
                    }
                }

                clientOrders = Console.ReadLine().Split(new char[] { ',', '-' }).ToArray();
            }

            foreach (var client in myCostumers.OrderBy(x => x.Name))
            {
                Console.WriteLine(client.Name);
                foreach (var order in client.Orders)
                {
                    Console.WriteLine($"-- {order.Key} - {order.Value}");
                }
                Console.WriteLine($"Bill: {client.Bill:f2}");
            }
            Console.WriteLine($"Total bill: {totalBill:f2}");
        }
    }
}