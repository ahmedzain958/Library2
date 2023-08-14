package com.example.library2.navigation_component

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavInflater
import androidx.navigation.fragment.NavHostFragment
import com.example.library2.R

class NavigationGraphSurveyWithNextPreviousActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_graph_survey_with_next_previous)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        //due to each nav host fragment has a nav controller, we have no need for the following code, as long the navgraph already given in the design time
        /*val inflater: NavInflater = navHostFragment.navController.navInflater
        val graph = inflater.inflate(R.navigation.nav_graph)

        navHostFragment.navController.graph = graph*/
        navController = navHostFragment.navController
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}