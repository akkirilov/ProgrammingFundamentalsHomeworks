using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_05___Emergency_Repairs
{
    class Program
    {
        static void Main(string[] args)
        {

            ulong wall = ulong.Parse(Console.ReadLine());
            uint emergencyKits = uint.Parse(Console.ReadLine());
            uint numberOfAttack = uint.Parse(Console.ReadLine());
            
            for (int i = 0; i < numberOfAttack; i++)
            {
                int attackedBit = int.Parse(Console.ReadLine());
                wall = wall & ~((ulong)1 << attackedBit);
            }

            for (int i = 0; i < 64; i++)
            {
                while ((emergencyKits > 0) && 
                    (((wall >> i) & 1) == 0) &&
                    (((wall >> (i+1)) & 1) == 0) &&
                    (i + 1 <= 64))
                {
                    wall = wall | ((ulong)1 << i);
                    emergencyKits--;

                    if (emergencyKits>0)
                    {
                        emergencyKits--;
                        wall = wall | ((ulong)1 << (i+1));
                        i++;

                        if ((((wall >> (i + 1)) & 1) == 0))
                        {
                            i--;
                        }
                    }
                }
            }
            Console.WriteLine(wall);
        }
    }
}
