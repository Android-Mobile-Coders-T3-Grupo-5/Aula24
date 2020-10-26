package com.example.aula24

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_b.*


/**
 * A simple [Fragment] subclass.
 * Use the [BFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BFragment : Fragment() {
    private lateinit var viewModel : cadastroViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {
            viewModel = ViewModelProvider(it).get(cadastroViewModel::class.java)

            viewModel.onNomeChange.observe(viewLifecycleOwner) {
                tvNomeEmpresa.text = it
            }

            btVoltar.setOnClickListener {
                val act = activity as MainActivity
                act.changeFragment(0)
            }
        }
    }

}