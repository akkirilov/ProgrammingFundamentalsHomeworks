using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02_Append_Lists
{
    class Program
    {
        static void Main(string[] args)
        {
            List<List<int>> numbers = Console.ReadLine().Split('|').Select(x => x.Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).ToList()).Reverse().ToList();
            numbers.ForEach(x => x.ForEach(y => Console.Write(y + " ")));
        }
    }
}