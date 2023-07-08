package toss.next.dhxxn17.next2023.view

import android.os.Bundle
import androidx.fragment.app.commitNow
import dagger.hilt.android.AndroidEntryPoint
import toss.next.dhxxn17.next2023.R
import toss.next.dhxxn17.next2023.databinding.ActivityMainBinding
import toss.next.dhxxn17.next2023.view.base.BaseActivity
import toss.next.dhxxn17.next2023.view.intro.IntroFragment

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.commitNow(true) {
            val mainFragment = MainFragment()
            replace(R.id.main_content, mainFragment)
            setPrimaryNavigationFragment(mainFragment)
        }
    }
}