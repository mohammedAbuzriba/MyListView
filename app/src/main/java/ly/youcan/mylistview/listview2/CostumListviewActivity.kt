package ly.youcan.mylistview.listview2

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ly.youcan.mylistview.R
import ly.youcan.mylistview.UserActivity
import ly.youcan.mylistview.databinding.ActivityCostumListviewBinding
import ly.youcan.mylistview.databinding.AlertLayoutDialogBinding

class CostumListviewActivity : AppCompatActivity(), TextWatcher,OnSetClick {
    //private lateinit var binding: ActivityCostumListviewBinding

    private lateinit var recyclerView: RecyclerView
    private lateinit var btnAdd: Button
    private lateinit var txt: EditText
    lateinit var myadapter: CoustemAdapter
    var arrayname=ArrayList<Names>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_costum_listview)


        arrayname.add(Names("Mohamed",15,"09171508",R.drawable.ic_launcher_background))
        arrayname.add(Names("ali",20,"09171508",R.drawable.ic_launcher_background))
        arrayname.add(Names("Mohamed",25,"09171508",R.drawable.ic_launcher_background))
        arrayname.add(Names("ahmed",18,"09171508",R.drawable.ic_launcher_background))
        arrayname.add(Names("fatima",27,"09171508",R.drawable.ic_launcher_background))
        arrayname.add(Names("sara",16,"09171508",R.drawable.ic_launcher_background))

        recyclerView= findViewById(R.id.mylistrecycle)
        btnAdd= findViewById(R.id.button)
        txt= findViewById(R.id.editTextTextPersonName)
        txt.addTextChangedListener(this)
        recyclerView.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)

        btnAdd.setOnClickListener(){
//            arrayname.add(Names(txt.text.toString(),0,"09171508",R.drawable.ic_launcher_background))
            if (txt.text.isEmpty())
                addPostDialog()
            else{
                serch(txt.text.toString())
            }
//            myadapter=CoustemAdapter(this,arrayname)
//
//            recyclerView.adapter=myadapter

        }

        recyclerView.isClickable=true

        myadapter=CoustemAdapter(this,arrayname)
        myadapter.onClick=this
        recyclerView.adapter=myadapter

//        recyclerView.setOnClickListener(){
//
//                val i = Intent(this,UserActivity::class.java)
//                startActivity(i)
//        }
    }

    private fun serch(name: String) {

        myadapter=CoustemAdapter(this,arrayname)
        recyclerView.adapter=myadapter
    }


    private fun addPostDialog(){

        val mBinding = AlertLayoutDialogBinding.inflate(layoutInflater)
        val mDialog = Dialog(this)
        mDialog.setContentView(mBinding.root)
        mBinding.btnCancel.setOnClickListener(){
            mDialog.dismiss()
        }


        mBinding.btnpost.setOnClickListener(){



            if (mBinding.name.text.toString().isNotEmpty() && mBinding.age.text.toString().isNotEmpty())
            {
                arrayname.add(Names(mBinding.name.text.toString(),mBinding.age.text.toString().toInt(),mBinding.phone.text.toString(),R.drawable.ic_launcher_background))

                myadapter=CoustemAdapter(this,arrayname)
                recyclerView.adapter=myadapter
                Toast.makeText(this,
                    "add done successfully",
                    Toast.LENGTH_SHORT).show()
                mDialog.dismiss()
            }else{
                Toast.makeText(this,
                    "Title and body can't be empty",
                    Toast.LENGTH_SHORT).show()
            }


        }


        mDialog.show()

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {


    }

    override fun afterTextChanged(s: Editable?) {
        val name = txt.text.toString()
        var arraynamefilter:ArrayList<Names>
        if (txt.text.isNotEmpty())
        {
            arraynamefilter = arrayname.filter { it.name.startsWith(name) } as ArrayList<Names>
        }
        else{
            arraynamefilter = arrayname
        }
        myadapter=CoustemAdapter(this,arraynamefilter)
        recyclerView.adapter=myadapter
    }

    override fun onItemClick(name: Names) {

        val i = Intent(this, UserActivity::class.java)
        i.putExtra("name",name.name)
        i.putExtra("phone",name.phon)
        i.putExtra("country",name.age)
        i.putExtra("imageId",name.image)

        startActivity(i)
    }

    override fun addItem(context: CoustemAdapter, position: Int, name: Names) {
        context.names.add(position,name)
        context.notifyItemRemoved(position)
        context.notifyItemRangeChanged(position,arrayname.size)
    }

    override fun removeItem(context:CoustemAdapter,position: Int) {
        context.names.removeAt(position)
        context.notifyItemRemoved(position)
        context.notifyItemRangeChanged(position,context.names.size)
    }


}