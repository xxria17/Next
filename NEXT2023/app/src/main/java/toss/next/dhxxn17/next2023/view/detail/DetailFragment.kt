package toss.next.dhxxn17.next2023.view.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import toss.next.dhxxn17.next2023.R
import toss.next.dhxxn17.next2023.databinding.FragmentDetailBinding
import toss.next.dhxxn17.next2023.view.base.BaseFragment

@AndroidEntryPoint
class DetailFragment: BaseFragment<FragmentDetailBinding>(R.layout.fragment_detail) {

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }
    }

    override fun init() {

    }

}