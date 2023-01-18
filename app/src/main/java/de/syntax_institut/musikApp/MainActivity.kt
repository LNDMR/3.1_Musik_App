package de.syntax_institut.musikApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import de.syntax_institut.musikApp.adapter.ItemAdapter
import de.syntax_institut.musikApp.data.Datasource
import de.syntax_institut.musikApp.databinding.ActivityMainBinding

/**
 * Diese Klasse stellt den Entry Point für die App dar
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    /**
     * Die lifecycle onCreate Methode
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Liste aus Filmtiteln wird von der Datasource geladen
        val songs = Datasource(this).loadSongs()

        // recyclerView von Layout wird mit code verknüpft
        val recyclerView = binding.recyclerView

        // ItemAdapter wird als Adapter festgelegt
        recyclerView.adapter = ItemAdapter(this, songs)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // verbesserte Performance bei fixer Größe
        recyclerView.setHasFixedSize(true)
    }
}