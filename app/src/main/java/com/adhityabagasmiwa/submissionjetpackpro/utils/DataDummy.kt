package com.adhityabagasmiwa.submissionjetpackpro.utils

import com.adhityabagasmiwa.submissionjetpackpro.data.source.local.entity.CatalogueEntity
import com.adhityabagasmiwa.submissionjetpackpro.data.source.local.entity.DetailEntity
import com.adhityabagasmiwa.submissionjetpackpro.data.source.remote.response.movies.MoviesDetailsResponse
import com.adhityabagasmiwa.submissionjetpackpro.data.source.remote.response.movies.MoviesItems
import com.adhityabagasmiwa.submissionjetpackpro.data.source.remote.response.tvshow.TvShowDetailsResponse
import com.adhityabagasmiwa.submissionjetpackpro.data.source.remote.response.tvshow.TvShowItems

typealias moviesGenres = com.adhityabagasmiwa.submissionjetpackpro.data.source.remote.response.movies.GenresItem
typealias tvShowGenres = com.adhityabagasmiwa.submissionjetpackpro.data.source.remote.response.tvshow.GenresItem

object DataDummy {

    fun getMovies(): List<CatalogueEntity> {
        val movies = ArrayList<CatalogueEntity>()

        movies.add(
            CatalogueEntity(
                508943,
                "Luca",
                "/7rhzEufovmmUqVjcbzMHTBQ2SCG.jpg",
                8.3,
                "Luca and his best friend Alberto experience an unforgettable summer on the Italian Riviera. But all the fun is threatened by a deeply-held secret: they are sea monsters from another world just below the water’s surface.",
                "17-06-2021",
                listOf("Animation, Comedy, Family, Fantasy"),
                95,
                972,
                "/3QVSM3DYxvov57j25vxDNJGHUpQ.jpg"
            )
        )
        movies.add(
            CatalogueEntity(
                1,
                "Alita: Battle Angel",
                "/xRWht48C2V8XNfzvPehyClOvDni.jpg",
                7.2,
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "31-01-2019",
                listOf("Action, Science Fiction, Adventure"),
                122,
                6639,
                "/8RKBHHRqOMOLh5qW3sS6TSFTd8h.jpg"
            )
        )
        movies.add(
            CatalogueEntity(
                2,
                "Aquaman",
                "/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
                6.9,
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "07-12-2018",
                listOf("Action, Adventure, Fantasy"),
                143,
                10575,
                "/9QusGjxcYvfPD1THg6oW3RLeNn7.jpg"
            )
        )
        movies.add(
            CatalogueEntity(
                3,
                "Avengers: Infinity War",
                "/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                8.3,
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "25-04-2018",
                listOf("Adventure, Action, Science Fiction"),
                149,
                22017,
                "/lmZFxXgJE3vgrciwuDib0N8CfQo.jpg"
            )
        )
        movies.add(
            CatalogueEntity(
                4,
                "How to Train Your Dragon: The Hidden World",
                "/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg",
                7.8,
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "03-01-2019",
                listOf("Animation, Family, Adventure"),
                104,
                4586,
                "/lFwykSz3Ykj1Q3JXJURnGUTNf1o.jpg"
            )
        )
        movies.add(
            CatalogueEntity(
                5,
                "Spider-Man: Into the Spider-Verse",
                "/iiZZdoQBEYBv6id8su7ImL0oCbD.jpg",
                8.4,
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \\\"Kingpin\\\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                "12-06-2018",
                listOf("Action, Adventure, Animation, Science Fiction, Comedy"),
                117,
                9520,
                "/7d6EY00g1c39SGZOoCJ5Py9nNth.jpg"
            )
        )
        movies.add(
            CatalogueEntity(
                6,
                "Ralph Breaks the Internet",
                "/qEnH5meR381iMpmCumAIMswcQw2.jpg",
                7.2,
                "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, Sugar Rush. In way over their heads, Ralph and Vanellope rely on the citizens of the internet — the netizens — to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.",
                "20-11-2018",
                listOf("Family, Animation, Comedy, Adventure"),
                112,
                5587,
                "/qDQEQbgP3v7B9IYLAUcYexNrVYP.jpg"
            )
        )
        movies.add(
            CatalogueEntity(
                7,
                "Glass",
                "/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
                6.7,
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "16-01-2019",
                listOf("Thriller, Drama, Science Fiction"),
                129,
                6288,
                "/ngBFDOsx13sFXiMweDoL54XYknR.jpg"
            )
        )
        movies.add(
            CatalogueEntity(
                8,
                "Robin Hood",
                "/AiRfixFcfTkNbn2A73qVJPlpkUo.jpg",
                5.9,
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                "21-11-2018",
                listOf("Adventure, Action, Thriller"),
                116,
                2278,
                "/zSJT1sKGRKcmP4I9b8dIOuepw6I.jpg"
            )
        )
        movies.add(
            CatalogueEntity(
                9,
                "Mortal Engines",
                "/gLhYg9NIvIPKVRTtvzCWnp1qJWG.jpg",
                6.1,
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                "27-11-2018",
                listOf("Adventure, Action, Thriller"),
                129,
                3416,
                "/rm2oMykm5nX6SzXFr7TGHkO6r8Z.jpg"
            )
        )
        return movies
    }

    fun getDetailsMovies(): DetailEntity {
        return DetailEntity(
            3,
            "Avengers: Infinity War",
            "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
            149,
            listOf("Adventure, Action, Science Fiction"),
            "/lmZFxXgJE3vgrciwuDib0N8CfQo.jpg",
            "/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
            22017,
            8.3,
            "25-04-2018"
        )
    }

    fun getRemoteMovies(): List<MoviesItems> {
        val movies = ArrayList<MoviesItems>()

        movies.add(
            MoviesItems(
                0,
                "Mortal Engines",
                "/gLhYg9NIvIPKVRTtvzCWnp1qJWG.jpg",
                6.1,
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                "27-11-2018",
                3416,
                "/rm2oMykm5nX6SzXFr7TGHkO6r8Z.jpg"
            )
        )
        movies.add(
            MoviesItems(
                1,
                "Glass",
                "/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
                6.7,
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "16-01-2019",
                6288,
                "/ngBFDOsx13sFXiMweDoL54XYknR.jpg"
            )
        )
        movies.add(
            MoviesItems(
                2,
                "Robin Hood",
                "/AiRfixFcfTkNbn2A73qVJPlpkUo.jpg",
                5.9,
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                "21-11-2018",
                2278,
                "/zSJT1sKGRKcmP4I9b8dIOuepw6I.jpg"
            )
        )
        return movies
    }

    fun getRemoteDetailsMovies(): MoviesDetailsResponse {
        return MoviesDetailsResponse(
            5,
            "Spider-Man: Into the Spider-Verse",
            "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \\\"Kingpin\\\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
            117,
            genres = listOf(
                moviesGenres(
                    id = 28,
                    name = "Action"
                ),
                moviesGenres(
                    id = 12,
                    name = "Adventure"
                ),
                moviesGenres(
                    id = 16,
                    name = "Animation"
                ),
                moviesGenres(
                    id = 878,
                    name = "Science Fiction"
                ),
                moviesGenres(
                    id = 35,
                    name = "Comedy"
                )
            ),
            "/7d6EY00g1c39SGZOoCJ5Py9nNth.jpg",
            9520,
            "/iiZZdoQBEYBv6id8su7ImL0oCbD.jpg",
            "12-06-2018",
            8.4
        )
    }

    fun getTvShows(): List<CatalogueEntity> {
        val tvShows = ArrayList<CatalogueEntity>()

        tvShows.add(
            CatalogueEntity(
                84958,
                "Loki",
                "/kEl2t3OhXc3Zb9FBh1AuYzRTgZp.jpg",
                8.1,
                "After stealing the Tesseract during the events of “Avengers: Endgame,” an alternate version of Loki is brought to the mysterious Time Variance Authority, a bureaucratic organization that exists outside of time and space and monitors the timeline. They give Loki a choice: face being erased from existence due to being a “time variant”or help fix the timeline and stop a greater threat.",
                "09-06-2021",
                listOf("Drama, Sci-Fi & Fantasy"),
                52,
                3762,
                "/wr7nrzDrpGCEgYnw15jyAB59PtZ.jpg"
            )
        )
        tvShows.add(
            CatalogueEntity(
                0,
                "Naruto Shippuden",
                "/zAYRe2bJxpWTVrwwmBc00VFkAf4.jpg",
                8.6,
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                "15-02-2007",
                listOf("Animation, Action & Adventure, Sci-Fi & Fantasy"),
                25,
                5544,
                "/dTFnU3EQB79aDM4HnUj06Y9Xbq1.jpg"
            )
        )
        tvShows.add(
            CatalogueEntity(
                1,
                "The Simpsons",
                "/zLudbPueg8CxGhMS2tyDh3p0TdK.jpg",
                7.8,
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "17-12-1989",
                listOf("Family, Animation, Comedy"),
                22,
                6679,
                "/hpU2cHC9tk90hswCFEpf5AtbqoL.jpg"
            )
        )
        tvShows.add(
            CatalogueEntity(
                2,
                "Family Guy",
                "/eWWCRjBfLyePh2tfZdvNcIvKSJe.jpg",
                7.8,
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "31-01-1999",
                listOf("Action, Adventure, Fantasy"),
                22,
                2810,
                "/jbTqU6BJMufoMnPSlO4ThrcXs3Y.jpg"
            )
        )
        tvShows.add(
            CatalogueEntity(
                3,
                "The Walking Dead",
                "/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg",
                8.1,
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                "31-10-2010",
                listOf("Action & Adventure, Drama, Sci-Fi & Fantasy"),
                49,
                10995,
                "/uro2Khv7JxlzXtLb8tCIbRhkb9E.jpg"
            )
        )
        tvShows.add(
            CatalogueEntity(
                4,
                "Fairy Tail",
                "/jsYTctFnK8ewomnUgcwhmsTkOum.jpg",
                7.8,
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "12-10-2009",
                listOf("Action & Adventure, Animation, Comedy, Sci-Fi & Fantasy, Mystery"),
                25,
                623,
                "/fANxNeH9JCXPrzNEfriGu1Y95dF.jpg"
            )
        )
        tvShows.add(
            CatalogueEntity(
                6,
                "Hanna",
                "/iYUtjx1EN4SVTgxd2TB4cZTGSQb.jpg",
                7.5,
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "28-03-2019",
                listOf("Action & Adventure, Drama"),
                50,
                472,
                "/6Fzyuwn8KeMCSqRILfdrDmCvmod.jpg"
            )
        )
        tvShows.add(
            CatalogueEntity(
                7,
                "Dragon Ball Z",
                "/6VKOfL6ihwTiB5Vibq6QTfzhxA6.jpg",
                8.2,
                "Five years have passed since the fight with Piccolo Jr., and Goku now has a son, Gohan. The peace is interrupted when an alien named Raditz arrives on Earth in a spacecraft and tracks down Goku, revealing to him that that they are members of a near-extinct warrior race called the Saiyans.",
                "26-04-1989",
                listOf("Animation, Sci-Fi & Fantasy, Action & Adventure"),
                26,
                2404,
                "/v7J7q0yMAPbocBgiv39hpAMEcRf.jpg"
            )
        )
        tvShows.add(
            CatalogueEntity(
                8,
                "The Flash",
                "",
                7.7,
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "07-10-2014",
                listOf("Drama, Sci-Fi & Fantasy"),
                44,
                7870,
                "/9Jmd1OumCjaXDkpllbSGi2EpJvl.jpg",
            )
        )
        tvShows.add(
            CatalogueEntity(
                9,
                "Riverdale",
                "/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                8.6,
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "26-01-2017",
                listOf("Adventure, Action, Thriller"),
                45,
                11471,
                "/qZtAf4Z1lazGQoYVXiHOrvLr5lI.jpg"
            )
        )
        return tvShows
    }

    fun getDetailsTvShow(): DetailEntity {
        return DetailEntity(
            0,
            "Naruto Shippuden",
            "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
            25,
            listOf("Animation, Action & Adventure, Sci-Fi & Fantasy"),
            "/dTFnU3EQB79aDM4HnUj06Y9Xbq1.jpg",
            "/zAYRe2bJxpWTVrwwmBc00VFkAf4.jpg",
            5544,
            8.6,
            "15-02-2007"
        )
    }

    fun getRemoteTvShow(): List<TvShowItems> {
        val tvShows = ArrayList<TvShowItems>()

        tvShows.add(
            TvShowItems(
                9,
                "Riverdale",
                "/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                8.6,
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "26-01-2017",
                11471,
                "/qZtAf4Z1lazGQoYVXiHOrvLr5lI.jpg"
            )
        )
        tvShows.add(
            TvShowItems(
                7,
                "Dragon Ball Z",
                "/6VKOfL6ihwTiB5Vibq6QTfzhxA6.jpg",
                8.2,
                "Five years have passed since the fight with Piccolo Jr., and Goku now has a son, Gohan. The peace is interrupted when an alien named Raditz arrives on Earth in a spacecraft and tracks down Goku, revealing to him that that they are members of a near-extinct warrior race called the Saiyans.",
                "26-04-1989",
                2404,
                "/v7J7q0yMAPbocBgiv39hpAMEcRf.jpg"
            )
        )
        tvShows.add(
            TvShowItems(
                8,
                "The Flash",
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                7.7,
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "07-10-2014",
                7870,
                "/9Jmd1OumCjaXDkpllbSGi2EpJvl.jpg",
            )
        )
        return tvShows
    }

    fun getRemoteDetailsTvShow(): TvShowDetailsResponse {
        return TvShowDetailsResponse(
            4,
            "Fairy Tail",
            "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
            genres = listOf(
                tvShowGenres(
                    id = 1075,
                    name = "Action & Adventure"
                ),
                tvShowGenres(
                    id = 16,
                    name = "Animation"
                ),
                tvShowGenres(
                    id = 10765,
                    name = "Sci-Fi & Fantasy"
                ),
                tvShowGenres(
                    id = 1075,
                    name = "Action & Adventure"
                ),
                tvShowGenres(
                    id = 9648,
                    name = "9648"
                )
            ),
            "/fANxNeH9JCXPrzNEfriGu1Y95dF.jpg",
            623,
            "12-10-2009",
            "/jsYTctFnK8ewomnUgcwhmsTkOum.jpg",
            7.8,
            listOf(25)
        )
    }
}
