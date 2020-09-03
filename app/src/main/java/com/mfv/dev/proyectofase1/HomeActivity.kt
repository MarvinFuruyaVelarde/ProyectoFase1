package com.mfv.dev.proyectofase1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mfv.dev.proyectofase1.adapter.PetAdapter
import com.mfv.dev.proyectofase1.model.Pet
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), PetAdapter.OnPetClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupRecycler()

    }

    private fun setupRecycler(){
        recycler_view.layoutManager = LinearLayoutManager(this)
        val petList: List<Pet> = listOf<Pet>(Pet("Tom", "https://i.pinimg.com/originals/44/b1/0c/44b10c08db645d8f4fc0075c63669e67.jpg"),
            Pet("Bethoven", "https://tvazteca.brightspotcdn.com/dims4/default/95276e3/2147483647/strip/true/crop/1920x1080+0+0/resize/968x545!/format/jpg/quality/80/?url=https%3A%2F%2Ftvazteca.brightspotcdn.com%2Fb4%2Fde%2F8f2cef81417da88c70c3f922f368%2Fperro-ataca-gemelas.jpg"),
            Pet("Chelo", "https://previews.123rf.com/images/azalia/azalia1311/azalia131100062/23560215-gatito-rayado-gris-gatito-rayado-con-los-ojos-azules-gatito-en-un-fondo-blanco-peque%C3%B1o-depredador-.jpg"),
            Pet("Rambo", "https://tvazteca.brightspotcdn.com/dims4/default/09d017c/2147483647/strip/true/crop/1920x1080+0+0/resize/968x545!/format/jpg/quality/80/?url=https%3A%2F%2Ftvazteca.brightspotcdn.com%2F09%2F53%2Fb0f0e2bc4f838f4b24da4a567d09%2Fperro-contagiado-covid-19.jpg"),
            Pet("Toby", "https://previews.123rf.com/images/pr3t3nd3r/pr3t3nd3r1612/pr3t3nd3r161200002/67724762-el-retrato-del-l%C3%A1piz-de-un-peque%C3%B1o-gatito-gris-con-ojos-azules-brillantes-en-blanco.jpg"),
            Pet("Pimpa", "https://i.pinimg.com/564x/3d/53/21/3d5321f355e90b010e2b475ac518ccf3.jpg")
        )

        recycler_view.adapter = PetAdapter(this, petList, this)
    }

    override fun OnItemClick(item: Pet) {
        val intent = Intent(this, PetActivity::class.java)
        intent.putExtra("imgURL", item.img)
        startActivity(intent)
    }

}