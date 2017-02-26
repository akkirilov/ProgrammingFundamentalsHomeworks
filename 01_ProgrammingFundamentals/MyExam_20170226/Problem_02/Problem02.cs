using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

namespace Problem_02
{
    public class Problem02
    {
        public static void Main()
        {
            List<string> messages = new List<string>();
            List<string> broadcast = new List<string>();
            Regex regexDigits = new Regex(@"^[0-9]+$");
            Regex regexSecond = new Regex(@"^[0-9A-Za-z]+$");
            Regex regexAnySimbol = new Regex(@"^[^0-9]+$");

            while (true)
            {
                string[] input = Console.ReadLine().Split(new string[] { " <-> " }, StringSplitOptions.RemoveEmptyEntries).ToArray();
                if (input[0].Equals("Hornet is Green"))
                {
                    break;
                }

                if (input.Length != 2)
                {
                    continue;
                }
                if (regexDigits.IsMatch(input[0]))
                {
                    if (regexSecond.IsMatch(input[1]))
                    {
                        StringBuilder mess = new StringBuilder();
                        for (int i = input[0].Length - 1; i >= 0; i--)
                        {
                            mess.Append(input[0][i]);
                        }
                        mess.Append(" -> ");
                        mess.Append(input[1]);
                        messages.Add(mess.ToString());
                        continue;
                    }
                }

                if (regexAnySimbol.IsMatch(input[0]))
                {
                    if (regexSecond.IsMatch(input[1]))
                    {
                        StringBuilder mess = new StringBuilder();
                        for (int i = 0; i < input[1].Length; i++)
                        {
                            if (char.IsLetter(input[1][i]))
                            {
                                if (char.IsLower(input[1][i]))
                                {
                                    mess.Append((char)(input[1][i].ToString().ToUpper()[0]));
                                }
                                else if (char.IsUpper(input[1][i]))
                                {
                                    mess.Append((char)(input[1][i].ToString().ToLower()[0]));
                                }
                            }
                            else
                            {
                                mess.Append(input[1][i]);
                            }
                        }
                        mess.Append(" -> ");
                        mess.Append(input[0]);
                        broadcast.Add(mess.ToString());
                        continue;
                    }
                }
            }

            Console.WriteLine("Broadcasts:");
            if (broadcast.Count == 0)
            {
                Console.WriteLine("None");
            }
            else
            {
                foreach (var broad in broadcast)
                {
                    Console.WriteLine(broad);
                }
            }

            Console.WriteLine("Messages:");
            if (messages.Count == 0)
            {
                Console.WriteLine("None");
            }
            else
            {
                foreach (var mesage in messages)
                {
                    Console.WriteLine(mesage);
                }
            }
        }
    }
}