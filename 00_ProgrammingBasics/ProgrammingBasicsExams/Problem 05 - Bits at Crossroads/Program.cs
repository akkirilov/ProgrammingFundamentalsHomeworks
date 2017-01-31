using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_05___Bits_at_Crossroads
{
    class Program
    {
        static void Main(string[] args)
        {
            //1537
            int size = int.Parse(Console.ReadLine());
            string command = Console.ReadLine();
            
            int count = 0;
            uint[] table = new uint[size];

            while (command != "end")
            {
                string[] commandEll = command.Split(' ');
                int[] rows = new int[commandEll.Length / 2];
                int[] cols = new int[commandEll.Length / 2];
                int arrCount = 0;
                for (int i = 0; i < commandEll.Length-1; i+=2)
                {
                    count++;
                    rows[arrCount] = int.Parse(commandEll[i]);
                    cols[arrCount] = int.Parse(commandEll[i+1]);
                    int colLeft = cols[arrCount];
                    int colRight = cols[arrCount];
                    table[rows[arrCount]] = table[rows[arrCount]] | (1u << cols[arrCount]);
                    for (int j = rows[arrCount] - 1; j >= 0; j--)
                    {
                        colRight--;
                        colLeft++;
                        if (colLeft < size)
                        {
                            if ((table[j] >> colLeft & 1u)== 1u)
                            {
                                count++;
                            }
                            table[j] = table[j] | (1u << colLeft);
                        }
                        if (colRight >= 0)
                        {
                            if ((table[j] >> colRight & 1u) == 1u)
                            {
                                count++;
                            }
                            table[j] = table[j] | (1u << colRight);
                        }
                    }
                    colLeft = cols[arrCount];
                    colRight = cols[arrCount];
                    for (int k = rows[arrCount] + 1; k < size; k++)
                    {
                        colRight--;
                        colLeft++;
                        if (colLeft < size)
                        {
                            if ((table[k] >> colLeft & 1u) == 1u)
                            {
                                count++;
                            }
                            table[k] = table[k] | (1u << colLeft);
                        }
                        if (colRight >= 0)
                        {
                            if ((table[k] >> colRight & 1u) == 1u)
                            {
                                count++;
                            }
                            table[k] = table[k] | (1u << colRight);
                        }
                    }
                    arrCount++;
                }
                command = Console.ReadLine();
            }

            foreach (var item in table)
            {
                //Console.WriteLine(Convert.ToString(item,2).PadLeft(size, '0'));
                Console.WriteLine(item);
            }
            Console.WriteLine(count);
        }
    }
}