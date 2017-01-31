using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_02___Cheat_Sheet
{
    class Program
    {
        static void Main(string[] args)
        {
            //35 min.
            int rows = int.Parse(Console.ReadLine());
            int cols = int.Parse(Console.ReadLine());
            long rowsStart = long.Parse(Console.ReadLine());
            long colsStart = long.Parse(Console.ReadLine());
            long [,] matrix = new long[rows,cols];

            for (int i = 0; i < rows; i++)
            {
                long currRow = rowsStart + i;
                for (int j = 0; j < cols; j++)
                {
                    long currCol = colsStart + j;
                    matrix[i,j] = currCol * currRow;
                }
            }

            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < cols; j++)
                {
                    Console.Write(matrix[i, j] + " ");
                }
                Console.WriteLine();
            }
        }
    }
}