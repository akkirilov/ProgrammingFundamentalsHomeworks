using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03_08_SumSeconds
{
    class Program
    {
        static void Main(string[] args)
        {
            int time1 = int.Parse(Console.ReadLine());
            int time2 = int.Parse(Console.ReadLine());
            int time3 = int.Parse(Console.ReadLine());
            int seconds = 0;
            int minuts = 0;

            minuts = (time1 + time2 + time3) / 60;
            seconds = ((time1 + time2 + time3) - (minuts*60));
            
            Console.WriteLine("{0}:{1:00}", minuts, seconds);
        }
    }
}
