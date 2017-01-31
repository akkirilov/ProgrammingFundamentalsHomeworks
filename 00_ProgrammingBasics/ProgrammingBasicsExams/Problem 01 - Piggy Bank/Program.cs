using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_01___Piggy_Bank
{
    class Program
    {
        static void Main(string[] args)
        {
            //26 min.
            uint tankPrice = uint.Parse(Console.ReadLine());
            int partyDays = int.Parse(Console.ReadLine());
            double savingMoney = (30 - partyDays) * 2;
            double partyMoney = 5 * partyDays;
            double avarrageMoney = savingMoney - partyMoney;

            if (avarrageMoney <= 0)
            {
                Console.WriteLine("never");
                return;
            }

            double years = Math.Floor((tankPrice / avarrageMoney) / 12);
            double mounths = Math.Ceiling((tankPrice / avarrageMoney) % 12);

            if (mounths==12)
            {
                years++;
                mounths = 0;
            }

            Console.WriteLine("{0} years, {1} months", years,mounths);
        }
    }
}