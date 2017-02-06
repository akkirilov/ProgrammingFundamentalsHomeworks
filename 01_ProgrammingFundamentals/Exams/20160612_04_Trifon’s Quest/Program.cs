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
            long health = long.Parse(Console.ReadLine());

            int[] coordinates = Console.ReadLine().Split().Select(int.Parse).ToArray();

            char[,] map = InicializeArray(coordinates[0], coordinates[1]);

            int turnsCount = 0;
            for (int col = 0; col < coordinates[1]; col++)
            {
                if (col % 2 == 0)
                {
                    for (int row = 0; row < coordinates[0]; row++)
                    {
                        switch (map[row, col])
                        {
                            case 'F':
                                health -= (turnsCount / 2);
                                if (health <= 0)
                                {
                                    Console.WriteLine($"Died at: [{row}, {col}]");
                                    return;
                                }
                                break;
                            case 'H':
                                health += (turnsCount / 3);
                                break;
                            case 'T':
                                turnsCount += 2;
                                break;
                        }
                        turnsCount++;
                    }
                }
                if (col % 2 == 1)
                {
                    for (int row = coordinates[0] - 1; row >= 0; row--)
                    {
                        switch (map[row, col])
                        {
                            case 'F':
                                health -= (turnsCount / 2);
                                if (health <= 0)
                                {
                                    Console.WriteLine($"Died at: [{row}, {col}]");
                                    return;
                                }
                                break;
                            case 'H':
                                health += (turnsCount / 3);
                                break;
                            case 'T':
                                turnsCount += 2;
                                break;
                        }
                        turnsCount++;
                    }
                }
            }

            Console.WriteLine("Quest completed!");
            Console.WriteLine($"Health: {health}");
            Console.WriteLine($"Turns: {turnsCount}");
        }

        private static char[,] InicializeArray(int row, int col)
        {
            char[,] temp = new char[row, col];

            for (int i = 0; i < row; i++)
            {
                char[] input = Console.ReadLine().ToUpper().ToCharArray();

                for (int j = 0; j < col; j++)
                {
                    temp[i, j] = input[j];
                }
            }

            return temp;
        }
    }
}