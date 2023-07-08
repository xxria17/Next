package toss.next.dhxxn17.next2023.view.list


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import toss.next.dhxxn17.next2023.R
import toss.next.dhxxn17.next2023.model.Menu
import toss.next.dhxxn17.next2023.view.util.StringUtil

class MenuAdapter(val list: ArrayList<Menu>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false)
        return MenuViewHolder(view)
    }

    override fun getItemCount(): Int = list.size


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MenuViewHolder).onBind(list[position])
    }

    inner class MenuViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name: TextView
        val price: TextView

        init {
            name = itemView.findViewById(R.id.item_menu_name)
            price = itemView.findViewById(R.id.item_menu_price)
        }

        fun onBind(menu: Menu) {
            name.text = menu.menu
            price.text = StringUtil.getPriceFormat(menu.price)
        }
    }

}