package com.ranjan.myportfolio.presentation.theme

import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color

// Light theme - Dark colors for day theme
private val LightPrimary = Color(0xFF2E3440)
private val LightOnPrimary = Color(0xFFFFFFFF)
private val LightPrimaryContainer = Color(0xFF4C566A)
private val LightOnPrimaryContainer = Color(0xFFECEFF4)
private val LightSecondary = Color(0xFF5E81AC)
private val LightOnSecondary = Color(0xFFFFFFFF)
private val LightSecondaryContainer = Color(0xFFD8DEE9)
private val LightOnSecondaryContainer = Color(0xFF2E3440)
private val LightTertiary = Color(0xFF88C0D0)
private val LightOnTertiary = Color(0xFF2E3440)
private val LightTertiaryContainer = Color(0xFFE5E9F0)
private val LightOnTertiaryContainer = Color(0xFF2E3440)
private val LightError = Color(0xFFBF616A)
private val LightErrorContainer = Color(0xFFECEFF4)
private val LightOnError = Color(0xFFFFFFFF)
private val LightOnErrorContainer = Color(0xFFBF616A)
private val LightBackground = Color(0xFFECEFF4)
private val LightOnBackground = Color(0xFF2E3440)
private val LightSurface = Color(0xFFFFFFFF)
private val LightOnSurface = Color(0xFF2E3440)
private val LightSurfaceVariant = Color(0xFFF5F6F8)
private val LightOnSurfaceVariant = Color(0xFF4C566A)
private val LightOutline = Color(0xFFD8DEE9)
private val LightInverseOnSurface = Color(0xFFECEFF4)
private val LightInverseSurface = Color(0xFF2E3440)
private val LightInversePrimary = Color(0xFF88C0D0)

// Dark theme - Awesome light colors for night
private val DarkPrimary = Color(0xFF88C0D0)
private val DarkOnPrimary = Color(0xFF2E3440)
private val DarkPrimaryContainer = Color(0xFF5E81AC)
private val DarkOnPrimaryContainer = Color(0xFFECEFF4)
private val DarkSecondary = Color(0xFF81A1C1)
private val DarkOnSecondary = Color(0xFF2E3440)
private val DarkSecondaryContainer = Color(0xFF434C5E)
private val DarkOnSecondaryContainer = Color(0xFFD8DEE9)
private val DarkTertiary = Color(0xFFA3BE8C)
private val DarkOnTertiary = Color(0xFF2E3440)
private val DarkTertiaryContainer = Color(0xFF3B4252)
private val DarkOnTertiaryContainer = Color(0xFFD8DEE9)
private val DarkError = Color(0xFFBF616A)
private val DarkErrorContainer = Color(0xFF3B4252)
private val DarkOnError = Color(0xFFECEFF4)
private val DarkOnErrorContainer = Color(0xFFBF616A)
private val DarkBackground = Color(0xFF2E3440)
private val DarkOnBackground = Color(0xFFECEFF4)
private val DarkSurface = Color(0xFF3B4252)
private val DarkOnSurface = Color(0xFFECEFF4)
private val DarkSurfaceVariant = Color(0xFF434C5E)
private val DarkOnSurfaceVariant = Color(0xFFD8DEE9)
private val DarkOutline = Color(0xFF4C566A)
private val DarkInverseOnSurface = Color(0xFF2E3440)
private val DarkInverseSurface = Color(0xFFECEFF4)
private val DarkInversePrimary = Color(0xFF2E3440)

val PortfolioLightColorScheme = lightColorScheme(
    primary = LightPrimary,
    onPrimary = LightOnPrimary,
    primaryContainer = LightPrimaryContainer,
    onPrimaryContainer = LightOnPrimaryContainer,
    secondary = LightSecondary,
    onSecondary = LightOnSecondary,
    secondaryContainer = LightSecondaryContainer,
    onSecondaryContainer = LightOnSecondaryContainer,
    tertiary = LightTertiary,
    onTertiary = LightOnTertiary,
    tertiaryContainer = LightTertiaryContainer,
    onTertiaryContainer = LightOnTertiaryContainer,
    error = LightError,
    errorContainer = LightErrorContainer,
    onError = LightOnError,
    onErrorContainer = LightOnErrorContainer,
    background = LightBackground,
    onBackground = LightOnBackground,
    surface = LightSurface,
    onSurface = LightOnSurface,
    surfaceVariant = LightSurfaceVariant,
    onSurfaceVariant = LightOnSurfaceVariant,
    outline = LightOutline,
    inverseOnSurface = LightInverseOnSurface,
    inverseSurface = LightInverseSurface,
    inversePrimary = LightInversePrimary,
)

val PortfolioDarkColorScheme = darkColorScheme(
    primary = DarkPrimary,
    onPrimary = DarkOnPrimary,
    primaryContainer = DarkPrimaryContainer,
    onPrimaryContainer = DarkOnPrimaryContainer,
    secondary = DarkSecondary,
    onSecondary = DarkOnSecondary,
    secondaryContainer = DarkSecondaryContainer,
    onSecondaryContainer = DarkOnSecondaryContainer,
    tertiary = DarkTertiary,
    onTertiary = DarkOnTertiary,
    tertiaryContainer = DarkTertiaryContainer,
    onTertiaryContainer = DarkOnTertiaryContainer,
    error = DarkError,
    errorContainer = DarkErrorContainer,
    onError = DarkOnError,
    onErrorContainer = DarkOnErrorContainer,
    background = DarkBackground,
    onBackground = DarkOnBackground,
    surface = DarkSurface,
    onSurface = DarkOnSurface,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = DarkOnSurfaceVariant,
    outline = DarkOutline,
    inverseOnSurface = DarkInverseOnSurface,
    inverseSurface = DarkInverseSurface,
    inversePrimary = DarkInversePrimary,
)