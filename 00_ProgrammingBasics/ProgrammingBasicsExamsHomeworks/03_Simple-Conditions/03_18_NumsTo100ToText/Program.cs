using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03_18_NumsTo100ToText
{
    class Program
    {
        static void Main(string[] args)
        {
            int number = int.Parse(Console.ReadLine());
            int num2 = number % 10;
            int num1 = number / 10;
            string num1Text = " ";
            string num2Text = " ";

            if ((number != 0) && (number > 19) && (number < 100))
            {

                if (num1 == 2)
                {
                    num1Text = "twenty";
                }
                if (num1 == 3)
                {
                    num1Text = "thirty";
                }
                if (num1 == 4)
                {
                    num1Text = "fourty";
                }
                if (num1 == 5)
                {
                    num1Text = "fifty";
                }
                if (num1 == 6)
                {
                    num1Text = "sixty";
                }
                if (num1 == 7)
                {
                    num1Text = "seventy";
                }
                if (num1 == 8)
                {
                    num1Text = "eighty";
                }
                if (num1 == 9)
                {
                    num1Text = "ninety";
                }
                if (num2 == 0)
                {
                    num2Text = "";
                }
                if (num2 == 1)
                {
                    num2Text = " one";
                }
                if (num2 == 2)
                {
                    num2Text = " two";
                }
                if (num2 == 3)
                {
                    num2Text = " three";
                }
                if (num2 == 4)
                {
                    num2Text = " four";
                }
                if (num2 == 5)
                {
                    num2Text = " five";
                }
                if (num2 == 6)
                {
                    num2Text = " six";
                }
                if (num2 == 7)
                {
                    num2Text = " seven";
                }
                if (num2 == 8)
                {
                    num2Text = " eight";
                }
                if (num2 == 9)
                {
                    num2Text = " nine";
                }
                Console.WriteLine(num1Text + num2Text);
            }
            if (number == 0)
            {
                Console.WriteLine("zero");
            }

            if (number == 1)
            {
                Console.WriteLine("one");
            }
            if (number == 2)
            {
                Console.WriteLine("two");
            }
            if (number == 3)
            {
                Console.WriteLine("three");
            }
            if (number == 4)
            {
                Console.WriteLine("four");
            }
            if (number == 5)
            {
                Console.WriteLine("five");
            }
            if (number == 6)
            {
                Console.WriteLine("six");
            }
            if (number == 7)
            {
                Console.WriteLine("seven");
            }
            if (number == 8)
            {
                Console.WriteLine("eight");
            }

            if (number == 10)
            {
                Console.WriteLine("ten");
            }
            else if (number == 11)
            {
                Console.WriteLine("eleven");
            }
            else if (number == 12)
            {
                Console.WriteLine("twelve");
            }
            else if (number == 13)
            {
                Console.WriteLine("thirteen");
            }
            else if (number == 14)
            {
                Console.WriteLine("fourteen");
            }
            else if (number == 15)
            {
                Console.WriteLine("fifteen");
            }
            else if (number == 16)
            {
                Console.WriteLine("sixteen");
            }
            else if (number == 17)
            {
                Console.WriteLine("seventeen");
            }
            else if (number == 18)
            {
                Console.WriteLine("eighteen");
            }
            else if (number == 19)
            {
                Console.WriteLine("nineteen");
            }
            else if (number == 100)
            {
                Console.WriteLine("one hundred");
            }
            else if ((number > 100) && (number < 0))
                Console.WriteLine("Invalid number");
        }
    }
}
