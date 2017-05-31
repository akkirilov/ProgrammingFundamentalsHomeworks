using System;
using System.Linq;

namespace _20151011_02_Radioactive_Bunnies
{
    public class RadioactiveBunnies
    {
        public static bool dead = false;
        public static bool won = false;
        public static int currentRow = -1;
        public static int currentCol = -1;
        public static int rows = 0;
        public static int cols = 0;

        public static void Main()
        {
            int[] lairParameters = Console.ReadLine()
                .Split()
                .Select(int.Parse)
                .ToArray();
            rows = lairParameters[0];
            cols = lairParameters[1];

            char[,] lair = new char[rows, cols];
            for (int r = 0; r < rows; r++)
            {
                char[] tempRow = Console.ReadLine().ToCharArray();
                for (int c = 0; c < cols; c++)
                {
                    lair[r, c] = tempRow[c];

                    if (tempRow[c].Equals('P'))
                    {
                        currentRow = r;
                        currentCol = c;
                    }
                }
            }

            char[] directions = Console.ReadLine().ToCharArray();

            for (int i = 0; i < directions.Length; i++)
            {
                switch (directions[i])
                {
                    case 'U':
                        GoUp(lair);
                        break;
                    case 'D':
                        GoDown(lair);
                        break;
                    case 'L':
                        GoLeft(lair);
                        break;
                    case 'R':
                        GoRight(lair);
                        break;
                }

                if (won || dead)
                {
                    break;
                }
            }

            string status = "won";
            if (dead)
            {
                status = "dead";
            }

            PrintLair(lair);
            Console.WriteLine($"{status}: {currentRow} {currentCol}");
        }

        public static void GoRight(char[,] lair)
        {
            lair[currentRow, currentCol] = '.';
            currentCol += 1;

            if (currentCol == cols)
            {
                won = true;
                currentCol -= 1;
            }
            else
            {
                MoveOrDie(lair);
            }

            BunniesMultiply(lair);
        }

        public static void GoLeft(char[,] lair)
        {
            lair[currentRow, currentCol] = '.';
            currentCol -= 1;

            if (currentCol < 0)
            {
                won = true;
                currentCol += 1;
            }
            else
            {
                MoveOrDie(lair);
            }

            BunniesMultiply(lair);
        }

        public static void GoDown(char[,] lair)
        {
            lair[currentRow, currentCol] = '.';
            currentRow += 1;

            if (currentRow == rows)
            {
                won = true;
                currentRow -= 1;
            }
            else
            {
                MoveOrDie(lair);
            }

            BunniesMultiply(lair);
        }

        public static void GoUp(char[,] lair)
        {
            lair[currentRow, currentCol] = '.';
            currentRow -= 1;

            if (currentRow < 0)
            {
                won = true;
                currentRow += 1;
            }
            else
            {
                MoveOrDie(lair);
            }

            BunniesMultiply(lair);
        }

        public static void BunniesMultiply(char[,] lair)
        {
            char[,] multiply = new char[rows, cols];
            for (int r = 0; r < rows; r++)
            {
                for (int c = 0; c < cols; c++)
                {
                    if (lair[r, c] == 'B')
                    {
                        if (r > 0)
                        {
                            multiply[r - 1, c] = 'B';
                        }
                        if (r < rows - 1)
                        {
                            multiply[r + 1, c] = 'B';
                        }
                        if (c > 0)
                        {
                            multiply[r, c - 1] = 'B';
                        }
                        if (c < cols - 1)
                        {
                            multiply[r, c + 1] = 'B';
                        }
                    }
                }
            }

            for (int r = 0; r < rows; r++)
            {
                for (int c = 0; c < cols; c++)
                {
                    if (multiply[r, c] == 'B')
                    {
                        if (lair[r, c] == 'P')
                        {
                            dead = true;
                        }

                        lair[r, c] = 'B';
                    }
                }
            }
        }

        public static void MoveOrDie(char[,] lair)
        {
            if (lair[currentRow, currentCol] == 'B')
            {
                dead = true;
            }
            else
            {
                lair[currentRow, currentCol] = 'P';
            }
        }

        public static void PrintLair(char[,] lair)
        {
            for (int r = 0; r < rows; r++)
            {
                for (int c = 0; c < cols; c++)
                {
                    Console.Write(lair[r, c]);
                }
                Console.WriteLine();
            }
        }
    }
}