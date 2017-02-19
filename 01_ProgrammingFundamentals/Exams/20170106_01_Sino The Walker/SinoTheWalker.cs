using System;
namespace _20170106_01_Sino_The_Walker
{
    public class SinoTheWalker
    {
        public static void Main()
        {
            TimeSpan startTime = TimeSpan.Parse(Console.ReadLine());
            int steps = int.Parse(Console.ReadLine()) % 86400;
            int stepTime = int.Parse(Console.ReadLine()) % 86400;

            double sumStep = steps * stepTime;
            TimeSpan time = TimeSpan.FromSeconds(sumStep);

            TimeSpan endTime = startTime + time;
            Console.WriteLine("Time Arrival: {0:D2}:{1:D2}:{2:D2}", endTime.Hours,endTime.Minutes,endTime.Seconds);
        }
    }
}