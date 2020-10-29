package com.example.aula24

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_a.*


/**
 * A simple [Fragment] subclass.
 * Use the [AFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AFragment : Fragment() {
    private lateinit var viewModel: cadastroViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {
            viewModel = ViewModelProvider(it).get(cadastroViewModel::class.java)

            val act = activity as MainActivity

            btCadastrar.setOnClickListener {
                //act.changeFragment(1)
                //act.tabLayout.getTabAt(1)?.select()
                viewModel.setOnChangeTab(1)
            }

            etNomeEmpresa.doAfterTextChanged {
                //viewModel.onNomeChange.postValue(it.toString())
                viewModel.setOnNomeChange(it.toString())
            }
        }

    }

}