package toss.next.dhxxn17.next2023.view

import android.view.LayoutInflater
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import toss.next.dhxxn17.next2023.R
import toss.next.dhxxn17.next2023.databinding.FragmentMainBinding
import toss.next.dhxxn17.next2023.view.base.BaseFragment

@AndroidEntryPoint
class MainFragment: BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {
    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMainBinding {
        return FragmentMainBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }
    }

    override fun init() {

    }

}