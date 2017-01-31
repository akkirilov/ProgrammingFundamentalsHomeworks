using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_05___Game_of_Life
{
    class Program
    {
        static void Main(string[] args)
        {
            // Ne moga
            int n = int.Parse(Console.ReadLine());
            int[] rowsArr = new int[10];
            int[] colsArr = new int[10];
            int countLives = 0;

            for (int i = 0; i < n; i++)
            {
                int row = int.Parse(Console.ReadLine());
                int col = int.Parse(Console.ReadLine());
                rowsArr[row] = 0 | (1 << col);
                colsArr[row] = col;
            }
        }
    }
}