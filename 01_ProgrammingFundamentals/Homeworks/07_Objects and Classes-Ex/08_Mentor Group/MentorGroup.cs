using System;
using System.Collections.Generic;
using System.Linq;
using System.Globalization;

namespace _08_Mentor_Group
{
    public class MentorGroup
    {
        public static void Main()
        {
            SortedDictionary<string, Student> students = new SortedDictionary<string, Student>();
            
            string input = Console.ReadLine();
            while (input != "end of dates")
            {
                string[] inputEll = input.Split().ToArray();
                string name = inputEll[0];

                if (inputEll.Length > 1)
                {
                    List<DateTime> currentAttend = inputEll[1].Split(',')
                        .Select(x => DateTime.ParseExact(x, "dd\\/MM\\/yyyy", CultureInfo.InvariantCulture))
                        .ToList();

                    if (students.ContainsKey(name))
                    {
                        students[name].Attendency.AddRange(currentAttend);
                    }
                    else
                    {
                        Student currentStudent = new Student
                        {
                            Name = name,
                            Attendency = currentAttend,
                            Comments = new List<string>()
                        };

                        students[name] = currentStudent;
                    }
                }

                input = Console.ReadLine();
            }

            input = Console.ReadLine();
            while (input != "end of comments")
            {
                string[] inputEll = input.Split('-').ToArray();

                string name = inputEll[0];
                string comment = inputEll[1];

                if (students.ContainsKey(name))
                {
                    students[name].Comments.Add(comment);
                }

                input = Console.ReadLine();
            }

            foreach (var student in students)
            {
                Console.WriteLine(student.Value.Name);

                Console.WriteLine("Comments:");
                foreach (var comment in student.Value.Comments)
                {
                    Console.WriteLine($"- {comment}");
                }

                Console.WriteLine("Dates attended:");
                foreach (var attend in student.Value.Attendency.OrderBy(x => x))
                {
                    Console.WriteLine($"-- {attend.ToString("dd\\/MM\\/yyyy")}");
                }
            }
            Console.WriteLine();
        }
    }
}