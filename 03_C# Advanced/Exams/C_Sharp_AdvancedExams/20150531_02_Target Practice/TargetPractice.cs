using System;
using System.Linq;

namespace _20150531_02_Target_Practice
{
    public class TargetPractice
    {
        public static void Main()
        {
            int[] matrixParameters = Console.ReadLine()
                .Split()
                .Select(int.Parse)
                .ToArray();
            int rows = matrixParameters[0];
            int cols = matrixParameters[1];

            string snake = Console.ReadLine();

            char[,] matrix = FillMatrixWithSnakes(rows, cols, snake);

            int[] inpactParameters = Console.ReadLine()
               .Split()
               .Select(int.Parse)
               .ToArray();
            int inpactRow = inpactParameters[0];
            int inpactCol = inpactParameters[1];
            int radius = inpactParameters[2];

            for (int r = 0; r < rows; r++)
            {
                for (int c = 0; c < cols; c++)
                {
                    if (Math.Sqrt(Math.Pow(inpactRow - r, 2) + Math.Pow(inpactCol - c, 2)) <= radius)
                    {
                        matrix[r, c] = ' ';
                    }
                }
            }
           
            for (int c = 0; c < cols; c++)
            {
                for (int r = rows - 1; r >= 0; r--)
                {
                    if (matrix[r, c].Equals(' '))
                    {
                        GettUpper(matrix, r, c);
                    }
                }
            }

            for (int r = 0; r < rows; r++)
            {
                for (int c = 0; c < cols; c++)
                {
                    Console.Write(matrix[r, c]);
                }
                Console.WriteLine();
            }
        }

        public static void GettUpper(char[,] matrix, int r, int c)
        {
            for (int row = r - 1; row >= 0 ; row--)
            {
                if (!matrix[row, c].Equals(' '))
                {
                    matrix[r, c] = matrix[row, c];
                    matrix[row, c] = ' ';
                    break;
                }
            }
        }

        public static char[,] FillMatrixWithSnakes(int rows, int cols, string snake)
        {
            char[,] matrix = new char[rows, cols];
            int s = 0;

            for (int r = rows - 1, lr = 0 ; r >= 0; r--, lr++)
            {
                if (lr % 2 == 0 )
                {
                    for (int c = cols - 1; c >= 0; c--)
                    {
                        matrix[r, c] = (char)snake[s % snake.Length];
                        s++;
                    }
                }
                else
                {
                    for (int c = 0; c < cols; c++)
                    {
                        matrix[r, c] = (char)snake[s % snake.Length];
                        s++;
                    }
                }
            }
            return matrix;
        }
    }
}