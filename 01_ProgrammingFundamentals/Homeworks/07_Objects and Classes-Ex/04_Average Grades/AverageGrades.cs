using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04_Average_Grades
{
    class AverageGrades
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            List<Student> studentsList = new List<Student>();
            for (int i = 0; i < n; i++)
            {
                List<string> input = Console.ReadLine().Split().ToList();
                string name = input[0];
                input.RemoveAt(0);
                studentsList.Add(new Student { Name = name, Grades = input.Select(double.Parse).ToList() });
            }

            studentsList = studentsList.Where(x => x.AvarageGrade >= 5).OrderBy(x => x.Name).ThenByDescending(x => x.AvarageGrade).ToList();

            for (int i = 0; i < studentsList.Count; i++)
            {
                Console.WriteLine($"{studentsList[i].Name} -> {studentsList[i].AvarageGrade:f2}");
            }
        }
    }
}