package ly.youcan.mylistview.listview2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import ly.youcan.mylistview.R

class listviewActivity : AppCompatActivity() {
    private lateinit var listview:ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listview)

        listview=findViewById(R.id.mylistview)
        val arrayname=ArrayList<Names>()
        arrayname.add(Names("Mohamed",15,"09171508",R.drawable.a))
        arrayname.add(Names("ali",20,"09171508",R.drawable.a))
        arrayname.add(Names("ali",20,"09171508",R.drawable.a))
        arrayname.add(Names("Mohamed",25,"09171508",R.drawable.a))
        arrayname.add(Names("ahmed",18,"09171508",R.drawable.a))
        arrayname.add(Names("ahmed",18,"09171508",R.drawable.a))
        arrayname.add(Names("fatima",27,"09171508",R.drawable.a))
        arrayname.add(Names("sara",16,"09171508",R.drawable.a))
        arrayname.add(Names("sara",16,"09171508",R.drawable.a))

        val myadapter=MyAdapter(this,arrayname)
        listview.adapter=myadapter
//        listview.onItemClickListener =
//            AdapterView.OnItemClickListener { _, view, _, _ ->
//                val txtv =view as TextView
//
//                Toast.makeText(this,txtv.text.toString(),Toast.LENGTH_SHORT).show()
//            }

    }


}

//private var arrayList= arrayOf(
//    "mohamed","ali","sara","ali","mohamed","jack",
//    "mohamed","ali","sara","ali","mohamed","jack",
//    "mohamed","ali","sara","ali","mohamed","jack",
//)

//listview.adapter=myadapter
//listview.onItemClickListener =
//AdapterView.OnItemClickListener { _, view, _, _ ->
//    val txtv =view as TextView
//
//    Toast.makeText(this,txtv.text.toString(),Toast.LENGTH_SHORT).show()
//}