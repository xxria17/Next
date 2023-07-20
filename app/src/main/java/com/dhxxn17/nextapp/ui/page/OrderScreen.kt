package com.dhxxn17.nextapp.ui.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dhxxn17.nextapp.R
import com.dhxxn17.nextapp.data.ICE_AMOUNT
import com.dhxxn17.nextapp.data.IS_DECAFFEIN
import com.dhxxn17.nextapp.data.IS_HOT
import com.dhxxn17.nextapp.data.MenuData
import com.dhxxn17.nextapp.ui.navigation.Screens
import com.dhxxn17.nextapp.ui.theme.BaseButton
import com.dhxxn17.nextapp.ui.theme.MainGray
import com.dhxxn17.nextapp.util.transPriceFormat

@Composable
fun OrderScreen(
    navController: NavController,
    menu: MenuData
) {
    var isHot by remember {
        mutableStateOf(menu.isHot)
    }

    var isDecaffein by remember {
        mutableStateOf(menu.isDecaffein)
    }

    var iceAmount by remember {
        mutableStateOf(ICE_AMOUNT.NONE)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
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
                    .padding(top = 20.dp, start = 10.dp)
                    .size(20.dp)
                    .clickable {
                        navController.popBackStack()
                    }
            )

            Text(
                text = menu.name,
                fontSize = 18.sp,
                color = MainGray,
                modifier = Modifier.padding(
                    top = 15.dp
                )
            )

            Text(
                text = transPriceFormat(menu.price),
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(
                    top = 4.dp
                )
            )

            if (menu.isHot != IS_HOT.CANT_CHOOSE) {
                SelectOption(
                    title = "기본",
                    options = listOf(IS_HOT.HOT, IS_HOT.COLD),
                    currentState = isHot,
                    onClick = {
                        isHot = (it as? IS_HOT) ?: IS_HOT.NONE
                    }
                )
            }

            if (menu.isDecaffein != IS_DECAFFEIN.CANT_CHOOSE) {
                SelectOption(
                    title = "디카페인",
                    options = listOf(IS_DECAFFEIN.CAFFEIN, IS_DECAFFEIN.DECAFFEIN),
                    currentState = isDecaffein,
                    onClick = {
                        isDecaffein = (it as? IS_DECAFFEIN) ?: IS_DECAFFEIN.NONE
                    }
                )
            }

            if (isHot == IS_HOT.COLD) {
                SelectOption(
                    title = "얼음",
                    options = listOf(ICE_AMOUNT.LESS,ICE_AMOUNT.REGULAR, ICE_AMOUNT.MANY),
                    currentState = iceAmount,
                    onClick = {
                        iceAmount = (it as? ICE_AMOUNT) ?: ICE_AMOUNT.NONE
                    }
                )
            }
        }

        BaseButton(
            onClick = {
                navController.navigate(
                    Screens.CompleteScreen.route
                )
            },
            buttonTitle = "주문하기",
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }

}

@Composable
fun SelectOption(
    title: String,
    options: List<Any>,
    currentState: Any,
    onClick: (Any) -> Unit
) {
    Column(
        modifier = Modifier.padding(vertical = 15.dp).fillMaxWidth()
    ) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MainGray,
            modifier = Modifier.padding(
                vertical = 5.dp
            )
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            options.forEach { _type ->
                OptionItem(
                    type = _type,
                    text = if (_type is IS_HOT) {
                        _type.name
                    } else if (_type is IS_DECAFFEIN) {
                        _type.title
                    } else if (_type is ICE_AMOUNT) {
                        _type.title
                    } else "",
                    modifier = Modifier.weight(1f),
                    isSelected = currentState == _type,
                    onClick = {
                        onClick.invoke(it)
                    }
                )
            }
        }
    }
}

@Composable
fun OptionItem(
    type: Any,
    text: String,
    modifier: Modifier,
    isSelected: Boolean,
    onClick: (Any) -> Unit
) {
    Box(
        modifier = modifier
            .padding(3.dp)
            .background(
                if (isSelected) Color.Black else Color.LightGray, shape = RoundedCornerShape(10.dp))
            .clickable {
                onClick.invoke(type)
            }
            .padding(10.dp)
    ) {
        Text(
            text = text,
            fontSize = 17.sp,
            color = if (isSelected) Color.White else MainGray,
            fontWeight = FontWeight.Bold
        )
    }
}