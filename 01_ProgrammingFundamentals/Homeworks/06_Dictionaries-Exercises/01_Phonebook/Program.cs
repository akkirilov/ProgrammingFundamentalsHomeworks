using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01_Phonebook
{
    class Program
    {
        public static Dictionary<string, string> phoneBook = new Dictionary<string, string>();

        static void Main(string[] args)
        {
            string[] command = Console.ReadLine().Split();

            while (command[0] != "END")
            {
                switch (command[0])
                {
                    case "A":
                        AddContact(command[1], command[2]);
                        break;
                    case "S":
                        SearchInContacts(command[1]);
                        break;
                }

                command = Console.ReadLine().Split();
            }
        }

        private static void SearchInContacts(string name)
        {
            if (phoneBook.ContainsKey(name))
            {
                Console.WriteLine($"{name} -> {phoneBook[name]}");
                return;
            }

            Console.WriteLine($"Contact {name} does not exist.");
        }

        private static void AddContact(string name, string phoneNumber)
        {
            if (!phoneBook.ContainsKey(name))
            {
                phoneBook.Add(name, phoneNumber);
                return;
            }

            phoneBook[name] = phoneNumber;
        }
    }
}