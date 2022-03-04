package com.fahram.fundamentalaplikasiandroidsubmission1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.fahram.fundamentalaplikasiandroidsubmission1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvUsers.setHasFixedSize(true)

        list.addAll(listUsers)
        binding.rvUsers.layoutManager = LinearLayoutManager(this)
        val userAdapter = UserAdapter(list){
            data -> showUserDetail(data)
        }
        binding.rvUsers.adapter = userAdapter
    }

    private fun showUserDetail(data: User) {
        val intent = Intent(this@MainActivity, DetailUserActivity::class.java)
        intent.putExtra(DetailUserActivity.EXTRA_USER, data)
        Log.d(DetailUserActivity.EXTRA_USER,data.toString())
        startActivity(intent)
    }

    private val listUsers: ArrayList<User>
    get() {
        val users = ArrayList<User>()
        val username = resources.getStringArray(R.array.username)
        val name = resources.getStringArray(R.array.name)
        val avatar = resources.obtainTypedArray(R.array.avatar)
        val location = resources.getStringArray(R.array.location)
        val repository = resources.getStringArray(R.array.repository)
        val company = resources.getStringArray(R.array.company)
        val followers = resources.getStringArray(R.array.followers)
        val following = resources.getStringArray(R.array.following)
        Log.d("Followers", followers.toString())
        for (i in name.indices){
            users.add(User(
                username[i],
                name[i],
                avatar.getResourceId(i,0),
                location[i],
                repository[i],
                company[i],
                followers[i],
                following[i],
            ))
        }
        return users
    }
}