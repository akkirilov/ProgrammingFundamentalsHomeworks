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
            long picturesAmount = long.Parse(Console.ReadLine());
            double filterTime = double.Parse(Console.ReadLine());
            double filterFactor = double.Parse(Console.ReadLine());
            double uploadTime = double.Parse(Console.ReadLine());

            long time = (long)(((long)(picturesAmount * filterTime) +(long)((long)(Math.Ceiling(picturesAmount * (filterFactor / 100))) * uploadTime)));

            long days = 0;
            int hours, minutes, seconds = 0;

            days = (long)(time / (60 * 60 * 24));
            time -= (long)(days * (60 * 60 * 24));
            hours = (int)(time / (60 * 60));
            time -= (hours * (60 * 60));
            minutes =(int)(time / 60);
            time -= (minutes * 60);
            seconds = (int)time;

            Console.WriteLine($"{days}:{hours:D2}:{minutes:D2}:{seconds:D2}");
        }
    }
}