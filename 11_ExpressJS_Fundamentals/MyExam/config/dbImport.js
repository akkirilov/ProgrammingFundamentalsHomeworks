const encryption = require('../utilities/encryption');

const salt = encryption.generateSalt();
const hashedPass = encryption.generateHashedPassword(salt, 'aaa');

module.exports = {
	users: [
		{
			email: 'admin@admin.com',
			roles: ['admin'],
			salt,
			password: hashedPass
		},
		{
			email: 'user@user.com',
			roles: ['user'],
			salt,
			password: hashedPass
		}
	],
	articles: [
		{
			title: 'Astronomy',
			isLocked: false,
			creationDate: new Date("December 15, 2017 11:20:25.421Z"),
			content: `Astronomy is a natural science that studies celestial objects and phenomena. It applies mathematics, physics, and chemistry, in an effort to explain the origin of those objects and phenomena and their evolution. Objects of interest include planets, moons, stars, galaxies, and comets; the phenomena include supernova explosions, gamma ray bursts, and cosmic microwave background radiation. More generally, all phenomena that originate outside Earth's atmosphere are within the purview of astronomy. A related but distinct subject, physical cosmology, is concerned with the study of the Universe as a whole
					<br><br>
					Astronomy is one of the oldest of the natural sciences. The early civilizations in recorded history, such as the Babylonians, Greeks, Indians, Egyptians, Nubians, Iranians, Chinese, Maya, and many ancient indigenous peoples of the Americas performed methodical observations of the night sky. Historically, astronomy has included disciplines as diverse as astrometry, celestial navigation, observational astronomy and the making of calendars, but professional astronomy is now often considered to be synonymous with astrophysics
					<br><br>
					Professional astronomy is split into observational and theoretical branches. Observational astronomy is focused on acquiring data from observations of astronomical objects, which is then analyzed using basic principles of physics. Theoretical astronomy is oriented toward the development of computer or analytical models to describe astronomical objects and phenomena. The two fields complement each other, with theoretical astronomy seeking to explain observational results and observations being used to confirm theoretical results.
					<br><br>
					Astronomy is one of the few sciences where amateurs still play an active role, especially in the discovery and observation of transient phenomena. Amateur astronomers have made and contributed to many important astronomical discoveries, such as finding new comets.
					`
		},
		{
			title: 'Telescope',
			isLocked: false,
			creationDate: new Date("December 14, 2017 11:20:25.421Z"),
			content: `A telescope is an optical instrument that aids in the observation of remote objects by collecting electromagnetic radiation (such as visible light). The first known practical telescopes were invented in the Netherlands at the beginning of the 17th century, by using glass lenses. They found use in both terrestrial applications and astronomy.
					<br><br>
					The reflecting telescope, which uses mirrors to collect and focus light, was invented within a few decades of the first telescopes being made. In the 20th century, many new types of telescopes were invented, including radio telescopes in the 1930s and infrared telescopes in the 1960s. The word telescope now refers to a wide range of instruments capable of detecting different regions of the electromagnetic spectrum, and in some cases other types of detectors.
					<br><br>
					The word telescope was coined in 1611 by the Greek mathematician Giovanni Demisiani for one of Galileo Galilei's instruments presented at a banquet at the Accademia dei Lincei. In the Starry Messenger, Galileo had used the term perspicillum.
					`
		},
		{
			title: 'Planet',
			isLocked: false,
			creationDate: new Date("December 13, 2017 11:20:25.421Z"),
			content: `A planet is an astronomical body orbiting a star or stellar remnant that is massive enough to be rounded by its own gravity, is not massive enough to cause thermonuclear fusion, and has cleared its neighbouring region of planetesimals.
					<br><br>
					The term planet is ancient, with ties to history, astrology, science, mythology, and religion. Several planets in the Solar System can be seen with the naked eye. These were regarded by many early cultures as divine, or as emissaries of deities. As scientific knowledge advanced, human perception of the planets changed, incorporating a number of disparate objects. In 2006, the International Astronomical Union (IAU) officially adopted a resolution defining planets within the Solar System. This definition is controversial because it excludes many objects of planetary mass based on where or what they orbit. Although eight of the planetary bodies discovered before 1950 remain "planets" under the modern definition, some celestial bodies, such as Ceres, Pallas, Juno and Vesta (each an object in the solar asteroid belt), and Pluto (the first trans-Neptunian object discovered), that were once considered planets by the scientific community, are no longer viewed as such.
					<br><br>
					The planets were thought by Ptolemy to orbit Earth in deferent and epicycle motions. Although the idea that the planets orbited the Sun had been suggested many times, it was not until the 17th century that this view was supported by evidence from the first telescopic astronomical observations, performed by Galileo Galilei. At about the same time, by careful analysis of pre-telescopic observation data collected by Tycho Brahe, Johannes Kepler found the planets' orbits were not circular but elliptical. As observational tools improved, astronomers saw that, like Earth, the planets rotated around tilted axes, and some shared such features as ice caps and seasons. Since the dawn of the Space Age, close observation by space probes has found that Earth and the other planets share characteristics such as volcanism, hurricanes, tectonics, and even hydrology.
					<br><br>
					Planets are generally divided into two main types: large low-density giant planets, and smaller rocky terrestrials. Under IAU definitions, there are eight planets in the Solar System. In order of increasing distance from the Sun, they are the four terrestrials, Mercury, Venus, Earth, and Mars, then the four giant planets, Jupiter, Saturn, Uranus, and Neptune. Six of the planets are orbited by one or more natural satellites.
					<br><br>
					Several thousands of planets around other stars ("extrasolar planets" or "exoplanets") have been discovered in the Milky Way. As of 2 June 2018, 3,786 known extrasolar planets in 2,834 planetary systems (including 629 multiple planetary systems), ranging in size from just above the size of the Moon to gas giants about twice as large as Jupiter have been discovered, out of which more than 100 planets are the same size as Earth, nine of which are at the same relative distance from their star as Earth from the Sun, i.e. in the habitable zone. On December 20, 2011, the Kepler Space Telescope team reported the discovery of the first Earth-sized extrasolar planets, Kepler-20e and Kepler-20f, orbiting a Sun-like star, Kepler-20. A 2012 study, analyzing gravitational microlensing data, estimates an average of at least 1.6 bound planets for every star in the Milky Way. Around one in five Sun-like stars is thought to have an Earth-sized planet in its habitable zone.
					`
		},
		{
			title: 'Star',
			isLocked: false,
			creationDate: new Date("December 12, 2017 11:20:25.421Z"),
			content: `A star is type of astronomical object consisting of a luminous spheroid of plasma held together by its own gravity. The nearest star to Earth is the Sun. Many other stars are visible to the naked eye from Earth during the night, appearing as a multitude of fixed luminous points in the sky due to their immense distance from Earth. Historically, the most prominent stars were grouped into constellations and asterisms, the brightest of which gained proper names. Astronomers have assembled star catalogues that identify the known stars and provide standardized stellar designations. However, most of the stars in the Universe, including all stars outside our galaxy, the Milky Way, are invisible to the naked eye from Earth. Indeed, most are invisible from Earth even through the most powerful telescopes.
					<br><br>
					For at least a portion of its life, a star shines due to thermonuclear fusion of hydrogen into helium in its core, releasing energy that traverses the star's interior and then radiates into outer space. Almost all naturally occurring elements heavier than helium are created by stellar nucleosynthesis during the star's lifetime, and for some stars by supernova nucleosynthesis when it explodes. Near the end of its life, a star can also contain degenerate matter. Astronomers can determine the mass, age, metallicity (chemical composition), and many other properties of a star by observing its motion through space, its luminosity, and spectrum respectively. The total mass of a star is the main factor that determines its evolution and eventual fate. Other characteristics of a star, including diameter and temperature, change over its life, while the star's environment affects its rotation and movement. A plot of the temperature of many stars against their luminosities produces a plot known as a Hertzsprung–Russell diagram (H–R diagram). Plotting a particular star on that diagram allows the age and evolutionary state of that star to be determined.
					<br><br>
					A star's life begins with the gravitational collapse of a gaseous nebula of material composed primarily of hydrogen, along with helium and trace amounts of heavier elements. When the stellar core is sufficiently dense, hydrogen becomes steadily converted into helium through nuclear fusion, releasing energy in the process. The remainder of the star's interior carries energy away from the core through a combination of radiative and convective heat transfer processes. The star's internal pressure prevents it from collapsing further under its own gravity. A star with mass greater than 0.4 times the Sun's will expand to become a red giant when the hydrogen fuel in its core is exhausted. In some cases, it will fuse heavier elements at the core or in shells around the core. As the star expands it throws a part of its mass, enriched with those heavier elements, into the interstellar environment, to be recycled later as new stars. Meanwhile, the core becomes a stellar remnant: a white dwarf, a neutron star, or if it is sufficiently massive a black hole.
					<br><br>
					Binary and multi-star systems consist of two or more stars that are gravitationally bound and generally move around each other in stable orbits. When two such stars have a relatively close orbit, their gravitational interaction can have a significant impact on their evolution. Stars can form part of a much larger gravitationally bound structure, such as a star cluster or a galaxy.
					`
		},
	]
};