using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06_Strings_and_Objects
{
    class Program
    {
        static void Main(string[] args)
        {
            string a = "Hello";
            string b = "World";
            object ab = a + " " + b;
            string abToString = ab.ToString();
            Console.WriteLine(abToString);
        }
    }
}