package com.example.changerscodechallenge.ui

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.changerscodechallenge.R
import com.example.changerscodechallenge.ServiceLocator
import com.example.changerscodechallenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var viewModelFactory = MainViewModelFactory(ServiceLocator.getRepository())
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        adapter = MainAdapter()

        binding.recyclerView.adapter = adapter

        val activity = this

        val viewModel = ViewModelProvider(activity ,viewModelFactory).get(MainViewModel::class.java)

        viewModel.getBreeds().observe(this, { it ->

            val dogBreeds = it.map { breed ->
                breed.name
            }

            val indexesOfBreeds = it.map { breed ->
                breed.id
            }

            val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, dogBreeds)

            arrayAdapter.also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                binding.spinnerDogBreed.adapter = adapter
            }


            binding.spinnerDogBreed.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        p0: AdapterView<*>?,
                        p1: View?,
                        position: Int,
                        id: Long
                    ) {
                        viewModel.searchDogByBreed(indexesOfBreeds[position].toString()).observe(activity, {
                            adapter.submitList(it)
                        })
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {
                    }

                }
        })

    }
}