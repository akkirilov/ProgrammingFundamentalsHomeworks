using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_04___Encrypt_the_Messages
{
    class Program
    {
        static void Main(string[] args)
        {
            //1529
            while(true)
            {
                string commandS = Console.ReadLine().ToUpper();
                if (commandS == "START")
                {
                    break;
                }
            }

            int count = 0;
            List<string> final = new List<string>();
            Dictionary<char, char> specialSymbols = new Dictionary<char, char>
            {
                {' ', '+'},
                {',', '%'},
                {'.', '&'},
                {'?', '#'},
                {'!', '$'}
            }; 
            
            string command = Console.ReadLine();
            while (command != "END" && command != "end")
            {
                if (string.IsNullOrWhiteSpace(command))
                {
                    command = Console.ReadLine();
                    continue;
                }

                char[] symbols = command.ToCharArray();
                for (int i = 0; i < command.Length; i++)
                { 
                    char currentChar = symbols[i];
                    if ('a' <= symbols[i] && symbols[i] <= 'm' || 'A' <= symbols[i] && symbols[i] <= 'M')
                    {
                        symbols[i] = (char)(currentChar + 13); 
                    }
                    else if ('n' <= currentChar && currentChar <= 'z' || 'N' <= currentChar && currentChar <= 'Z')
                    {
                        symbols[i] = (char)(currentChar - 13);
                    }
                    else if (specialSymbols.ContainsKey(currentChar))
                    {
                        symbols[i] = specialSymbols[currentChar];
                    }
                }
                Array.Reverse(symbols);
                final.Add(new string(symbols));
                count++;
                command = Console.ReadLine();
            }
            if (count == 0)
            {
                Console.WriteLine("No messages sent.");
            }
            else
            {
                Console.WriteLine("Total number of messages: {0}", count);
                foreach(string currM in final)
                {
                    Console.WriteLine(currM);
                }
            }
        }
    }
}