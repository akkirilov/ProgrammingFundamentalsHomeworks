using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03_21_CatTom
{
    class Program
    {
        static void Main(string[] args)
        {
            int dayOff = int.Parse(Console.ReadLine());
            int workDays = 365 - dayOff;
            int playTimeDayOff = dayOff * 127;
            int playTimeWorkDays = workDays * 63;
            int playTimeAll = playTimeDayOff + playTimeWorkDays;
            int normPlay =  30000;
            
            if (playTimeAll > normPlay)
            {
                int h = (playTimeAll - normPlay) / 60;
                int m = (playTimeAll - normPlay) - (h * 60);
                Console.WriteLine("Tom will run away");
                Console.WriteLine("{0} hours and {1} minutes more for play", h , m);
            }
            if (playTimeAll < normPlay)
            {
                int h = (normPlay- playTimeAll) / 60;
                int m = (normPlay - playTimeAll) - (h * 60);
                Console.WriteLine("Tom will sleep well");
                Console.WriteLine("{0} hours and {1} minutes less for play", h, m);
            }
        }
    }
}
