using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_2___Beer_Stock
{
    class Program
    {
        static void Main(string[] args)
        {
            long resBeers = int.Parse(Console.ReadLine());
            string shipment = Console.ReadLine();
            long allBeers = 0;
            long end = 0;

            while (shipment != "Exam Over")
            {
                string[] shipmentEll = shipment.Split(' ');
                long amount = long.Parse(shipmentEll[0]);
                string type = shipmentEll[1];

                if (type == "beers")
                {
                    allBeers += amount;
                }
                if (type == "sixpacks")
                {
                    allBeers += amount * 6;
                }
                if (type == "cases")
                {
                    allBeers += amount * 24;
                }
                shipment = Console.ReadLine();
            }

            if (allBeers>=100)
            {
                allBeers = allBeers - (allBeers / 100);
            }
            long test = allBeers;

            if (allBeers>=resBeers)
            {
                long cases = 0;
                long sixpacks = 0;
                long beers = 0;
                end = allBeers - resBeers;
                allBeers = end;
                if (allBeers >= 24 )
                {
                    cases = allBeers / 24;
                    allBeers -= cases*24;
                }
                if (allBeers >= 6)
                {
                    sixpacks = allBeers / 6;
                    allBeers -= sixpacks*6;
                }
                if (allBeers >= 1)
                {
                    beers = allBeers;
                }
                Console.WriteLine("Cheers! Beer left: {0} cases, {1} sixpacks and {2} beers.", cases, sixpacks, beers );
            }
            if (test < resBeers)
            {
                long cases = 0;
                long sixpacks = 0;
                long beers = 0;
                end = resBeers - allBeers;
                allBeers = end;
                if (allBeers >= 24)
                {
                    cases = allBeers / 24;
                    allBeers -= cases * 24;
                }
                if (allBeers >= 6)
                {
                    sixpacks = allBeers / 6;
                    allBeers -= sixpacks * 6;
                }
                if (allBeers >= 1)
                {
                    beers = allBeers;
                }
                Console.WriteLine("Not enough beer. Beer needed: {0} cases, {1} sixpacks and {2} beers.", cases, sixpacks, beers);
            }
        }
    }
}
