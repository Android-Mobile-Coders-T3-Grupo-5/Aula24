package com.example.aula24

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: cadastroViewModel

    val afrag = AFragment()
    val bfrag = BFragment()
    var active = Fragment()
    //val fm = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(cadastroViewModel::class.java)

        // active = afrag
        //fm.beginTransaction().add(R.id.container, afrag, "0").commit()
        //supportFragmentManager.beginTransaction().replace(R.id.container, afrag).commit()
        changeFragment(0)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        changeFragment(0)
                    }
                    1 -> changeFragment(1)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) { /* sem usar */ }

            override fun onTabReselected(tab: TabLayout.Tab?) { /* sem usar */ }
        })

        viewModel.onChangeTab.observe(this, {
            tabLayout.getTabAt(it)?.select()
        })

    }

    fun changeFragment(newFrag: Int) {
        when(newFrag) {
            0 -> {
                //fm.beginTransaction().hide(active)
                //    .show(afrag).commit()
                supportFragmentManager.beginTransaction().replace(R.id.container, afrag).commit()

                // active = afrag
            }
            1 -> {
                //if(fm.findFragmentByTag("1") == null)
                //    fm.beginTransaction().hide(active)
                //        .add(R.id.container, bfrag,"1").commit()
                //else
                //    fm.beginTransaction().hide(active)
                //        .show(bfrag).commit()
                supportFragmentManager.beginTransaction().replace(R.id.container, bfrag).commit()

                // active = bfrag
            }
        }
    }
}