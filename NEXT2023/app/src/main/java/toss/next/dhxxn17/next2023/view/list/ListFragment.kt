package toss.next.dhxxn17.next2023.view.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import toss.next.dhxxn17.next2023.R
import toss.next.dhxxn17.next2023.databinding.FragmentListBinding
import toss.next.dhxxn17.next2023.model.Menu
import toss.next.dhxxn17.next2023.view.base.BaseFragment

@AndroidEntryPoint
class ListFragment: BaseFragment<FragmentListBinding>(R.layout.fragment_list) {

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentListBinding {
        return FragmentListBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }
    }

    override fun init() {
        with(requireDataBinding()) {
            btnBack.setOnClickListener {
                findNavController().popBackStack()
            }

            rvMenu.adapter = MenuAdapter(arrayListOf<Menu>())
        }
    }
}