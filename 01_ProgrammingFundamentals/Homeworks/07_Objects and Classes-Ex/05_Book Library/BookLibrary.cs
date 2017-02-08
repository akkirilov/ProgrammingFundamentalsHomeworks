using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05_Book_Library
{
    public class BookLibrary
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            Library myLibrary = new Library { Name = "myLibrary", Books = new List<Book>() };

            Dictionary<string, decimal> authorPriceSort = new Dictionary<string, decimal>();

            for (int i = 0; i < n; i++)
            {
                string[] input = Console.ReadLine().Split().ToArray();

                myLibrary.Books.Add(new Book { Title = input[0], Author = input[1], Publisher = input[2], ReleaseDate = DateTime.Parse(input[3]), ISBN = long.Parse(input[4]), Price = decimal.Parse(input[5]) });
            }

            for (int i = 0; i < myLibrary.Books.Count; i++)
            {
                if (authorPriceSort.ContainsKey(myLibrary.Books[i].Author))
                {
                    authorPriceSort[myLibrary.Books[i].Author] += myLibrary.Books[i].Price;
                    continue;
                }
                authorPriceSort[myLibrary.Books[i].Author] = myLibrary.Books[i].Price;
            }

            foreach (var item in authorPriceSort.OrderByDescending(x => x.Value).ThenBy(x => x.Key))
            {
                Console.WriteLine($"{item.Key} -> {item.Value:f2}");
            }
        }
    }
}