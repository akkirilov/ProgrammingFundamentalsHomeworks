using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07_Sales_Report
{
    class SalesReport
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            List<Sale> salesList = new List<Sale>();

            for (int i = 0; i < n; i++)
            {
                string[] input = Console.ReadLine().Split().ToArray();
                salesList.Add(new Sale { Town = input[0], Product = input[1], Price = decimal.Parse(input[2]), Quantity = decimal.Parse(input[3]) });
            }

            SortedDictionary<string, decimal> salesReport = new SortedDictionary<string, decimal>();

            for (int i = 0; i < salesList.Count; i++)
            {
                if (!salesReport.ContainsKey(salesList[i].Town))
                {
                    salesReport[salesList[i].Town] = (salesList[i].Price * salesList[i].Quantity);
                    continue;
                }
                salesReport[salesList[i].Town] += (salesList[i].Price * salesList[i].Quantity);
            }

            foreach (var sale in salesReport)
            {
                Console.WriteLine($"{sale.Key} -> {sale.Value:f2}");
            }
        }
    }
}