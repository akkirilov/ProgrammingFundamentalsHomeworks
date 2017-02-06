using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _20160612_04_Trifon_s_Quest
{
    class Program
    {
        static void Main(string[] args)
        {
            int health = int.Parse(Console.ReadLine());
            int[] coordinates = Console.ReadLine().Split().Select(int.Parse).ToArray();

            int[,] map = new int[coordinates[0], coordinates[1]];
            int col = 0;
            int turn = 1;
            while (true)
            {
                char[] input = Console.ReadLine().ToUpper().ToCharArray();
                if (col % 2 == 0)
                {
                    for (int i = 0; i < input.Length; i++)
                    {
                        switch (input[i])
                        {
                            case 'F':
                                health /= turn;
                                turn++;
                                break;
                            case 'H':
                                health += (health / turn);
                                turn++;
                                break;
                                case 'E':
                                turn++;
                                break;
                            case 'T':
                                if (input.Length - i - 1 >=2 )
                                {
                                    i += 2;
                                    turn += 2;
                                }
                                break;
                        }
                    }
                }
                else
                {
                    for (int i = input.Length - 1; i >= 0; i--)
                    {
                        switch (input[i])
                        {
                            case 'F':
                                break;
                            case 'H':
                                break;
                            case 'T':
                                break;
                            case 'E':
                                break;
                        }
                    }
                }
                

                col++;
            }

        }
    }
}