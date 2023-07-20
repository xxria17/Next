package com.dhxxn17.nextapp.ui.page

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dhxxn17.nextapp.R
import com.dhxxn17.nextapp.data.Category
import com.dhxxn17.nextapp.data.MenuData
import com.dhxxn17.nextapp.ui.navigation.Screens
import com.dhxxn17.nextapp.ui.theme.MainGray
import com.dhxxn17.nextapp.util.stringToCategory
import com.dhxxn17.nextapp.util.transPriceFormat
import org.json.JSONObject

@Composable
fun ListScreen(
    navController: NavController
) {
    ListContent(navController = navController)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListContent(navController: NavController) {

    /* json 파일로 저장된 메뉴 리스트 불러오기 */
    val json = navController.context.assets.open("menu.json").reader().readText()
    val data = JSONObject(json).getJSONArray("list")
    val menuList = arrayListOf<MenuData>()
    for (i in 0 until data.length()) {
        val jsonObject = data.getJSONObject(i)

        val menuData = MenuData(
            name = jsonObject.getString("menu"),
            category = stringToCategory(jsonObject.getString("category")),
            price = jsonObject.getInt("price"),
            isHot = jsonObject.getBoolean("can_hot"),
            isDecaffein = jsonObject.getBoolean("can_Decaffein")
        )

        menuList.add(menuData)
    }

    /* 메뉴들을 카테고리 순서대로 정렬하기 */
    menuList.sortBy { it.category.order }

    val grouped = menuList.groupBy { it.category }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = "뒤로가기 버튼",
            modifier = Modifier
                .padding(20.dp)
                .size(20.dp)
                .clickable {
                    navController.popBackStack()
                }
        )

        LazyColumn(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
        ) {
            grouped.forEach { (category, menus) ->

                /* 카테고리별로 고정 헤더 노출 */
                stickyHeader {
                    MenuHeaderItem(category = category)
                }

                items(menus) { _menu ->
                    MenuItem(
                        menu = _menu,
                        onClick = {
                            navController.navigate(
                                Screens.OrderScreen.route
                            )
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun MenuHeaderItem(
    category: Category
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(7.dp)
    ) {
        Text(
            text = category.name,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = MainGray
        )
    }
}

@Composable
fun MenuItem(
    menu: MenuData,
    onClick: (MenuData) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .clickable { onClick.invoke(menu) }
            .padding(10.dp)
    ) {
        Text(
            text = menu.name,
            fontSize = 17.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = transPriceFormat(menu.price),
            fontSize = 15.sp,
            color = MainGray,
            modifier = Modifier.padding(top = 5.dp)
        )
    }
}