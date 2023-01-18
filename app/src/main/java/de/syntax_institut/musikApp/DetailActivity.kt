package de.syntax_institut.musikApp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import de.syntax_institut.musikApp.data.Datasource
import de.syntax_institut.musikApp.databinding.DetailActivityBinding

/**
 * Dies ist die Klasse für das zugehörige Layout detail_activity
 */
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: DetailActivityBinding

    /**
     * Die lifecycle methode onCreate
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.detail_activity)


        // Die Informationen werden aus dem intent Objekt geholt
        // TODO Schreibe hier deinen Code
        val titel = intent.extras?.getInt("titelID")

        // Die Informationen werden aus dem intent Objekt geholt
        // TODO Schreibe hier deinen Code
        val cover = intent.extras?.getInt("coverID")

        // Bonus:
        val next = binding.ibNext
        val previous = binding.ibPrevious

        // Die Informationen werden zugewiesen (nach Test auf null)
        // TODO Schreibe hier deinen Code
        binding.tvTitleDetail.text = getString(titel!!)
        binding.ivCoverDetail.setImageResource(cover!!)

        // Share-Button ClickListener
        binding.btnShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, "Sharing is caring")
            intent.type ="text/plain"
            val intent2 = Intent.createChooser(intent,  null)
            startActivity(intent2)
        }

        // Bonus: NEXT-Button ClickListener
        next.setOnClickListener {
            changeSong()
        }

        // Bonus: PREVIOUS-Button ClickListener
        previous.setOnClickListener {
            changeSong()
        }
    }

    fun changeSong(){
        val intent = Intent(this, DetailActivity::class.java)
        val song = Datasource(this).loadSongs().random()
        intent.putExtra("titelID", song.stringResource)
        intent.putExtra("coverID", song.imageResource)
        startActivity(intent)
        finish()
    }
}