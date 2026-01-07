package com.example.quickestmemoapp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

/**
 * Dark color scheme using cool blue monochromatic palette.
 * Designed for OLED displays and low-light environments.
 */
private val DarkColorScheme = darkColorScheme(
    primary = Blue80,              // Light blue for primary actions
    onPrimary = Blue20,            // Dark blue text on primary
    primaryContainer = Blue30,     // Dark blue container
    onPrimaryContainer = Blue90,   // Light blue text on container

    secondary = Blue70,            // Medium-light blue for secondary
    onSecondary = Blue20,          // Dark blue text
    secondaryContainer = Blue30,   // Dark blue container
    onSecondaryContainer = Blue90, // Light blue text

    tertiary = Cyan80,             // Light cyan for accents
    onTertiary = Cyan20,           // Dark cyan text
    tertiaryContainer = Cyan30,    // Dark cyan container
    onTertiaryContainer = Cyan90,  // Light cyan text

    background = DarkBackground,   // Very dark blue background
    onBackground = DarkOnBackground, // Light blue text

    surface = DarkSurface,         // Dark blue surface
    onSurface = DarkOnBackground,  // Light blue text
    surfaceVariant = DarkSurfaceVariant, // Medium dark blue-gray
    onSurfaceVariant = Color(0xFFC3D7E8), // Light blue-gray text

    outline = DarkOutline,         // Medium-light blue-gray borders
    outlineVariant = DarkOutlineVariant, // Dark blue-gray subtle borders

    error = Color(0xFFFF6B6B),     // Soft red for errors (slight warmth for contrast)
    onError = Color(0xFF370000),   // Dark red text
    errorContainer = Color(0xFF93000A), // Dark red container
    onErrorContainer = Color(0xFFFFDAD6), // Light red text
)

/**
 * Light color scheme using cool blue monochromatic palette.
 * Designed for well-lit environments and readability.
 */
private val LightColorScheme = lightColorScheme(
    primary = Blue60,              // Medium blue for primary actions
    onPrimary = Color.White,       // White text on primary
    primaryContainer = Blue90,     // Very light blue container
    onPrimaryContainer = Blue10,   // Very dark blue text

    secondary = Blue70,            // Medium-light blue for secondary
    onSecondary = Color.White,     // White text on secondary
    secondaryContainer = Blue95,   // Almost white blue container
    onSecondaryContainer = Blue20, // Dark blue text

    tertiary = Cyan60,             // Cool cyan-blue for accents
    onTertiary = Color.White,      // White text on tertiary
    tertiaryContainer = Cyan90,    // Light cyan container
    onTertiaryContainer = Cyan10,  // Very dark cyan text

    background = LightBackground,  // Very light blue-tinted white
    onBackground = Color(0xFF001B3D), // Very dark blue text

    surface = LightBackground,     // Same as background
    onSurface = Color(0xFF001B3D), // Very dark blue text
    surfaceVariant = LightSurfaceVariant, // Light blue-gray
    onSurfaceVariant = Color(0xFF3D4E5C), // Medium dark blue-gray text

    outline = LightOutline,        // Medium blue-gray borders
    outlineVariant = LightOutlineVariant, // Light blue-gray subtle borders

    error = Color(0xFFD32F2F),     // Standard Material red for errors
    onError = Color.White,         // White text on error
    errorContainer = Color(0xFFFFCDD2), // Light red container
    onErrorContainer = Color(0xFF370000), // Dark red text
)

/**
 * Main theme composable for QuickestMemoApp.
 *
 * @param darkTheme Whether to use dark theme (defaults to system preference)
 * @param dynamicColor Whether to use dynamic colors on Android 12+ (defaults to true)
 *                     When enabled, system wallpaper colors override our blue theme
 * @param content The composable content to theme
 */
@Composable
fun QuickestMemoAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
