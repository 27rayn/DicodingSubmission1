package com.example.githubusersubmission1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUser(
    var avatar: Int,
    var name: String,
    var username: String,
    var followers: String,
    var following: String,
    var company: String,
    var repository: String,
    var location: String
) : Parcelable
