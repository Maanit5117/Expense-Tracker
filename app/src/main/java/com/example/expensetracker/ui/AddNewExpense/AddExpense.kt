package com.example.expensetracker.ui.AddNewExpense

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

                IconButton(onClick = {},
                    modifier = Modifier.align(Alignment.CenterStart)) {
                    Icon(imageVector = Icons.Default.ArrowBackIosNew,
                        contentDescription = null,
                        modifier = Modifier.align(Alignment.CenterStart).size(30.dp),
                        tint = Color.White)
                }


                Text(
                    text = "Add Expense",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(16.dp)
                        .align(Alignment.Center)
                )

                IconButton(onClick = {},
                    modifier = Modifier.align(Alignment.CenterEnd)){
                    Icon(imageVector = Icons.Default.Menu,
                        contentDescription = null,
                        modifier = Modifier.align(Alignment.CenterEnd).size(30.dp),
                        tint = Color.White)
                }

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
fun DataForm(modifier: Modifier) {

    val name = remember { mutableStateOf("") }
    val amount = remember { mutableStateOf("") }
    val date = remember { mutableStateOf(0L) }
    val dateDialogueVisibility = remember { mutableStateOf(false) }


    Column(
        modifier = modifier.padding(16.dp)
            .fillMaxWidth()
            .shadow(20.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(text = "Name", fontSize = 14.sp)
        Spacer(modifier = Modifier.size(8.dp))
        OutlinedTextField(
            value = name.value,
            onValueChange = { name.value = it },
            modifier = Modifier.fillMaxWidth()
        )

        Text(text = "Amount", fontSize = 14.sp)
        Spacer(modifier = Modifier.size(8.dp))
        OutlinedTextField(
            value = amount.value,
            onValueChange = { amount.value = it },
            modifier = Modifier.fillMaxWidth()
        )

        //date
        Text(text = "Date", fontSize = 14.sp)
        Spacer(modifier = Modifier.size(8.dp))
        OutlinedTextField(
            value =date.value.toString(),
            onValueChange = { },
            modifier = Modifier.fillMaxWidth().clickable {dateDialogueVisibility.value= true}, enabled = false
        )


        //category


        //type

        Button(
            onClick = {}, modifier = Modifier.fillMaxWidth().padding(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2F7E79),
                contentColor = Color.White
            )
        ) {
            Text(text = "Add Expense", fontSize = 17.sp, color = Color.White)
        }
    }
    if (dateDialogueVisibility.value) {
        ExpenseDatePickerDialogue(onDateSelected = {date.value = it
                                                    dateDialogueVisibility.value = false}, onDismiss = {
                                                        dateDialogueVisibility.value= false
        })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpenseDatePickerDialogue(
    onDateSelected: (date:Long) -> Unit,
    onDismiss: () -> Unit
){
    val datePickerState = rememberDatePickerState()
    val selectedDate = datePickerState.selectedDateMillis?: 0L

    DatePickerDialog(onDismissRequest = {onDismiss}
        , confirmButton = { TextButton({ onDateSelected(selectedDate) }){
            Text(text = "OK")
        } },
        dismissButton = { TextButton(onClick = { onDismiss() }) {
            Text(text = "Cancel")
        }
        }){
        DatePicker(state = datePickerState)
    }

}



