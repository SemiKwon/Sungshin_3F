package org.techtown.sungshin3f

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.techtown.sungshin3f.databinding.ActivityNewRecMainBinding

class NewRecMainActivity : AppCompatActivity() {
    private var mBinding: ActivityNewRecMainBinding?=null
    private val binding get()=mBinding!!
    companion object{
        var checkbool=Array<Boolean>(5,{index->false})
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityNewRecMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.newbtn.setOnClickListener{
            var newIntent= Intent(this,Newwebtoon::class.java)
            startActivity(newIntent)
        }
        binding.recbtn.setOnClickListener{
            for(i in 0..4){
                checkbool[i]=false
            }
            var recIntent= Intent(this,Recwebtoon::class.java)
            startActivity(recIntent)
        }
    }
}