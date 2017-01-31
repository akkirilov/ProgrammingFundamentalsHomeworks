using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_02___Dream_Item
{
    class Program
    {
        static void Main(string[] args)
        {
            //30 min.
            string line = Console.ReadLine();
            string[] lineEll = line.Split('\\');
            string m = lineEll[0];
            decimal moneyPerHour = decimal.Parse(lineEll[1]);
            int hourPerDay = int.Parse(lineEll[2]);
            decimal itemPrice = decimal.Parse(lineEll[3]);
            int workDays = 20;
            decimal all = 0m;

            if ((m == "Jan") || (m == "March") || (m == "May") || (m == "July") || (m == "Aug") || (m == "Oct") || (m == "Dec"))
            {
                workDays = 21;
            }
            else if (m == "Feb")
            {
                workDays = 18;
            }

            all = workDays * (moneyPerHour * hourPerDay);
            if (all > 700)
            {
                all *= 1.1m;
            }

            if (all >= itemPrice) 
            {
                Console.WriteLine("Money left = {0:f2} leva.", all-itemPrice);
            }
            else
            {
                Console.WriteLine("Not enough money. {0:f2} leva needed.", itemPrice - all);
            }
        }
    }
}