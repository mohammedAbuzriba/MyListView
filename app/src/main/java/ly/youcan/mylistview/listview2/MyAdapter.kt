package ly.youcan.mylistview.listview2

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import ly.youcan.mylistview.R

class MyAdapter(context:Context,names:ArrayList<Names>)
    :ArrayAdapter<Names>(context, R.layout.costumviewnames,names){

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val listviewitem = LayoutInflater.from(context).inflate( R.layout.costumviewnames,parent,false)
        val name= getItem(position)


        listviewitem.findViewById<TextView>(R.id.textView6).text = name!!.name
        listviewitem.findViewById<TextView>(R.id.textView8).text = name!!.phon
        listviewitem.findViewById<TextView>(R.id.textView7).text = name!!.age.toString()
        listviewitem.findViewById<ImageView>(R.id.imageView4).setImageResource(name.image)

        return listviewitem
    }

}