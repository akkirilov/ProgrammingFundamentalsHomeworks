using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04_Split_by_Word_Casing
{
    class Program
    {
        private static int length;

        static void Main(string[] args)
        {
            List<string> words = Console.ReadLine().Split(new char[] { ',', ';', ':', '.', '!', '(', ')', '"', '\'', '\\', '/', '[', ']', ' ' }, StringSplitOptions.RemoveEmptyEntries).ToList();

            List<string> upper = new List<string>();
            List<string> lower = new List<string>();
            List<string> mixed = new List<string>();

            for (int i = 0; i < words.Count; i++)
            {
                bool isLower = false;
                bool isUpper = false;
                bool isMixed = false;
                for (int w = 0; w < words[i].Length; w++)
                {
                    if (words[i][w] >= '!' && words[i][w] <= '@')
                    {
                        isLower = false;
                        isUpper = false;
                        isMixed = true;
                        break;
                    }
                    else if (words[i][w] >= 'a' && words[i][w] <= 'z')
                    {
                        if (isUpper)
                        {
                            isLower = false;
                            isUpper = false;
                            isMixed = true;
                            break;
                        }
                        isLower = true;
                    }
                    else if (words[i][w] >= 'A' && words[i][w] <= 'Z')
                    {
                        if (isLower)
                        {
                            isLower = false;
                            isUpper = false;
                            isMixed = true;
                            break;
                        }
                        isUpper = true;
                    }
                }

                if (isMixed)
                {
                    mixed.Add(words[i]);
                }
                else if(isLower)
                {
                    lower.Add(words[i]);
                }
                else if (isUpper)
                {
                    upper.Add(words[i]);
                }
            }
            
            Console.WriteLine("Lower-case: {0}", String.Join(", ", lower));
            Console.WriteLine("Mixed-case: {0}", String.Join(", ", mixed));
            Console.WriteLine("Upper-case: {0}", String.Join(", ", upper));
        }
    }
}