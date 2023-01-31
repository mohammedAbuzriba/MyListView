package ly.youcan.mylistview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ly.youcan.mylistview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var userArrayList:ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageId = intArrayOf(
            R.drawable.a,
            R.drawable.ic_launcher_background,
            R.drawable.a,
            R.drawable.ic_launcher_background,

        )
        val  name = arrayOf(
            "mohamed",
            "ali",
            "ahmed",
            "omar",
        )
        val  lastMassage = arrayOf(
            "Hellow",
            "wher is it",
            "how are you",
            "hi",
        )
        val  lastMassageTime = arrayOf(
            "5:00 pm",
            "7:00 am",
            "8:30 pm",
            "9:45 pm",
        )
        val  phoneNo = arrayOf(
            "09171508",
            "09171598",
            "09271408",
            "09271558",
        )
        val  country = arrayOf(
            "libya",
            "spane",
            "france",
            "italy",
        )

        userArrayList= ArrayList()
        for (i in name.indices){
            val user = User(name[i],lastMassage[i],lastMassageTime[i],phoneNo[i],country[i],imageId[i])
            userArrayList.add(user)
        }
        binding.listview.isClickable=true
        binding.listview.adapter=MyAdapter(this,userArrayList)
        binding.listview.setOnItemClickListener{
            parent,view,positon,id->
            val name = name[positon]
            val phone = phoneNo[positon]
            val country = country[positon]
            val imageId = imageId[positon]
            val i = Intent(this,UserActivity::class.java)
            i.putExtra("name",name)
            i.putExtra("phone",phone)
            i.putExtra("country",country)
            i.putExtra("imageId",imageId)
            startActivity(i)
        }
    }
}