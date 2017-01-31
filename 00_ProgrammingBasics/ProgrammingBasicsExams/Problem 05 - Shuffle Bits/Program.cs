using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_05___Shuffle_Bits
{
    class Program
    {
        static void Main(string[] args)
        {
            //4:00
            uint a = uint.Parse(Console.ReadLine());
            uint b = uint.Parse(Console.ReadLine());
            ulong num = 0;
            int bitMove = 63;

            if (a>=b)
            {
                for (int i = 31; i >= 0; i--)
                {
                    num = num | (a >> i & 1) << bitMove;
                    bitMove--;

                    num = num | (b >> i & 1) << bitMove;
                    bitMove--;
                }
            }
            else 
            {
                for (int i = 31; i >= 0; i -=2)
                {
                    num = num | (((a >> (i)) & 1) << bitMove);
                    bitMove--;

                    num = num | (((a >> (i-1)) & 1) << bitMove);
                    bitMove--;

                    num = num | (((b >> (i)) & 1) << bitMove);
                    bitMove--;

                    num = num | (((b >> (i - 1)) & 1) << bitMove);
                    bitMove--;
                }
            }
            Console.WriteLine(num);
        }
    }
}