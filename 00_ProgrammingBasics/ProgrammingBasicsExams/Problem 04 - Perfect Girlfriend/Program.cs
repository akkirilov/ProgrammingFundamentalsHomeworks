using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_04___Perfect_Girlfriend
{
    class Program
    {
        static void Main(string[] args)
        {
            string line = Console.ReadLine();
            int good = 0;
            int score = 0;

            while (line != "Enough dates!")
            {
                string [] lineEll = line.Split('\\');
                int day = 1;
                long phoneNum = long.Parse(lineEll[1]);
                score = 0;

                if (lineEll[0] == "Tuesday")
                {
                    day = 2;
                }
                else if (lineEll[0] == "Wednesday")
                {
                    day = 3;
                }
                else if (lineEll[0] == "Thursday")
                {
                    day = 4;
                }
                else if (lineEll[0] == "Friday")
                {
                    day = 5;
                }
                else if (lineEll[0] == "Saturday")
                {
                    day = 6;
                }
                else if (lineEll[0] == "Sunday")
                {
                    day = 7;
                }
                score += day;

                for (int i = 0; i < lineEll[1].Length; i++)
                {
                    string temp = lineEll[1];
                    score += int.Parse(temp[i].ToString());
                }

                string bra = lineEll[2];
                int tempbra = (int)bra[lineEll[2].Length-1];
                string temptemp = "";
                for (int i = 0; i < lineEll[2].Length - 1; i++)
                {
                    temptemp = temptemp + bra[i].ToString();
                }
                int temp1 = tempbra * int.Parse(temptemp);
                score += temp1;

                string name = lineEll[3];
                char temp2 = name[0];

                score -= ((int)temp2 * name.Length);

                if (score<6000)
                {
                    Console.WriteLine("Keep searching, {0} is not for you.", lineEll[3]);
                }
                else
                {
                    good++;
                    Console.WriteLine("{0} is perfect for you.", lineEll[3]);
                }
                line = Console.ReadLine();
            }
            Console.WriteLine(good);
        }
    }
}
