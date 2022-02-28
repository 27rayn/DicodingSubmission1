package com.example.githubusersubmission1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubusersubmission1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var rvUser: RecyclerView
    private val list = ArrayList<GithubUser>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        rvUser = findViewById(R.id.rv_githubuser)
        rvUser.setHasFixedSize(true)

        list.addAll(listUser)
        showRecyclerList()
    }

    private val listUser: ArrayList<GithubUser>
    get() {
        val dataName = resources.getStringArray(R.array.name)
        val dataUserName = resources.getStringArray(R.array.username)
        val dataPhoto = resources.obtainTypedArray(R.array.avatar)
        val dataFollowers = resources.getStringArray(R.array.followers)
        val dataFollowing = resources.getStringArray(R.array.following)
        val dataCompany = resources.getStringArray(R.array.company)
        val dataLocation = resources.getStringArray(R.array.location)
        val dataRepo = resources.getStringArray(R.array.repository)
        val listuser = ArrayList<GithubUser>()
        for (i in dataName.indices){
            val user = GithubUser(dataPhoto.getResourceId(i, -1), dataName[i],dataUserName[i], dataFollowers[i],
                dataFollowing[i], dataLocation[i], dataCompany[i], dataRepo[i])
            listuser.add(user)
        }
        return listuser
    }

    private fun showRecyclerList(){
        rvUser.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(list)
        rvUser.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback{
            override fun onItemClicked(data: GithubUser) {
                val intentToDetail = Intent(this@MainActivity, UserDetail::class.java)
                intentToDetail.putExtra("DATA", data)
                startActivity(intentToDetail)
            }
        })
    }

}