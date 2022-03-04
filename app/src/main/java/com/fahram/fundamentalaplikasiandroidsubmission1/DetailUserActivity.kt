package com.fahram.fundamentalaplikasiandroidsubmission1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fahram.fundamentalaplikasiandroidsubmission1.databinding.ActivityDetailUserBinding

class DetailUserActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailUserBinding

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User
        binding.ivAvatarDetail.setImageResource(user.avatar)
        binding.tvNameDetail.text = user.name
        binding.tvUsernameDetail.text = user.username
        binding.tvLocationDetail.text = user.location
        binding.tvCompanyDetail.text = user.company
        binding.tvRepositoryDetail.text = user.repository
        binding.tvFollowerDetail.text = user.followers
        binding.tvFollowingDetail.text = user.following
        binding.btnShare.setOnClickListener {
            val share = Intent.createChooser(Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "https://github.com/${user.username}")
                type = "text/plain"
            }, null)
            startActivity(share)
        }
    }
}