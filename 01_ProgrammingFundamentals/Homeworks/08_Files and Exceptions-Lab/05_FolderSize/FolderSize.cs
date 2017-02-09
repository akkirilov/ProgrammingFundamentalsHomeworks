using System.Linq;
using System.IO;

namespace _05_FolderSize
{
    class FolderSize
    {
        static void Main()
        {
            //! ! !  TestFolder need to be added in .\Debug  ! ! !

            DirectoryInfo thisDir = new DirectoryInfo(Directory.GetCurrentDirectory() + "\\TestFolder");

            double size = thisDir.GetFiles().Select(x => x.Length / 1024.0 / 1024.0).Sum();

            File.WriteAllText("result.txt", size.ToString());
        }
    }
}