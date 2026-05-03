package com.example.expensetracker.ui.HomeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.expensetracker.viewModel.HomeViewModel
import com.example.expensetracker.viewModel.HomeViewModelfactory

@Composable

fun NewHomeScreen(navController: NavController) {

        val viewModel: HomeViewModel = HomeViewModelfactory(LocalContext.current).create(HomeViewModel::class.java)
    var isBalanceVisible by remember { mutableStateOf(true) }
    Surface(modifier = Modifier.fillMaxSize()) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (nameRow, list, card, topbar, add) = createRefs()

            Image(
                painter = painterResource(com.example.expensetracker.R.drawable.homescreen_topbar),
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(topbar) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    }
                    .height(287.dp),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .constrainAs(nameRow) {  // constrainAs FIRST
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                        height = Dimension.wrapContent
                    }
                    .padding(top = 64.dp, start = 16.dp, end = 16.dp)  // padding AFTER
            ) {
                Column {
                    Text(text = "Good Afternoon", fontSize = 16.sp, color = Color.White)
                    Text(
                        text = "Maanit",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterEnd).size(32.dp),
                    tint = Color.White,

                    )
            }

            val state = viewModel.expenses.collectAsState(initial = emptyList())

            val expenses = viewModel.getTotalExpense(state.value)

            val income = viewModel.getTotalIncome(state.value)

            val balance = viewModel.getBalance(state.value)

            CardItem(
                modifier = Modifier.constrainAs(ref = card) {
                    top.linkTo(anchor = nameRow.bottom, margin = 16.dp)
                    start.linkTo(anchor = parent.start, margin = 16.dp)
                    end.linkTo(anchor = parent.end, margin = 16.dp)
                    width = Dimension.fillToConstraints
                },
                balance = "₹${balance}",
                income = "₹${income}",
                expenses = "₹${expenses}",
                isBalanceVisible = isBalanceVisible,
                onToggleVisibility = { isBalanceVisible = !isBalanceVisible }
            )

            TransactionList(modifier = Modifier.fillMaxWidth().constrainAs(list){
                top.linkTo(card.bottom, margin = 16.dp)
                start.linkTo(parent.start, margin = 16.dp)
                end.linkTo(parent.end, margin = 16.dp)
                bottom.linkTo(parent.bottom)
                height = Dimension.fillToConstraints
            }, list = state.value, viewModel = viewModel)

            Image(painter = painterResource(com.example.expensetracker.R.drawable.addbutton),contentDescription = null
                , modifier = Modifier.constrainAs(add){
                    bottom.linkTo(parent.bottom, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
            }.size(49.dp)
                    .clip(CircleShape)
                    .clickable{ navController.navigate("addExpense")})

        }

    }

}

@Composable

fun TransactionItem(Title: String, amount: String, icon: Int, date: String, color: Color){
    Box (
        modifier = Modifier.fillMaxWidth()
    ){
        Row {
            Image(painter = painterResource(id = icon), contentDescription = null,
                modifier = Modifier.size(50.dp))

            Spacer(modifier = Modifier.size(8.dp))

            Column {
                Text(text = Title, fontSize = 16.sp, )
                Text(text = date, fontSize = 12.sp, )
            }
        }

        Text(text = amount, fontSize = 20.sp, modifier = Modifier.align(Alignment.CenterEnd), color = color)
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    NewHomeScreen(rememberNavController())
}





