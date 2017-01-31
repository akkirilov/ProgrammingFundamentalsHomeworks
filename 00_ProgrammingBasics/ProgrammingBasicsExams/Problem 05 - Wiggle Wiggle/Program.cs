using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_05___Wiggle_Wiggle
{
    class Program
    {
        static void Main(string[] args)
        {
            //67 p.
            //Console.WriteLine((18446744037190582545<<1)>>1);
            string line = Console.ReadLine();
            string[] lineEll = line.Split(' ');
            long[] n = new long[lineEll.Length];
            for (int i = 0; i < lineEll.Length; i++)
            {
                n [i] = long.Parse(lineEll[i]);
            }

            long n1 = 0;
            long n2 = 0;
            long b1 = 0;
            long b2 = 0;
            //Console.WriteLine(Convert.ToString((long)n[0], 2).PadLeft(64, '0'));
            //Console.WriteLine(Convert.ToString((long)n[1], 2).PadLeft(64, '0'));

            for (int i = 0; i < lineEll.Length-1; i+=2)
            {
                n1 = n[i];
                n2 = n[i+1];

                for (int ii = 0; ii <= 63; ii += 2)
                {
                    b1 = n1 & (1L << ii);
                    b2 = n2 & (1L << ii);
                    //Console.Write("b1 = ");
                    //Console.WriteLine(Convert.ToString((long)b1, 2).PadLeft(64, '0'));
                    //Console.WriteLine(Convert.ToString((long)b1, 2).PadLeft(64, '0'));
                    //Console.Write("b2 = ");
                    //Console.WriteLine(Convert.ToString((long)b2, 2).PadLeft(64, '0'));
                    if (b1 != b2)
                    {
                        if (((n1 >> ii) & 1L) == 1L)
                        {
                            //Console.WriteLine("n1 - 1");
                            n1 = n1 & ~((1L << ii)); //1-0
                            n2 = n2 | b1; //0-1
                        }
                        else if (((n2 >> ii) & 1L) == 1L)
                        {
                            //Console.WriteLine("n2 - 1");
                            n2 = n2 & ~((1L << ii)); //1-0
                            n1 = n1 | b2; //0-1
                        }
                    }
                }

                //Console.WriteLine(n1);
                //Console.WriteLine(Convert.ToString((long)n1, 2).PadLeft(64, '0'));
                //Console.WriteLine(n2);
                //Console.WriteLine(Convert.ToString((long)n2, 2).PadLeft(64, '0'));
                //n1 = n1<< 1;;
                //n1 = n1 >> 1;
                //nr1 = n1;
                //n2 = n2 << 1; ;
                //n2 = n2 >> 1;
                //nr2 = n2;

                //if (n1 >> 63 == 0)
                //{
                //    n1 = ~n1 & ~((1L << 63));
                //}
                //else
                //{
                //    n1 = ~n1;
                //}
                //if (n2 >> 63 == 0)
                //{
                //    n2 = ~n2 & ~((1L << 63));
                //}
                //else
                //{
                //    n2 = ~n2;
                //}
                n1 = ~n1 & ~((1L << 63));
                n2 = ~n2 & ~((1L << 63));
                Console.Write((long)n1 + " ");
                Console.WriteLine(Convert.ToString((long)n1, 2).PadLeft(63, '0'));
                Console.Write((long)n2 + " ");
                Console.WriteLine(Convert.ToString((long)n2 , 2).PadLeft(63, '0'));
            }
        }
    }
}
