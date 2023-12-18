package com.example.admincarpertstoremmec

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot

class OrderInfo : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userArrayList: ArrayList<user>
    private lateinit var orderAdapter: OrderAdapter
    private lateinit var db: FirebaseFirestore




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_info)

        recyclerView = findViewById(R.id.orderedProducts)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        userArrayList = arrayListOf()

        orderAdapter = OrderAdapter(userArrayList)

        recyclerView.adapter = orderAdapter

        EventChangeListner()


    }

    private fun EventChangeListner() {
        db = FirebaseFirestore.getInstance()
        db.collection("Products").
                addSnapshotListener(object: EventListener<QuerySnapshot>{
                    override fun onEvent(
                        value: QuerySnapshot?,
                        error: FirebaseFirestoreException?
                    ) {
                        if (error != null) {
                            Log.e("Firestore Error: ",error.message.toString())
                            return

                        }

                        for (dc: DocumentChange in value?.documentChanges!!){
                            if(dc.type == DocumentChange.Type.ADDED){
                                userArrayList.add(dc.document.toObject(user::class.java))
                            }
                        }

                        orderAdapter.notifyDataSetChanged()

                    }

                })
    }
}