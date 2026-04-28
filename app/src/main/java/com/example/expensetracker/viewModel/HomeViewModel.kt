package com.example.expensetracker.viewModel

import android.content.Context
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.expensetracker.Data.Dao.ExpenseDao
import com.example.expensetracker.Data.ExpenseDataBase
import com.example.expensetracker.Data.Model.ExpenseEntity
import com.example.expensetracker.R

class HomeViewModel(dao: ExpenseDao): ViewModel() {
    val expenses = dao.getAllExpenses()

    fun getBalance(list: List<ExpenseEntity>): String{
        var total = 0.0
       list.forEach {
           if(it.type == "Income"){
               total += it.amount
           }else{
               total -= it.amount
           }
       }
       return " ${total}"
       }

    fun getTotalExpense(list: List<ExpenseEntity>): String{
        var total = 0.0
        list.forEach {
            if(it.type == "Expense"){
                total += it.amount
            }
        }
        return " ${total}"
    }

    fun getTotalIncome(list: List<ExpenseEntity>): String {
        var total = 0.0
        list.forEach {
            if(it.type == "Income"){
                total += it.amount
            }
        }
        return " ${total}"
    }

    fun getItemIcon(expense: ExpenseEntity): Int {
        if (expense.title == "Salary") {
            return R.drawable.upi
        } else if (expense.title == "Freelance") {
            return R.drawable.upi
        } else if (expense.title == "Groceries") {
            return R.drawable.groceries
        } else if (expense.title == "Food") {
            return R.drawable.food
        } else if (expense.title == "Transportation") {
            return R.drawable.transportation

        }else{
            return R.drawable.upi
        }
    }

    }

class HomeViewModelfactory(private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            val dao = ExpenseDataBase.getDatabase(context).expenseDao()
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

