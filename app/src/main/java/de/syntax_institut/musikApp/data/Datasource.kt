package de.syntax_institut.musikApp.data

import android.content.Context
import de.syntax_institut.musikApp.data.model.Song
import kotlin.random.Random

class Datasource(private val context: Context) {

    private val nrOfCovers = 10 // anpassen, wenn Anzahl an Covers geändert wurde
    private val numberOfSongs = 30 // anpassen, wenn Anzahl an Songs geändert wurde

    /**
     * Diese Funktion holt die Titel & Bilder aus der Quelldatei
     * und liefert eine Liste aus Songs zurück
     */
    fun loadSongs(): List<Song> {
        // Die Liste an Songs
        val songs = mutableListOf<Song>()

        // Befülle die Liste
        for (index in 1..numberOfSongs) {

            // Hole den Titel & Bild und generiere eine zufällige Songlänge
            val title = getSongTitle(index)
            val image = getCover()
            fun rndNr(max: Int) = Random.nextInt(0,max)
            val length = "0${rndNr(10)}:${rndNr(6)}${rndNr(6)}"

            // Füge ein Song Objekt hinzu
            songs.add(

                Song(title, image, length)

            )
        }
        return songs
    }

    /**
     * Diese Funktion liefert den Titel Nummer index aus der Quelle
     */
    private fun getSongTitle(index: Int): Int {
        return context.resources.getIdentifier(
            "songTitle$index",
            "string",
            context.packageName
        )
    }

    private var iPrevious = 0
    /**
     * Diese Funktion liefert ein zufälliges Bild aus der Bilderquelle
     */
    private fun getCover(): Int {
        var i: Int
        // kein Cover soll zweimal hintereinander kommen
        while (true) {
            i = Random.nextInt(1, nrOfCovers + 1)
            if (iPrevious != i) {
                iPrevious = i
                break
            }
        }
        // Liefere das entsprechende Cover aus der Quelle
        return context.resources.getIdentifier(
            "cover_$i",
            "drawable",
            context.packageName
        )
    }
}
