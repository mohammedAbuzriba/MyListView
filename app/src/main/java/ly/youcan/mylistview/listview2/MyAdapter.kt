package ly.youcan.mylistview.listview2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.android.material.snackbar.Snackbar
import ly.youcan.mylistview.R

class CoustemAdapter(val context: CostumListviewActivity,val names:ArrayList<Names>):RecyclerView.Adapter<CoustemAdapter.MyViewHolder>(){

    var onClick:OnSetClick?=context

    inner class MyViewHolder(itemView: View): ViewHolder(itemView){
        val txtView = itemView.findViewById(R.id.title) as TextView
        val txtView2 = itemView.findViewById(R.id.body) as TextView
        val imgView = itemView.findViewById(R.id.logo) as ImageView
        val add = itemView.findViewById(R.id.add) as Button
        val remov = itemView.findViewById(R.id.remov) as Button
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val listviewitem = LayoutInflater.from(parent.context).inflate( R.layout.listpranditem,parent,false)

        return MyViewHolder(listviewitem)
    }

    override fun getItemCount(): Int {
        return names.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val name = names[position]
        holder.txtView.text = name.name
        holder.txtView2.text = name.phon
        holder.imgView.setImageResource(name.image)

        holder.imgView.setOnClickListener(){
            Snackbar.make(it,name.name, Snackbar.LENGTH_SHORT).show()

        }
        holder.itemView.setOnClickListener(){

            onClick?.onItemClick(name=name)

        }

        holder.add.setOnClickListener(){
            onClick?.addItem(this,position,name)
        }
        holder.remov.setOnClickListener(){
            onClick?.removeItem(this,position)
        }

    }

    private fun addItem(position: Int, name: Names) {
        names.add(position,name)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position,names.size)

    }


    private fun removeItem(position: Int) {
        names.removeAt(position)
        notifyItemRemoved(position)

        notifyItemRangeChanged(position,names.size)

    }


}


//holder.itemView.setOnClickListener(){
////            Snackbar.make(it,"UserId: ${name.name}\nId: ${name.age}", Snackbar.LENGTH_SHORT).show()
////
////            val i = Intent(context, UserActivity::class.java)
////            i.putExtra("name",name.name)
////            i.putExtra("phone",name.phon)
////            i.putExtra("country",name.age)
////            i.putExtra("imageId",name.image)
////
////            context.startActivity(i)
//
//    onClick?.onItemClick(name=name)
//
//}

fun myList(){
    class MyAdapter(context:Context,names:ArrayList<Names>)
        :ArrayAdapter<Names>(context, R.layout.costumviewnames,names){

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
}
