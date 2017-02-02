using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _20160601_04_Population_Aggregation
{
    class Program
    {
        static void Main(string[] args)
        {
            //Dava 88 t. Gyrmi po vreme na posledniq test.

            Dictionary<string, byte> countries = new Dictionary<string, byte>();
            Dictionary<long, string> cities = new Dictionary<long, string>();

            string[] input = Console.ReadLine().Split('\\').ToArray();
            while (input[0] != "stop")
            {
                string country = onlyLetters(input[0]);
                string city = onlyLetters(input[1]);

                if (char.IsUpper(city[0]))
                {
                    city = country;
                    country = onlyLetters(input[1]);
                }

                if (countries.ContainsKey(country))
                {
                    countries[country]++;
                }
                else
                {
                    countries.Add(country, 1);
                }
                
                cities.Add(long.Parse(input[2]), city);

                input = Console.ReadLine().Split('\\').ToArray();
            }

            foreach (KeyValuePair<string, byte> country in countries.OrderBy(x => x.Key))
            {
                Console.WriteLine(country.Key + " -> " + country.Value);
            }

            foreach (KeyValuePair<long, string> city in cities.OrderByDescending(x => x.Key).Take(3))
            {
                Console.WriteLine(city.Value + " -> " + city.Key);
            }
        }

        private static string onlyLetters(string text)
        {
            string clearText = string.Empty;
            for (byte i = 0; i < text.Length; i++)
            {
                if (char.IsLetter(text[i]))
                {
                    clearText += text[i];
                }
            }
            return clearText;
        }
    }
}