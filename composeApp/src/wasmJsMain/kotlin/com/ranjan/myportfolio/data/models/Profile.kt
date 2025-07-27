package com.ranjan.myportfolio.data.models

import com.ranjan.myportfolio.UserData
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.profile_placeholder
import org.jetbrains.compose.resources.DrawableResource

data class Profile(
    val name: String = UserData.NAME,
    val title: String = UserData.JOB_TITLE,
    val aboutDescription: List<String> = UserData.ABOUT_DESCRIPTION,
    val profileImageRes: DrawableResource = Res.drawable.profile_placeholder
)