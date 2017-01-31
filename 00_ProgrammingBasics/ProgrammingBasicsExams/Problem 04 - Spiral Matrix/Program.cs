using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_04___Spiral_Matrix
{
    class Program
    {
        static void Main(string[] args)
        {
            //126 min.
            int n = int.Parse(Console.ReadLine());
            string line = Console.ReadLine().ToLower();
            int[,] charsWeight = new int[n, n];

            int startRow = 0;
            int startCol = 0;
            int endRow = n - 1;
            int endCol = n - 1;
            int count = 0;

            int countBest = int.MinValue;
            int rowBest = 0;

            while (startCol <= endCol)
            {
                for (int j = startCol; j <= endCol; j++)
                {
                    if (count >= line.Length)
                    {
                        count = 0;
                    }
                    charsWeight[startRow, j] = (line[count] - 'a' + 1) * 10;
                    count++;
                }
                startRow++;
                
                for (int j = startRow; j <= endRow; j++)
                {
                    if (count >= line.Length)
                    {
                        count = 0;
                    }
                    charsWeight[j, endCol] = (line[count] - 'a' + 1) * 10;
                    count++;
                }
                endCol--;
                
                for (int j = endCol; j >= startCol; j--)
                {
                    if (count >= line.Length)
                    {
                        count = 0;
                    }
                    charsWeight[endRow, j] = (line[count] - 'a' + 1) * 10;
                    count++;
                }
                endRow--;
                
                for (int j = endRow; j >= startRow; j--)
                {
                    if (count >= line.Length)
                    {
                        count = 0;
                    }
                    charsWeight[j, startCol] = (line[count] - 'a' + 1) * 10;
                    count++;
                }
                startCol++;
            }

            count = 0;
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    int curr = charsWeight[i, j];
                    count += curr;
                }
                if (count > countBest)
                {
                    countBest = count;
                    rowBest = i;
                }
                count = 0;
            }
            Console.WriteLine("{0} - {1}", rowBest, countBest);

            //for (int i = 0; i < n; i++)
            //{
            //    for (int j = 0; j < n; j++)
            //    {
            //        Console.Write(chars[i, j] + " ");
            //    }
            //    Console.WriteLine();
            //}
        }
    }
}