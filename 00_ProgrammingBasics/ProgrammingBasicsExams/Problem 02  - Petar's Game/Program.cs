using System;
using System.Numerics;


namespace Problem_02____Petar_s_Game
{
    class Program
    {
        static void Main(string[] args)
        {
            //14 min. - 90 p.
            ulong s = ulong.Parse(Console.ReadLine());
            ulong f = ulong.Parse(Console.ReadLine());
            string str = Console.ReadLine();

            ulong sum = 0;
            string ss = "";
            string replacee = "";

            for (ulong i = s; i < f; i++)
            {
                
                if (i % 5 == 0) 
                {
                    sum += i;
                }
                else
                {
                    sum += (i % 5);
                }
            }
            ss = sum.ToString();

            if (sum % 2 == 0)
            {
                replacee = ss[0].ToString();
            }
            else
            {
                replacee = ss[ss.Length - 1].ToString();
            }

            Console.WriteLine(ss.Replace(replacee, str));
        }
    }
}