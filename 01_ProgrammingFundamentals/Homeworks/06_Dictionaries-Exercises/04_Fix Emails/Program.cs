using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04_Fix_Emails
{
    class Program
    {
        static void Main(string[] args)
        {
            Dictionary<string, string> mailBook = new Dictionary<string, string>();

            string name = Console.ReadLine();
            if (name == "stop")
            {
                return;
            }

            string mail = Console.ReadLine();
            string domain = mail.Substring(mail.Length - 2).ToLower();

            while (true)
            {
                
                if (!mailBook.ContainsKey(name) && (domain != "uk" || domain != "us"))
                {
                    mailBook.Add(name, mail);
                }
                else
                {
                    mailBook[name] = mail;
                }

                name = Console.ReadLine();
                if (name == "stop")
                {
                    break;
                }

                mail = Console.ReadLine().ToLower();
            }

            PrintMailBook(mailBook);
        }

        private static void PrintMailBook(Dictionary<string, string> mailBook)
        {
            foreach (var contact in mailBook)
            {
                Console.WriteLine($"{contact.Key} -> {contact.Value}");
            }
        }
    }
}