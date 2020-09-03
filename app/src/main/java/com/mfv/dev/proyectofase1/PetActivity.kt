package com.mfv.dev.proyectofase1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.mfv.dev.proyectofase1.adapter.PetAdapter
import kotlinx.android.synthetic.main.activity_pet.*

class PetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet)

        if(intent.extras != null){
            Glide.with(this).load(intent.getStringExtra("imgURL")).into(photo_View)
        }
    }
}