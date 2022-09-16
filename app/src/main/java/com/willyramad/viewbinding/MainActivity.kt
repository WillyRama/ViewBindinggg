package com.willyramad.viewbinding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.willyramad.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adapter: BeritaAdapter
    lateinit var vmBerita : BeritaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        DataBerita()
        vmBerita = ViewModelProvider(this).get(BeritaViewModel::class.java)
        vmBerita.getBerita()
        vmBerita.vmListBerita.observe(this, Observer {
          adapter.datBerita(it as ArrayList<Berita> /* = java.util.ArrayList<com.willyramad.viewbinding.Berita> */)
        })
        adapter.onClick = {
            val bun = Bundle()
            bun.putSerializable("dataBerita", it)

            val pindah = Intent(this, DetailActivity::class.java)
            pindah.putExtras(bun)
            startActivity(pindah)
        }
    }
        fun DataBerita() {
            adapter = BeritaAdapter(ArrayList())

            binding.rvBerita.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.rvBerita.adapter = adapter

    }
}