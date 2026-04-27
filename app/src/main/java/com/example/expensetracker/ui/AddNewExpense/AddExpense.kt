package com.example.expensetracker.ui.AddNewExpense

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.expensetracker.R

@Composable
fun AddExpense() {
    Surface(modifier = Modifier.fillMaxSize()) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (nameRow, list, card, topbar) = createRefs()

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

            Box(modifier = Modifier.fillMaxWidth().padding(top = 60.dp, start = 16.dp, end = 16.dp)
                .constrainAs(nameRow){
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }) {

                Icon(imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterStart).size(30.dp),
                    tint = Color.White)

                Text(
                    text = "Add Expense",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(16.dp)
                        .align(Alignment.Center)
                )
                Icon(imageVector = Icons.Default.Menu,
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterEnd).size(30.dp),
                    tint = Color.White)
            }
            DataForm(modifier = Modifier.padding(top = 60.dp).constrainAs(card){
                top.linkTo(nameRow.bottom, margin = 16.dp)
                start.linkTo(parent.start, margin = 16.dp)
                end.linkTo(parent.end, margin = 16.dp)
            })
        }
    }
}



@Composable
@Preview(showBackground = true, showSystemUi = true )
fun AddExpensePreview(){
    AddExpense()
}

@Composable
fun DataForm(modifier: Modifier){
    Column(
        modifier = modifier.padding(16.dp)
            .fillMaxWidth()
            .shadow(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Text(text = "Type", fontSize = 17.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.size(4.dp))
        OutlinedTextField(value = "", onValueChange = {}, modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.size(10.dp))

        Text(text = "Name", fontSize = 17.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.size(4.dp))
        OutlinedTextField(value = "", onValueChange = {}, modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.size(10.dp))

        Text(text = "Category", fontSize = 17.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.size(4.dp))
        OutlinedTextField(value = "", onValueChange = {}, modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.size(10.dp))

        Text(text = "Amount", fontSize = 17.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.size(4.dp))
        OutlinedTextField(value = "", onValueChange = {}, modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.size(10.dp))

        Text(text = "Date", fontSize = 17.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.size(4.dp))
        OutlinedTextField(value = "", onValueChange = {}, modifier = Modifier.fillMaxWidth())

        Button(onClick = {}, modifier = Modifier.fillMaxWidth().padding(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2F7E79),
                contentColor = Color.White
            )) {
            Text(text = "Add Expense", fontSize = 17.sp, color = Color.White)
        }
    }
}



