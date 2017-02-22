using System;
using System.Linq;

namespace _20150619_01_Bunker_Buster
{
    public class BunkerBuster
    {
        public static void Main()
        {
            int[] matrixParameters = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int rows = matrixParameters[0];
            int cols = matrixParameters[1];

            int[,] matrix = new int[rows, cols];
            for (int r = 0; r < rows; r++)
            {
                int[] rowsEll = Console.ReadLine().Split().Select(int.Parse).ToArray();
                for (int c = 0; c < cols; c++)
                {
                    matrix[r, c] = rowsEll[c];
                }
            }

            string command = Console.ReadLine();
            while (!command.Equals("cease fire!"))
            {
                string[] commandParameters = command.Split().Select(x => x.Trim()).ToArray();
                int impactRow = int.Parse(commandParameters[0]);
                int impactCol = int.Parse(commandParameters[1]);

                char power = char.Parse(commandParameters[2]);
                int damage = (int)(power);

                matrix[impactRow, impactCol] -= (int)damage;

                if (damage % 2 == 1)
                {
                    damage++;
                }
                damage /= 2;

                for (int r = 0; r < rows; r++)
                {
                    if (r == impactRow || impactRow - r == 1 || r - impactRow == 1)
                    {
                        for (int c = 0; c < cols; c++)
                        {
                            if (c == impactCol || c - impactCol == 1 || impactCol - c == 1)
                            {
                                if (r == impactRow && c == impactCol)
                                {
                                    continue;
                                }
                                else
                                {
                                    matrix[r, c] -= damage;
                                }
                            }
                        }
                    }
                }

                command = Console.ReadLine();
            }

            int destroyedBunkers = 0;
            for (int r = 0; r < rows; r++)
            {
                for (int c = 0; c < cols; c++)
                {
                    if (matrix[r, c] <= 0)
                    {
                        destroyedBunkers++;
                    }
                }
            }

            Console.WriteLine($"Destroyed bunkers: {destroyedBunkers}");
            double tottalDamage = ((double)destroyedBunkers / (rows * cols)) * 100;
            Console.WriteLine($"Damage done: {tottalDamage:f1} %");
        }
    }
}