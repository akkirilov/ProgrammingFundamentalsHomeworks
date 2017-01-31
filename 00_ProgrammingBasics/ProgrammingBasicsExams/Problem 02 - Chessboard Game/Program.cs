using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_02___Chessboard_Game
{
    class Program
    {
        static void Main(string[] args)
        {
            //33 min.
            int n = int.Parse(Console.ReadLine());
            string line = Console.ReadLine();

            int length = 0;
            if (line.Length <= n * n) 
            {
                length = line.Length;
            }
            else
            {
                length = n * n;
            }

            int black = 0;
            int white = 0;
            char curr;

            for (int i = 0; i < length; i++)
            {
                if ((line[i]>='A'&&line[i]<='Z') || (line[i] >= 'a' && line[i] <= 'z') || (line[i] >= '0' && line[i] <= '9'))
                {
                    curr = line[i];
                }
                else
                {
                    continue;
                }

                if (i % 2 == 0)
                {
                    if (curr >= 'a' && curr <= 'z' || (line[i] >= '0' && line[i] <= '9'))
                    {
                        black += (int)curr;
                    }
                    else if (curr >= 'A' && curr <= 'Z')
                    {
                        white += (int)curr;
                    }
                }
                else if (i % 2 != 0)
                {
                    if (curr >= 'a' && curr <= 'z' || (line[i] >= '0' && line[i] <= '9'))
                    {
                        white += (int)curr;
                    }
                    else if (curr >= 'A' && curr <= 'Z')
                    {
                        black += (int)curr;
                    }
                }
            }

            if (white > black)
            {
                Console.WriteLine("The winner is: white team");
                Console.WriteLine(white - black);
            }
            else if(white < black)
            {
                Console.WriteLine("The winner is: black team");
                Console.WriteLine(black - white);
            }
            else
            {
                Console.WriteLine("Equal result: {0}", black); 
            }
        }
    }
}