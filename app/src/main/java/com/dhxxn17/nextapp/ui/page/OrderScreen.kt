package com.dhxxn17.nextapp.ui.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dhxxn17.nextapp.R
import com.dhxxn17.nextapp.data.MenuData
import com.dhxxn17.nextapp.ui.navigation.Screens
import com.dhxxn17.nextapp.ui.theme.BaseButton
import com.dhxxn17.nextapp.ui.theme.MainBlue
import com.dhxxn17.nextapp.ui.theme.MainGray
import com.dhxxn17.nextapp.util.transPriceFormat

@Composable
fun OrderScreen(
    navController: NavController,
    menu: MenuData
) {
    val selectMenu = MenuData(
        name = menu.name,
        price = menu.price,
        isDecaffein = if (menu.isDecaffein == true) true else null,
        isHot = if (menu.isHot == true) true else null,
        category = menu.category
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 10.dp)
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

        Text(
            text = menu.name,
            fontSize = 16.sp,
            color = MainGray,
            modifier = Modifier.padding(
                top = 15.dp
            )
        )

        Text(
            text = transPriceFormat(menu.price),
            fontSize = 18.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(
                top = 4.dp
            )
        )

        if (menu.isHot == true) {
            SelectOption(title = "기본", options = arrayListOf("HOT", "COLD"))
        }

        if (menu.isDecaffein == true) {
            SelectOption(title = "디카페인", options = arrayListOf("카페인", "디카페인"))
        }

        if (selectMenu.isHot == true) {
            SelectOption(title = "얼음", options = arrayListOf("작게", "보통", "많이"))
        }

        BaseButton(
            onClick = {
                navController.navigate(
                    Screens.CompleteScreen.route
                )
            },
            buttonTitle = "주문하기",
            modifier = Modifier
        )
    }

}

@Composable
fun SelectOption(
    title: String,
    options: ArrayList<String>
) {
    Column() {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MainGray,
            modifier = Modifier.padding(
                vertical = 5.dp
            )
        )

        Row() {
            options.forEach {
                OptionItem(text = it)
            }
        }
    }
}

@Composable
fun OptionItem(
    text: String
) {
    Box(
        modifier = Modifier
            .padding(3.dp)
            .background(MainBlue, shape = RoundedCornerShape(10.dp))
            .padding(10.dp)
    ) {
        Text(
            text = text,
            fontSize = 17.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}