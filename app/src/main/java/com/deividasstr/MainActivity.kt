package com.deividasstr

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentFactory
import com.deividasstr.app.R
import com.deividasstr.app.databinding.ActivityMainBinding
import com.deividasstr.newfragment.NewFragment
import com.deividasstr.newhost.NewHostFragment
import com.deividasstr.oldfragment.OldFragment
import com.deividasstr.oldhost.OldHostFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainActivity : FragmentActivity(), HasAndroidInjector {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var navController: NavController

    @Inject
    lateinit var fragmentFactory: FragmentFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        supportFragmentManager.fragmentFactory = fragmentFactory
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

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }
}