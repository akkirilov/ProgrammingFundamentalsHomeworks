using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_01___Torrent_Pirate
{
    class Program
    {
        static void Main(string[] args)
        {
            //18 min.
            double data = int.Parse(Console.ReadLine());
            double moviePrice = int.Parse(Console.ReadLine());
            int wifeSpend = int.Parse(Console.ReadLine());

            double totalDownloadTime = 0;
            totalDownloadTime = data / 2 / 60 / 60;
            double totalWifeSpend = wifeSpend * totalDownloadTime;
            double cinemaPrice = (data / 1500) * moviePrice;

            if (totalWifeSpend <= cinemaPrice)
            {
                Console.WriteLine("mall -> {0:f2}lv", (totalWifeSpend));
            }
            else
            {
                Console.WriteLine("cinema -> {0:f2}lv", cinemaPrice);
            }
        }
    }
}