using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03_16_TimePlus15
{
    class Program
    {
        static void Main(string[] args)
        {
            int hour = int.Parse(Console.ReadLine());
            int minuts = int.Parse(Console.ReadLine());

            if (minuts>44)
            {
                hour += 1;
                minuts -= 45;
                
                if (hour==24)
                {
                    hour = 0;
                }
                Console.WriteLine("{0}:{1:00}",hour, minuts);
            }
            else
            {
                minuts += 15;
                Console.WriteLine("{0}:{1:00}", hour, minuts);
            }

        }
    }
}
