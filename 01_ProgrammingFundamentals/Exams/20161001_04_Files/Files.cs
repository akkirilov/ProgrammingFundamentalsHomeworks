using System;
using System.Collections.Generic;
using System.Linq;

namespace _20161001_04_Files
{
    class Files
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            List<string> fileList = new List<string>();

            for (int i = 0; i < n; i++)
            {
                fileList.Add(Console.ReadLine());
            }

            string[] instructions = Console.ReadLine().Trim().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).ToArray();

            Dictionary<string, long> orderedFiles = new Dictionary<string, long>();

            for (int i = 0; i < fileList.Count; i++)
            {
                List<string> currentFile = fileList[i].Trim().Split(new char[] { '\\', ';' }, StringSplitOptions.RemoveEmptyEntries).ToList();

                if (currentFile[0] == instructions[2] && currentFile[currentFile.Count - 2].EndsWith(instructions[0]))
                {
                    orderedFiles[currentFile[currentFile.Count - 2]] = long.Parse(currentFile[currentFile.Count - 1]);
                }
            }

            if (orderedFiles.Count < 1)
            {
                Console.WriteLine("No");
                return;
            }

            foreach (var file in orderedFiles.OrderByDescending(x => x.Value).ThenBy(x => x.Key))
            {
                Console.WriteLine($"{file.Key} - {file.Value} KB");
            }
        }
    }
}