package com.example.library2.withfragmenttransactionreplacing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.library2.R
import com.example.library2.databinding.ActivityFragmentTransactionReplaceMainBinding
import com.example.library2.withnavcomponent.MainFragment

class FragmentTransactionReplaceMainActivity : AppCompatActivity() {
    lateinit var binding: ActivityFragmentTransactionReplaceMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityFragmentTransactionReplaceMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val mainFragment = MainFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.activity_main, mainFragment).commit()
    }
}