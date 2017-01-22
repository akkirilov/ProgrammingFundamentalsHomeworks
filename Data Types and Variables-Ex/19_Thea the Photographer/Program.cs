using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _19_Thea_the_Photographer
{
    class Program
    {
        static void Main(string[] args)
        {
            double picturesAmount = double.Parse(Console.ReadLine());
            double filterTime = double.Parse(Console.ReadLine());
            double filterFactor = double.Parse(Console.ReadLine());
            double uploadTime = double.Parse(Console.ReadLine());

            double time = (picturesAmount * filterTime) + ((Math.Ceiling(picturesAmount * ((filterFactor) / 100))) * uploadTime);
            
            int days, hours, minutes, seconds = 0;


            days = (int)(time / (60*60*24));
            time -= (days * (60 * 60 * 24));
            hours = (int)(time / (60 * 60));
            time -= (hours * (60*60));
            minutes =(int)(time / 60);
            time -= (minutes * 60);
            seconds = (int)time;
            Console.WriteLine($"{days:D2}:{hours:D2}:{minutes:D2}:{seconds:D2}");

        }
    }
}
