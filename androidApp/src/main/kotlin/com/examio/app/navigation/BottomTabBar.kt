package com.examio.app.navigation

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.examio.app.features.navigation.MainTab

@Composable
fun BottomTabBar(
    selectedTab: MainTab,
    onTabSelected: (MainTab) -> Unit,
) {
    NavigationBar {
        MainTab.entries.forEach { tab ->
            NavigationBarItem(
                selected = tab == selectedTab,
                onClick = { onTabSelected(tab) },
                icon = { Text(tab.shortLabel) },
                label = { Text(tab.title) },
            )
        }
    }
}

private val MainTab.shortLabel: String
    get() = when (this) {
        MainTab.Home -> "HN"
        MainTab.Study -> "ST"
        MainTab.MyExams -> "EX"
        MainTab.Ai -> "AI"
        MainTab.Account -> "AC"
    }
