using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _20160911_03_Portal
{
    class Portal
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            char[,] room = new char[n, n];
            int startRow = 0;
            int startCol = 0;
            int turnsCounter = 0;

            for (int row = 0; row < n; row++)
            {
                char[] input = Console.ReadLine().ToUpper().ToCharArray();
                for (int col = 0; col < input.Length; col++)
                {
                    room[row, col] = input[col];
                    if (input[col] == 'S')
                    {
                        startRow = row;
                        startCol = col;
                    }
                }
            }

            char[] commands = Console.ReadLine().ToUpper().ToCharArray();

            for (int i = 0; i < commands.Length; i++)
            {
                switch (commands[i])
                {
                    case 'U':
                        for (int row = (startRow - 1 >= 0 ? startRow - 1 : n - 1); row >= 0; row--)
                        {
                            if (char.IsLetter(room[row, startCol]))
                            {
                                startRow = row;
                                if (room[row, startCol] == 'E')
                                {
                                    Console.WriteLine($"Experiment successful. {turnsCounter} turns required.");
                                    return;
                                }
                                turnsCounter++;
                            }
                            if (row == 0)
                            {
                                row = n - 1;
                            }
                        }
                        break;
                    case 'D':
                        for (int row = (startRow + 1 <= n - 1 ? startRow + 1 : 0); row < n; row++)
                        {
                            if (char.IsLetter(room[row, startCol]))
                            {
                                startRow = row;
                                if (room[row, startCol] == 'E')
                                {
                                    Console.WriteLine($"Experiment successful. {turnsCounter} turns required.");
                                    return;
                                }
                                turnsCounter++;
                            }
                            if (row == n - 1)
                            {
                                row = 0;
                            }
                        }
                        break;
                    case 'R':
                        for (int col = (startCol + 1 <= n - 1 ? startRow + 1 : 0); col < n; col++)
                        {
                            if (char.IsLetter(room[startRow, col]))
                            {
                                startCol = col;
                                if (room[startRow, col] == 'E')
                                {
                                    Console.WriteLine($"Experiment successful. {turnsCounter} turns required.");
                                    return;
                                }
                                turnsCounter++;
                            }
                            if (col == n - 1)
                            {
                                col = 0;
                            }
                        }
                        break;
                    case 'L':
                        for (int col = (startCol - 1 >= 0 ? startRow - 1 : n - 1); col >= 0; col--)
                        {
                            if (char.IsLetter(room[startRow, col]))
                            {
                                startCol = col;
                                if (room[startRow, col] == 'E')
                                {
                                    Console.WriteLine($"Experiment successful. {turnsCounter} turns required.");
                                    return;
                                }
                                turnsCounter++;
                            }
                            if (col == 0)
                            {
                                col = n - 1;
                            }
                        }
                        break;
                }
            }

            Console.WriteLine();

            //for (int i = 0; i < n; i++)
            //{
            //    for (int j = 0; j < n; j++)
            //    {
            //        Console.Write(room[i,j] + " ");
            //    }
            //    Console.WriteLine();
            //}

        }
    }
}