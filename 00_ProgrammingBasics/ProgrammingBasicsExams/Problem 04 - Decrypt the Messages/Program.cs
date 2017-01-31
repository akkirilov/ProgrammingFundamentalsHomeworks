using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_04___Decrypt_the_Messages
{
    class Program
    {
        static void Main(string[] args)
        {
            //60 min.
            string line = Console.ReadLine();
            while (line != "start" && line != "START")
            {
                line = Console.ReadLine();
            }

            Dictionary<char, char> specialSymbols = new Dictionary<char, char>()
            {
                { '+' , ' ' },
                { '%' , ',' },
                { '&' , '.' },
                { '#' , '?' },
                { '$' , '!' },
            };
           
            List<string> encryptedMessages = new List<string>();
            int mesaggesCount = 0;

            line = Console.ReadLine();

            while (line != "end" && line != "END")
            {
                if (string.IsNullOrWhiteSpace(line))
                {
                    line = Console.ReadLine();
                    continue;
                }
                char[] symbols = line.ToCharArray();
                for (int i = 0; i < line.Length; i++)
                {
                     
                    if (symbols[i] >= 'a' && symbols[i] <= 'm' || symbols[i] >= 'A' && symbols[i] <= 'M')
                    {
                        symbols[i] = (char)(symbols[i] + 13);
                    }
                    else if (symbols[i] >= 'n' && symbols[i] <= 'z' || symbols[i] >= 'N' && symbols[i] <= 'Z')
                    {
                        symbols[i] = (char)(symbols[i] - 13);
                    }
                    else if (specialSymbols.ContainsKey(symbols[i]))
                    {
                        symbols[i] = specialSymbols[symbols[i]];
                    }
                }
                Array.Reverse(symbols);
                encryptedMessages.Add(new string(symbols));
                mesaggesCount++;
                line = Console.ReadLine();
            }
            if (mesaggesCount != 0)
            {
                Console.WriteLine("Total number of messages: {0}", mesaggesCount);
                foreach (var item in encryptedMessages)
                {
                    Console.WriteLine(item.ToString());
                }
            }
            else
            {
                Console.WriteLine("No message received.");
            }
        }
    }
}