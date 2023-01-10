@file:OptIn(ExperimentalTextApi::class)

package com.github.felipecastilhos.pokedexandroid.core.ui.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.github.felipecastilhos.pokedexandroid.R

// Set of Material typography styles to start with

@Composable
fun PokedexTypographyScheme.toMaterialTypography()  = Typography(
    h1 = PokedexTheme.typography.bold.h1,
    h3 = PokedexTheme.typography.bold.h2,
    body1 = PokedexTheme.typography.regular.body1
)

class PokedexTypographyScheme(
    val regular: PokedexTypography,
    val bold: PokedexTypography
) {
    companion object {
        fun default() = PokedexTypographyScheme(regular = PokedexTypography.regular, bold = PokedexTypography.bold)
    }
}

class PokedexTypography(
    val h1: TextStyle,
    val h2: TextStyle,
    val body1: TextStyle,
    val body2: TextStyle,
    val subtitle: TextStyle
) {
    companion object {
        val regular = PokedexTypography(
            h1 = TextStyle(
                fontFamily = PokedexFontFamily.poppins,
                fontWeight = FontWeight.Normal,
                fontSize = TypographySize.s500,
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            h2 = TextStyle(
                fontFamily = PokedexFontFamily.poppins,
                fontWeight = FontWeight.Normal,
                fontSize = TypographySize.s400,
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            body1 = TextStyle(
                fontFamily = PokedexFontFamily.poppins,
                fontWeight = FontWeight.Normal,
                fontSize = TypographySize.s300,
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            body2 = TextStyle(
                fontFamily = PokedexFontFamily.poppins,
                fontWeight = FontWeight.Normal,
                fontSize = TypographySize.s200,
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            subtitle = TextStyle(
                fontFamily = PokedexFontFamily.poppins,
                fontWeight = FontWeight.Normal,
                fontSize = TypographySize.s100,
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
        )

        val bold = PokedexTypography(
            h1 = TextStyle(
                fontFamily = PokedexFontFamily.poppins,
                fontWeight = FontWeight.Bold,
                fontSize = TypographySize.s500,
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            h2 = TextStyle(
                fontFamily = PokedexFontFamily.poppins,
                fontWeight = FontWeight.Bold,
                fontSize = TypographySize.s400,
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            body1 = TextStyle(
                fontFamily = PokedexFontFamily.poppins,
                fontWeight = FontWeight.Bold,
                fontSize = TypographySize.s300,
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            body2 = TextStyle(
                fontFamily = PokedexFontFamily.poppins,
                fontWeight = FontWeight.Bold,
                fontSize = TypographySize.s200,
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            subtitle = TextStyle(
                fontFamily = PokedexFontFamily.poppins,
                fontWeight = FontWeight.Bold,
                fontSize = TypographySize.s100,
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
        )
    }
}


sealed class PokedexFontFamily {
    companion object {
        val poppins = FontFamily(
            Font(R.font.poppins_regular, FontWeight.Normal),
            Font(R.font.poppins_bold, FontWeight.Bold)
        )
    }
}

sealed class TypographySize(
    val s100: TextUnit,
    val s200: TextUnit,
    val s300: TextUnit,
    val s400: TextUnit,
    val s500: TextUnit
) {
    companion object :
        TypographySize(
            s100 = 8.sp,
            s200 = 10.sp,
            s300 = 12.sp,
            s400 = 14.sp,
            s500 = 24.sp
        )
}