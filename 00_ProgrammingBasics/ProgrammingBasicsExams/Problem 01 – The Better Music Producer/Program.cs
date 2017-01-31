using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_01___The_Better_Music_Producer
{
    class Program
    {
        static void Main(string[] args)
        {
            //21 min
            int soldEurope = int.Parse(Console.ReadLine());
            decimal priceEuro = (1.94m * decimal.Parse(Console.ReadLine())) * soldEurope;
            int soldNorthAmerica = int.Parse(Console.ReadLine());
            decimal priceNorthAmerica = (1.72m * decimal.Parse(Console.ReadLine())) * soldNorthAmerica;
            int soldSouthAmerica = int.Parse(Console.ReadLine());
            decimal priceSouthAmerica = (decimal.Parse(Console.ReadLine()) / 332.74m) * soldSouthAmerica;
            int numberConcerts = int.Parse(Console.ReadLine());
            decimal priceConcert = (1.94m * decimal.Parse(Console.ReadLine())) * numberConcerts;

            decimal proffitFromAlbums = priceEuro + priceNorthAmerica + priceSouthAmerica;
            proffitFromAlbums = (proffitFromAlbums * 0.65m) * 0.80m;

            decimal proffitFromConcerts = priceConcert;
            if (proffitFromConcerts > 100000m)
            {
                proffitFromConcerts *= 0.85m; 
            }

            if (proffitFromAlbums > proffitFromConcerts)
            {
                Console.WriteLine("Let's record some songs! They'll bring us {0:f2}lv.", (proffitFromAlbums));
            }
            else
            {
                Console.WriteLine("On the road again! We'll see the world and earn {0:f2}lv.", (proffitFromConcerts));
            }
        }
    }
}