package ly.youcan.mylistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ly.youcan.mylistview.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name=intent.getStringExtra("name")
        val phone=intent.getStringExtra("phone")
        val country=intent.getIntExtra("country",0)
        val imageId=intent.getIntExtra("imageId",R.drawable.a)

        binding.textViewname.text=name
        binding.textViewphone.text=phone
        binding.textViewcountry.text=country.toString()
        binding.imageView.setImageResource(imageId)
    }
}