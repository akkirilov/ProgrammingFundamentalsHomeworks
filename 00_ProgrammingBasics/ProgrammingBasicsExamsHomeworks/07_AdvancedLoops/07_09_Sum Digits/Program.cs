using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07_09_Sum_Digits
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            string l = n.ToString();
            int t;
            int res = 0;

            for (int i = 1; i <= l.Length; i++)
            {
                t = n % 10;
                res += t;
                n /= 10;
            }
            Console.WriteLine(res);
        }
    }
}
