package com.ranjan.myportfolio.presentation.theme

import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color

// Light theme - Dark colors for day theme
private val LightPrimary = Color(0xFF5E81AC) // Softer steel blue, readable and on-brand
private val LightOnPrimary = Color(0xFFFFFFFF)
private val LightPrimaryContainer = Color(0xFFD8DEE9) // Muted arctic background
private val LightOnPrimaryContainer = Color(0xFF2E3440)
private val LightSecondary = Color(0xFF81A1C1)
private val LightOnSecondary = Color(0xFF2E3440)
private val LightSecondaryContainer = Color(0xFFE5E9F0)
private val LightOnSecondaryContainer = Color(0xFF2E3440)
private val LightTertiary = Color(0xFFA3BE8C) // Soothing green for success/special UI
private val LightOnTertiary = Color(0xFF2E3440)
private val LightTertiaryContainer = Color(0xFFEAF4EC)
private val LightOnTertiaryContainer = Color(0xFF2E3440)
private val LightError = Color(0xFFBF616A)
private val LightOnError = Color(0xFFFFFFFF)
private val LightErrorContainer = Color(0xFFFFE8E8)
private val LightOnErrorContainer = Color(0xFF7D1C22)
private val LightBackground = Color(0xFFF7F9FB) // Very soft gray-blue
private val LightOnBackground = Color(0xFF2E3440)
private val LightSurface = Color(0xFFFFFFFF) // Card / container base
private val LightOnSurface = Color(0xFF2E3440)
private val LightSurfaceVariant = Color(0xFFECEFF4)
private val LightOnSurfaceVariant = Color(0xFF4C566A)
private val LightOutline = Color(0xFFD8DEE9)
private val LightInverseOnSurface = Color(0xFFECEFF4)
private val LightInverseSurface = Color(0xFF2E3440)
private val LightInversePrimary = Color(0xFF88C0D0)

// Dark theme - Awesome light colors for night
private val DarkPrimary = Color(0xFF60A5FA)
private val DarkOnPrimary = Color(0xFF0F172A)
private val DarkPrimaryContainer = Color(0xFF1E3A8A)
private val DarkOnPrimaryContainer = Color(0xFFDCEEFF)
private val DarkSecondary = Color(0xFF818CF8)
private val DarkOnSecondary = Color(0xFF1E293B)
private val DarkSecondaryContainer = Color(0xFF312E81)
private val DarkOnSecondaryContainer = Color(0xFFE0E7FF)
private val DarkTertiary = Color(0xFF6EE7B7)
private val DarkOnTertiary = Color(0xFF064E3B)
private val DarkTertiaryContainer = Color(0xFF065F46)
private val DarkOnTertiaryContainer = Color(0xFFD1FAE5)
private val DarkError = Color(0xFFF87171)
private val DarkErrorContainer = Color(0xFF7F1D1D)
private val DarkOnError = Color(0xFFFFE4E6)
private val DarkOnErrorContainer = Color(0xFFF87171)
private val DarkBackground = Color(0xFF0F172A)
private val DarkOnBackground = Color(0xFFE2E8F0)
private val DarkSurface = Color(0xFF1E293B)
private val DarkOnSurface = Color(0xFFF8FAFC)
private val DarkSurfaceVariant = Color(0xFF334155)
private val DarkOnSurfaceVariant = Color(0xFFE5E7EB)
private val DarkOutline = Color(0xFF64748B)
private val DarkInverseOnSurface = Color(0xFF0F172A)
private val DarkInverseSurface = Color(0xFFF8FAFC)
private val DarkInversePrimary = Color(0xFF3B82F6)

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