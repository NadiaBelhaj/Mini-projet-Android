package com.nadia.frenzy.utils

import com.nadia.frenzy.R
import com.google.android.material.bottomnavigation.BottomNavigationView

object ShortcutUtils {

    private const val HOME_ACTION = "com.nadia.frenzy.action.home"
    private const val PEOPLE_ACTION = "com.nadia.frenzy.action.people"
    private const val NOTIFICATIONS_ACTION = "com.nadia.frenzy.action.notifications"
    private const val PROFILE_ACTION = "com.nadia.frenzy.action.profile"

    fun executeAction(action : String, navigation : BottomNavigationView){
        when(action){
            HOME_ACTION -> navigation.selectedItemId = R.id.navigation_home
            NOTIFICATIONS_ACTION -> navigation.selectedItemId = R.id.navigation_notifications
            PEOPLE_ACTION -> navigation.selectedItemId = R.id.navigation_people
            PROFILE_ACTION -> navigation.selectedItemId = R.id.navigation_profile
        }
    }
}