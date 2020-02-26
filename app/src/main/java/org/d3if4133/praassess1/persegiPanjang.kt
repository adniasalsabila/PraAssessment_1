package org.d3if4133.praassess1


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.fragment_persegi_panjang.*
import org.d3if4133.praassess1.databinding.FragmentPersegiPanjangBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class persegiPanjang: Fragment() {
    lateinit var binding : FragmentPersegiPanjangBinding

    @SuppressLint("StringFormatInvalid")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<org.d3if4133.praassess1.databinding.FragmentPersegiPanjangBinding>(inflater, R.layout.fragment_persegi_panjang, container, false)

        if (savedInstanceState != null){
            binding.luasPpj.text = savedInstanceState.getString(tv_LuasPpjg.toString(),binding.luasPpj.text.toString())
            binding.kelilingPpj.text = savedInstanceState.getString(tv_KelPjg.toString(), binding.kelilingPpj.text.toString())
        }

        binding.btHitung1.setOnClickListener {
            if(binding.editPanjang.text.isEmpty() || binding.editLebar.text.isEmpty()){
                Toast.makeText(context, "inputan tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }

            var panjang  = binding.editPanjang.text.toString().toDouble()
            var lebar  = binding.editLebar.text.toString().toDouble()
            var LuasPpj = panjang * lebar
            var KelPpj = (2*panjang) + (2*lebar)

            binding.luasPpj.text = getString(R.string.LuasPpjg, LuasPpj.toString())
            binding.kelilingPpj.text = getString(R.string.KelilingPpjg, KelPpj.toString())
        }

        binding.btShare1.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, binding.luasPpj.text.toString())
            intent.putExtra(Intent.EXTRA_TEXT, binding.kelilingPpj.text.toString())
            startActivity(intent)
        }

        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(tv_LuasPpjg.toString(), binding.luasPpj.text.toString())
        outState.putString(tv_KelPjg.toString(), binding.kelilingPpj.text.toString())
    }

}