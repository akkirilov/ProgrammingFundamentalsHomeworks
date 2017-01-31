using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_04___Array_Matcher
{
    class Program
    {
        static void Main(string[] args)
        {
            //45 min.
            string line = Console.ReadLine();
            string[] lineEll = line.Split('\\');
            string line1 = lineEll[0];
            string line2 = lineEll[1];
            string command = lineEll[2];
            int count = 0;
            int t = 0;

            char[] first = new char[line1.Length];
            char[] second = new char[line2.Length];
            char[] temp = new char[line2.Length + line1.Length];
            for (int i = 0; i < temp.Length; i++)
            {
                temp[i] = ' ';
            }
            for (int i = 0; i < line1.Length; i++)
            {
                first[i] = line1[i];
            }
            for (int i = 0; i < line2.Length; i++)
            {
                second[i] = line2[i];
            }
            if (command == "join")
            {
                for (int i1 = 0; i1 < first.Length; i1++)
                {
                    for (int i2 = 0; i2 < second.Length; i2++)
                    {
                        if (first[i1] == second[i2])
                        {
                            temp[count] = first[i1];
                            count++;
                            break;
                        }
                    }
                }
            }
            else if (command == "left exclude")
            {
                for (int i2 = 0; i2 < second.Length; i2++)
                {
                    for (int i1 = 0; i1 < first.Length; i1++)
                    {
                        if (second[i2] == first[i1])
                        {
                            t++;
                            break;
                        }
                    }
                    if (t==0)
                    {
                        temp[count] = second[i2];
                        count++;
                    }
                    else
                    {
                        t = 0;
                    }
                }
            }
            else if (command == "right exclude")
            {
                for (int i1 = 0; i1 < first.Length; i1++)
                {
                    for (int i2 = 0; i2 < second.Length; i2++)
                    {
                        if (first[i1] == second[i2])
                        {
                            t++;
                            break;
                        }
                    }
                    if (t == 0)
                    {
                        temp[count] = first[i1];
                        count++;
                    }
                    else
                    {
                        t = 0;
                    }
                }
            }
            t = 0;
            Array.Sort(temp);
            char[] final = new char[count];
            for (int i = 0; i < temp.Length; i++)
            {
                if (temp[i] != ' ')
                {
                    final[t] = temp[i];
                    t++;
                }
            }

            for (int i = 0; i < final.Length; i++)
            {
                Console.Write(final[i]);
            }
            Console.WriteLine();
        }
    }
}