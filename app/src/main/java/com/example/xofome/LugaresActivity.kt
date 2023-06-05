package com.example.xo

import com.example.xofome.LugarModelo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class LugaresActivity : AppCompatActivity() {
    private lateinit var lugaresRecyclerView: RecyclerView
    private lateinit var tvLoadingData: TextView
    private lateinit var lugaresList: ArrayList<LugarModelo>
    private lateinit var dbRef: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lugares)

        lugaresRecyclerView = findViewById(R.id.listLugares)
        lugaresRecyclerView.layoutManager = LinearLayoutManager(this)
        lugaresRecyclerView.setHasFixedSize(true)
        tvLoadingData = findViewById(R.@+tvLoadingData)

        lugaresList = arrayListOf<LugarModelo>()

        getLugaresData()
    }

    private fun getLugaresData() {
        lugaresRecyclerView.visibility = View.GONE
        tvLoadingData.visibility = View.GONE

        dbRef = FirebaseDatabase.getInstance().getReference("Lugar")

        dbRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                lugaresList.clear()
                if(snapshot.exists()){
                    for (lugaresSnap in snapshot.children){
                        val lugarData = lugaresSnap.getValue(LugarModelo::class.java)
                        lugaresList.add(lugarData!!)
                    }
                    val mAdapter = LugaresAdapter(lugaresList)
                    lugaresRecyclerView.adapter = mAdapter

                    lugaresRecyclerView.visibility = View.VISIBLE
                    tvLoadingData.visibility = View.GONE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}