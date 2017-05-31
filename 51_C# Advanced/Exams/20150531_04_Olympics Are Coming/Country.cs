using System.Collections.Generic;
using System.Linq;

namespace _20150531_04_Olympics_Are_Coming
{
    class Country
    {
        public string Name { get; set; }
        public List<string> TotalAthletesWins { get; set; }

        public int UniqueAthletes => TotalAthletesWins.Distinct().Count();
    }
}