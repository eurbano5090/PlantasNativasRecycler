package com.android.myappnative.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.android.myappnative.data.ArbolData
import com.android.myappnative.ui.screens.ArbolDetailScreen
import com.android.myappnative.ui.screens.ArbolScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "arbol"){
        composable("arbol"){
            ArbolScreen(navController)
        }

        composable(
            route = "arbolDetail/{arbolId}",
            arguments = listOf(navArgument("arbolId") { type = NavType.IntType })
        ) { backStackEntry ->
            val arbolId = backStackEntry.arguments?.getInt("arbolId") ?: 0
            val arbol = ArbolData.findById(arbolId)
            arbol?.let {
                ArbolDetailScreen(navController, it)
            }

        }
    }

}