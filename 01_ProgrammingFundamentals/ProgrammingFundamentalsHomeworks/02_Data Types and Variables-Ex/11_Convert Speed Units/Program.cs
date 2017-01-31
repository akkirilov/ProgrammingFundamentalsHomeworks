using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _11_Convert_Speed_Units
{
    class Program
    {
        static void Main(string[] args)
        {
            float distanceMeters = float.Parse(Console.ReadLine());
            int hours = int.Parse(Console.ReadLine());
            int minutes = int.Parse(Console.ReadLine());
            int seconds = int.Parse(Console.ReadLine());
            float allSeconds = (hours * 60 * 60) + (minutes * 60) + seconds;

            Console.WriteLine(distanceMeters / allSeconds);
            Console.WriteLine((float)(distanceMeters / 1000) / (float)(allSeconds/60/60));
            Console.WriteLine((float)(distanceMeters / 1609) / (float)(allSeconds / 60 / 60));
        }
    }
}