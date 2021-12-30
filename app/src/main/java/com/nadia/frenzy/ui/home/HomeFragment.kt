package com.nadia.frenzy.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.nadia.frenzy.R
import com.nadia.frenzy.data.Reaction
import com.nadia.frenzy.data.ReactionData
import com.nadia.frenzy.data.USER_ID
import com.nadia.frenzy.databinding.ListLayoutBinding
import com.nadia.frenzy.ui.adapter.FeedAdapter
import com.nadia.frenzy.ui.main.MainViewModel
import com.nadia.frenzy.utils.Session
import com.nadia.frenzy.utils.gone
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var feedAdapter : FeedAdapter

    private var _binding: ListLayoutBinding? = null
    private val binding get() = _binding!!

    private val viewModel  by viewModels<HomeViewModel>()
    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = DataBindingUtil.inflate(inflater,R.layout.list_layout, container, false)

        setupUserList()

        viewModel.loadUserHomeFeed(Session.getUserId(requireContext()).toString())
        mainViewModel.updateNavigationButtonVisibility(View.VISIBLE)

        setupObservers()

        return binding.root
    }

    private fun setupUserList(){
        feedAdapter = FeedAdapter()
        binding.listItems.setHasFixedSize(true)
        binding.listItems.layoutManager = LinearLayoutManager(context)
        binding.listItems.adapter = feedAdapter

        feedAdapter.setOnUsernameListener { userId ->
            val args = Bundle()
            args.putString(USER_ID, userId)
            findNavController().navigate(R.id.action_homeFragment_to_profileFragment, args)

        }

        feedAdapter.setOnReactionListener { answerId, toUser, reaction, callback ->
            when (reaction) {
                Reaction.REACATED -> {
                    val token = Session.getHeaderToken(requireContext())
                    val id = Session.getUserId(requireContext()).toString()
                    val body = ReactionData(id, toUser, answerId.toString())
                    viewModel.unreactAnswer(token, body, callback)
                }
                Reaction.UN_REACATED -> {
                    val token = Session.getHeaderToken(requireContext())
                    val id = Session.getUserId(requireContext()).toString()
                    val body = ReactionData(id, toUser, answerId.toString())
                    viewModel.reactAnswer(token, body, callback)
                }
            }
        }
    }

    private fun setupObservers() {
        viewModel.getFeedPagedList().observe(viewLifecycleOwner, {
            feedAdapter.submitData(lifecycle, it)
            binding.loadingBar.gone()
        })

        viewModel.messages.observe(viewLifecycleOwner, {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}