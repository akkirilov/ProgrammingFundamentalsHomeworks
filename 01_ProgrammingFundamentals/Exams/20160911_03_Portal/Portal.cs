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
            int rowLength = int.Parse(Console.ReadLine());
            List<char[]> rows = new List<char[]>();
            int colLength = 0;
            for (int i = 0; i < rowLength; i++)
            {
                char[] input = Console.ReadLine().ToUpper().ToCharArray();
                rows.Add(input);
                if (input.Length > colLength)
                {
                    colLength = input.Length;
                }
            }

            char[,] room = new char[rowLength, colLength];
            int currentRow = 0;
            int currentCol = 0;
            int turnsCounter = 0;

            for (int row = 0; row < rowLength; row++)
            {
                for (int col = 0; col < colLength; col++)
                {
                    if (rows[row].Length > col )
                    {
                        room[row, col] = rows[row][col];
                        if (rows[row][col] == 'S')
                        {
                            currentRow = row;
                            currentCol = col;
                        }
                    }
                    else
                    {
                        room[row, col] = 'X';
                    }
                }
            }

            char[] commands = Console.ReadLine().ToUpper().ToCharArray();

            for (int i = 0; i < commands.Length; i++)
            {
                switch (commands[i])
                {
                    case 'U':
                        while (true)
                        {
                            currentRow--;
                            if (currentRow < 0)
                            {
                                currentRow = rowLength - 1;
                            }
                            if (room[currentRow, currentCol] != 'X')
                            {
                                turnsCounter++;
                                if (room[currentRow, currentCol] == 'E')
                                {
                                    Console.WriteLine($"Experiment successful. {turnsCounter} turns required.");
                                    return;
                                }
                                break;
                            }
                        }
                        break;
                    case 'D':
                        while (true)
                        {
                            currentRow++;
                            if (currentRow > rowLength - 1)
                            {
                                currentRow = 0;
                            }
                            if (room[currentRow, currentCol] != 'X')
                            {
                                turnsCounter++;
                                if (room[currentRow, currentCol] == 'E')
                                {
                                    Console.WriteLine($"Experiment successful. {turnsCounter} turns required.");
                                    return;
                                }
                                break;
                            }
                        }
                        break;
                    case 'R':
                        while (true)
                        {
                            currentCol++;
                            if (currentCol > colLength - 1)
                            {
                                currentCol = 0;
                            }

                            if (room[currentRow, currentCol] != 'X')
                            {
                                turnsCounter++;
                                if (room[currentRow, currentCol] == 'E')
                                {
                                    Console.WriteLine($"Experiment successful. {turnsCounter} turns required.");
                                    return;
                                }
                                break;
                            }
                        }
                        break;
                    case 'L':
                        while (true)
                        {
                            currentCol--;
                            if (currentCol < 0)
                            {
                                currentCol = colLength - 1;
                            }
                            if (room[currentRow, currentCol] != 'X')
                            {
                                turnsCounter++;
                                if (room[currentRow, currentCol] == 'E')
                                {
                                    Console.WriteLine($"Experiment successful. {turnsCounter} turns required.");
                                    return;
                                }
                                break;
                            }
                        }
                        break;
                }
            }
            
            Console.WriteLine($"Robot stuck at {currentRow} {currentCol}. Experiment failed.");
        }
    }
}