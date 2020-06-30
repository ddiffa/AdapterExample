package dev.hellodiffa.recyclerviewadapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_user.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter : UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = UserAdapter(this::onItemClick)
        val layoutManager = LinearLayoutManager(this)
        rvUsers.adapter = adapter
        rvUsers.layoutManager = layoutManager
        rvUsers.addItemDecoration(DividerItemDecoration(applicationContext, layoutManager.orientation))

        adapter.dataSource = getDataUser()
    }

    private fun onItemClick(user : User){

        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("data", user)
        startActivity(intent)
    }

    private fun getDataUser() : MutableList<User>{
        val listUser = mutableListOf<User>()
        val dataName = resources.getStringArray(R.array.username)
        val dataAddress = resources.getStringArray(R.array.address)

        for (i : Int in dataName.indices){
            listUser.add(User(username = dataName[i], address = dataAddress[i]))
        }
        return listUser

    }
}