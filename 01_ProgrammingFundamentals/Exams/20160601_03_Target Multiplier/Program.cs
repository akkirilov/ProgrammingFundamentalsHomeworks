using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _20160601_03_Target_Multiplier
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] RowsColumns = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int[,] matrix = new int[RowsColumns[0], RowsColumns[1]];

            for (int i = 0; i < RowsColumns[0]; i++)
            {
                int[] rows = Console.ReadLine().Split().Select(int.Parse).ToArray();

                for (int j = 0; j < RowsColumns[1]; j++)
                {
                    matrix[i, j] = rows[j];
                }
            }

            int[] targetRowColumn = Console.ReadLine().Split().Select(int.Parse).ToArray();

            int targetNumber = matrix[targetRowColumn[0], targetRowColumn[1]];
            int startRow = (targetRowColumn[0] == 0 ? 0 : (targetRowColumn[0] - 1));
            int endRow = (targetRowColumn[0] == RowsColumns[0] - 1 ? RowsColumns[0] - 1 
                : (targetRowColumn[0] + 1));
            int startCol = (targetRowColumn[1] == 0 ? 0 : (targetRowColumn[1] - 1));
            int endCol = (targetRowColumn[1] == RowsColumns[1] - 1 ? RowsColumns[1] - 1 
                : (targetRowColumn[1] + 1));
            int neighborsSum = 0;

            for (int i = startRow; i <= endRow; i++)
            {
                for (int j = startCol; j <= endCol; j++)
                {
                    neighborsSum += matrix[i, j];
                }
            }

            neighborsSum -= targetNumber;
            matrix[targetRowColumn[0], targetRowColumn[1]] = neighborsSum * targetNumber;

            for (int i = startRow; i <= endRow; i++)
            {
                for (int j = startCol; j <= endCol; j++)
                {
                    if (i == targetRowColumn[0] && j == targetRowColumn[1])
                    {
                        continue;
                    }
                    matrix[i, j] *= targetNumber;
                }
            }

            for (int i = 0; i < RowsColumns[0]; i++)
            {
                for (int j = 0; j < RowsColumns[1]; j++)
                {
                    Console.Write(matrix[i, j] + " ");
                }
                Console.WriteLine();
            }
        }
    }
}