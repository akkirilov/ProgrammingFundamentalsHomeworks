using System;
using System.Collections.Generic;
using System.Linq;
using System.Globalization;

namespace _10_Student_Groups
{
    class StudentGroups
    {
        static void Main(string[] args)
        {
            List<Town> towns = new List<Town>();

            string input = Console.ReadLine();
            while (!input.Equals("End"))
            {
                if (input.Contains("=>"))
                {
                    string[] inputEll = input.Split(new string[] { "=>" }, StringSplitOptions.RemoveEmptyEntries).ToArray();
                    towns.Add(new Town
                    {
                        Name = inputEll[0].Trim(),
                        SeatCount = int.Parse(inputEll[1].Trim().Split()[0]),
                        Students = new List<Student>()
                    });
                }
                else
                {
                    string[] inputEll = input.Trim().Split("|".ToCharArray(), StringSplitOptions.RemoveEmptyEntries).ToArray();

                    towns.Last().Students.Add(new Student
                    {
                        Name = inputEll[0].Trim(),
                        Email = inputEll[1].Trim(),
                        Registration = DateTime.ParseExact(inputEll[2].Trim(), "d\\-MMM\\-yyyy", CultureInfo.InvariantCulture)
                    });
                }

                input = Console.ReadLine();
            }

            List<Group> groups = CreateGroups(towns);

            Console.WriteLine($"Created {groups.Count} groups in {towns.Count} towns:");

            foreach (var group in groups)
            {
                Console.WriteLine($"{group.Town} => {String.Join(", ", group.Students.Select(x => x.Email))}");
            }
        }

        public static List<Group> CreateGroups(List<Town> towns)
        {
            List<Group> groups = new List<Group>();

            foreach (var town in towns.OrderBy(x => x.Name))
            {
                List<Student> currentStudents = town.Students
                    .OrderBy(x => x.Registration)
                    .ThenBy(x => x.Name)
                    .ThenBy(x => x.Email)
                    .ToList();

                for (int i = 0; i < currentStudents.Count;)
                {
                    Group current = new Group
                    {
                        Town = town.Name,
                        Students = new List<Student>()
                    };

                    for (int j = 0; j < town.SeatCount; j++)
                    {
                        if (i + j < currentStudents.Count)
                        {
                            current.Students.Add(currentStudents[i + j]);
                        }
                    }

                    groups.Add(current);

                    i += town.SeatCount;
                }
            }

            return groups;
        }
    }
}