using System.Collections.Generic;
using System.Linq;
using System.IO;

namespace _04_Merge_Files
{
    class MergeFiles
    {
        static void Main()
        {
            DirectoryInfo thisDir = new DirectoryInfo(Directory.GetCurrentDirectory());

            List<string> files = thisDir
                .GetFiles()
                .Select(x => x.Name)
                .Where(x => x.Contains(".txt") && x != "result.txt")
                .ToList();

            List<string> mergeFiles = new List<string>();

            for (int i = 0; i < files.Count; i++)
            {
                mergeFiles.AddRange(File.ReadAllLines(files[i]).ToList());
            }

            File.WriteAllLines("result.txt", mergeFiles.OrderBy(x => x));
        }
    }
}