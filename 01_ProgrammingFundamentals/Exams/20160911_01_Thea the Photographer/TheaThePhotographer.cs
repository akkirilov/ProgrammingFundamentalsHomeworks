using System;

namespace _20160911_01_Thea_the_Photographer
{
    class TheaThePhotographer
    {
        static void Main()
        {
            long amountPictures = long.Parse(Console.ReadLine());
            long filterTime = long.Parse(Console.ReadLine()) * amountPictures;
            long filterFactor = (long)Math.Ceiling((decimal.Parse(Console.ReadLine()) * amountPictures) / 100m);
            long uploadTime = long.Parse(Console.ReadLine()) * filterFactor;

            long seconds = (long)(filterTime + uploadTime);
            TimeSpan totalTime = new TimeSpan(seconds * 10000000);
            Console.WriteLine(totalTime.ToString("d\\:hh\\:mm\\:ss"));
        }
    }
} 