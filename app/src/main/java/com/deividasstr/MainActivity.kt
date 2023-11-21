package com.deividasstr

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentFactory
import com.deividasstr.app.R
import com.deividasstr.app.databinding.ActivityMainBinding
import com.deividasstr.base.VintedFragmentCreator
import com.deividasstr.newfragment.NewFragment
import com.deividasstr.newhost.NewHostFragment
import com.deividasstr.oldfragment.OldFragment
import com.deividasstr.oldhost.OldHostFragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : FragmentActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        val entryPoint = EntryPointAccessors.fromActivity(
            this,
            DefaultFragmentFactoryEntryPoint::class.java
        )
        val fragmentFactory = entryPoint.getFragmentFactory()
        supportFragmentManager.fragmentFactory = fragmentFactory

        navController = NavController(
            VintedFragmentCreator(fragmentFactory),
            this
        )

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.oldFragment.setOnClickListener {
            navController.goTo(OldFragment())
        }
        binding.newFragment.setOnClickListener {
            navController.goTo(NewFragment) { with("inflate") }
        }

        binding.oldHostFragment.setOnClickListener {
            navController.goTo(OldHostFragment())
        }
        binding.newHostFragment.setOnClickListener {
            navController.goTo(NewHostFragment) { with("inflate2") }
        }
    }
}