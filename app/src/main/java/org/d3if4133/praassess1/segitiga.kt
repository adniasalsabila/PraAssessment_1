package org.d3if4133.praassess1


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.fragment_persegi_panjang.*
import kotlinx.android.synthetic.main.fragment_segitiga.*
import org.d3if4133.praassess1.databinding.FragmentSegitigaBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class segitiga : Fragment() {

    lateinit var binding : FragmentSegitigaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentSegitigaBinding>(inflater, R.layout.fragment_segitiga, container, false)

        if (savedInstanceState != null){
            binding.luasSegit.text = savedInstanceState.getString(tv_luasSegit.toString(),binding.luasSegit.text.toString())
            binding.kelilingSegit.text = savedInstanceState.getString(tv_kelSegit.toString(), binding.kelilingSegit.text.toString())
        }

        binding.btHitung2.setOnClickListener {
            if(binding.editAlas.text.isEmpty() || binding.editTinggi.text.isEmpty()){
                Toast.makeText(context, "inputan tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }

            var alas  = binding.editAlas.text.toString().toDouble()
            var tinggi  = binding.editTinggi.text.toString().toDouble()

            var miring = Math.sqrt(Math.pow(alas,2.0) + Math.pow(tinggi, 2.0))

            var LuasSegit = 1/2*(alas*tinggi)
            var KelSegit = alas + tinggi + miring

            binding.luasSegit.text = getString(R.string.LuasSegitiga, LuasSegit.toString())
            binding.kelilingSegit.text = getString(R.string.KelilingSegitiga, KelSegit.toString())


        }

        binding.btShare2.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "plain/text"
            intent.putExtra(Intent.EXTRA_TEXT, binding.luasSegit.text.toString())
            intent.putExtra(Intent.EXTRA_TEXT, binding.kelilingSegit.text.toString())
            startActivity(intent)
        }

        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(tv_luasSegit.toString(), binding.luasSegit.text.toString())
        outState.putString(tv_kelSegit.toString(), binding.kelilingSegit.text.toString())
    }
}