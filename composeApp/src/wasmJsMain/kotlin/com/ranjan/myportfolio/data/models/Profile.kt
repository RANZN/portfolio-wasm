package com.ranjan.myportfolio.data.models

import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.profile_placeholder
import org.jetbrains.compose.resources.DrawableResource

data class Profile(
    val name: String,
    val title: String,
    val aboutDescription: List<String>,
    val profileImageRes: DrawableResource = Res.drawable.profile_placeholder
)