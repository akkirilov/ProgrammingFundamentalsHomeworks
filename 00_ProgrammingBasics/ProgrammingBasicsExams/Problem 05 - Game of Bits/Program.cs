using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_05___Game_of_Bits
{
    class Program
    {
        static void Main(string[] args)
        {
            //19 min.
            uint number = uint.Parse(Console.ReadLine());
            string line = Console.ReadLine();
            
            while (line != "Game Over!")
            {
                uint temp = 0u;
                int bitMove = 0;

                int oddEven = 0;
                if (line == "Even")
                {
                    oddEven = 1;
                }

                for (int i = oddEven; i < 32; i+=2)
                {
                    if ((number >> i & 1) == 1)
                    {
                        temp |= 1u << bitMove;
                    }
                    bitMove++;
                }

                number = temp;
                line = Console.ReadLine();
            }

            int countOne = 0;
            for (int i = 0; i < 32; i++)
            {
                if ((number >> i & 1) == 1)
                {
                    countOne++;
                }
            }
            //Console.WriteLine(Convert.ToString(number,2).PadLeft(32,'0'));
            Console.WriteLine("{0} -> {1}", number, countOne);
        }
    }
}