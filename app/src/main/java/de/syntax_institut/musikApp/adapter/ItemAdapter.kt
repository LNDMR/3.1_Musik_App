package de.syntax_institut.musikApp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import de.syntax_institut.musikApp.DetailActivity
import de.syntax_institut.musikApp.R
import de.syntax_institut.musikApp.data.model.Song

/**
 * Der Item Adapter weist den views im ViewHolder den Inhalt zu
 */
class ItemAdapter(
    private val context: Context,
    private val dataset: List<Song>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    /**
     * der ViewHolder umfasst die View und stellt einen Listeneintrag dar
     */
    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTitle: TextView = itemView.findViewById(R.id.tv_songTitle)
        val imageViewCover: ImageView = itemView.findViewById(R.id.iv_songCover)
        val textViewLength: TextView = itemView.findViewById(R.id.tv_songLength)

        // Verweis auf die CardView, damit die gesamte View klickbar ist
        // TODO Schreibe hier deinen Code
        val cardView: CardView = itemView.findViewById(R.id.item_cardView)
    }

    /**
     * hier werden neue ViewHolder erstellt
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        // das itemLayout wird gebaut
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        // und in einem ViewHolder zurückgegeben
        return ItemViewHolder(itemLayout)
    }

    /**
     * hier findet der Recyclingprozess statt
     * die vom ViewHolder bereitgestellten Parameter erhalten die Information des Listeneintrags
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // Hole das song Objekt für die enthaltenen Informationen
        val song = dataset[position]

        // Hole die Elemente aus dem ViewHolder
        val title = holder.textViewTitle
        val length = holder.textViewLength
        val cover = holder.imageViewCover

        // TODO Schreibe hier deinen Code
        val card = holder.cardView

        // Setze Attribute
        title.text = context.resources.getString(song.stringResource)
        cover.setImageResource(song.imageResource)
        length.text = song.songLength

        // setze einen onClickListener für die CardView
        // TODO Schreibe hier deinen Code

        card.setOnClickListener {
            // Expliziter Intent
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("titelID",song.stringResource)
            intent.putExtra("coverID",song.imageResource)
            context.startActivity(intent)
        }

        // TODO rausfinden, warum das nicht einzeln klappt
        //title.setOnClickListener {
        //    // Expliziter Intent
        //    val intent = Intent(context, DetailActivity::class.java)
        //    intent.putExtra("titelID",song.stringResource)
        //    intent.putExtra("coverID",song.imageResource)
        //    context.startActivity(intent)
        //}
//
        //length.setOnClickListener {
        //    val intent = Intent(context, DetailActivity::class.java)
        //    intent.putExtra("titelID",song.stringResource)
        //    intent.putExtra("coverID",song.imageResource)
        //    context.startActivity(intent)
        //}
//
        //cover.setOnClickListener {
        //    val intent = Intent(context, DetailActivity::class.java)
        //    intent.putExtra("titelID",song.stringResource)
        //    intent.putExtra("coverID",song.imageResource)
        //    context.startActivity(intent)
        //}
    }


    /**
     * damit der LayoutManager weiß, wie lang die Liste ist
     */
    override fun getItemCount(): Int {
        return dataset.size
    }
}
