using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem__02___Ani_is_drunk
{
    class Program
    {
        static void Main(string[] args)
        {
            //02:30
            uint cabins = uint.Parse(Console.ReadLine());
            string line = Console.ReadLine();
            ulong stepsCount = 0;
            uint currentPossition = 1;

            while (line != "Found a free one!")
            {
                uint steps = uint.Parse(line);

                if (steps % cabins == 0)
                {
                    Console.WriteLine("Stay there, Ani.");
                }

                else if (steps % cabins != 0)
                {
                    if (steps % cabins <= (cabins - currentPossition))
                    {

                        Console.WriteLine("Go {0} steps to the right, Ani.", steps % cabins);
                        currentPossition = (currentPossition + (steps % cabins));
                        stepsCount += (steps % cabins);

                    }
                    else if (((steps % cabins) > cabins - currentPossition))
                    {
                        Console.WriteLine("Go {0} steps to the left, Ani.", cabins - (steps % cabins));
                        currentPossition -= (cabins - (steps % cabins));
                        stepsCount += (cabins - (steps % cabins));
                    }
                }
                line = Console.ReadLine();
            }
            Console.WriteLine("Moved a total of {0} steps.", stepsCount);
        }
    }
}