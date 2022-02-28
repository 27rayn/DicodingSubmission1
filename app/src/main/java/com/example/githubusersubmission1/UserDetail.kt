package com.example.githubusersubmission1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.githubusersubmission1.databinding.ActivityUserDetailBinding

class UserDetail : AppCompatActivity() {

    private lateinit var mBindingDetail : ActivityUserDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBindingDetail = ActivityUserDetailBinding.inflate(layoutInflater)
        val view = mBindingDetail.root
        setContentView(view)


        val data : GithubUser = intent.getParcelableExtra<GithubUser>("DATA") as GithubUser

        mBindingDetail.photoProfile.setImageResource(data.avatar)
        mBindingDetail.nameDetail.text = data.name
        mBindingDetail.usernameDetail.text = data.username
        mBindingDetail.followersNum.text = data.followers
        mBindingDetail.followingNum.text = data.following
        mBindingDetail.locationDetail.text = data.location
        mBindingDetail.companyDetail.text = data.company
        mBindingDetail.repositoryDetail.text = data.repository

//        val userNameDetail = findViewById<TextView>(R.id.username_detail)
//        val nameDetail = findViewById<TextView>(R.id.name_detail)
//        val ProfilePhoto = findViewById<ImageView>(R.id.photo_profile)
//        val following = findViewById<TextView>(R.id.following)

    }
}