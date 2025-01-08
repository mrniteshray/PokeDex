package xcom.nitesh.apps.pokedex

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.airbnb.lottie.LottieAnimationView

class SplashFragment : Fragment(R.layout.fragment_splash) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pokeball : LottieAnimationView = view.findViewById(R.id.pokeball)
        pokeball.setAnimation(R.raw.pokeball)
        pokeball.playAnimation()
        val pokemontxt : TextView = view.findViewById(R.id.textView)
        pokemontxt.setOnClickListener {
            findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
        }
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
        }, 3000)
    }

}