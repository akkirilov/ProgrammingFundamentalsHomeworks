using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_04___Text_Bombardment
{
    class Program
    {
        static void Main(string[] args)
        {
            //57 min. - 75t.
            string text = Console.ReadLine();
            char[] textNew = text.ToCharArray();
            int lineWidth = int.Parse(Console.ReadLine());
            string bombs = Console.ReadLine();
            int bombardiredColumn = 0;

            string[] bombsEll = bombs.Split(' ');
            for (int i = 0; i < bombsEll.Length; i++)
            {
                bombardiredColumn = int.Parse(bombsEll[i]);
                for (int j = bombardiredColumn; j < textNew.Length; j += lineWidth)
                {
                    if (j + lineWidth <= textNew.Length && textNew[j + lineWidth] == ' '&& textNew[j] != ' ')
                    {
                        textNew[j] = ' ';
                        break;
                    }
                    else
                    {
                        textNew[j] = ' ';
                    }
                }
            }
            foreach (var item in textNew)
            {
                Console.Write(item);
            }
            Console.WriteLine();
        }
    }
}