package com.nadia.frenzy.ui.fullscreen

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.nadia.frenzy.R
import com.nadia.frenzy.data.AVATAR_URL
import com.nadia.frenzy.databinding.FullscreenLayoutBinding
import com.nadia.frenzy.utils.Downloader
import com.nadia.frenzy.utils.loadImage
import com.nadia.frenzy.utils.toServerImageUrl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FullscreenFragment : Fragment(){

    private var _binding: FullscreenLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fullscreen_layout, container, false)

        val imageUrl = arguments?.getString(AVATAR_URL)
        binding.imageView.loadImage(imageUrl, R.drawable.ic_profile)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.image_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.saveMenu -> saveImageAction()
            R.id.shareMenu -> shareImageAction()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun saveImageAction(){
        val imageUrl = arguments?.getString(AVATAR_URL)?.toServerImageUrl().toString()
        Downloader.downloadImage(requireContext(), imageUrl)
    }

    private fun shareImageAction(){
        val imageUrl = arguments?.getString(AVATAR_URL)?.toServerImageUrl()
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Share Image")
        sharingIntent.putExtra(Intent.EXTRA_TEXT, imageUrl)
        startActivity(Intent.createChooser(sharingIntent,resources.getString(R.string.share)))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}