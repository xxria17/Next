package toss.next.dhxxn17.next2023.view.complete

import android.view.LayoutInflater
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import toss.next.dhxxn17.next2023.R
import toss.next.dhxxn17.next2023.databinding.FragmentCompleteBinding
import toss.next.dhxxn17.next2023.view.base.BaseFragment

@AndroidEntryPoint
class CompleteFragment : BaseFragment<FragmentCompleteBinding>(R.layout.fragment_complete) {

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCompleteBinding {
        return FragmentCompleteBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }
    }

    override fun init() {

    }

}