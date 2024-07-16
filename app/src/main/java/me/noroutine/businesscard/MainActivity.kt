package me.noroutine.businesscard

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.MailOutline
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.noroutine.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                BusinessCard()
            }
        }
    }
}

@Composable
fun HeroSection(
    logoPainter: Painter,
    fullName: String,
    title: String,
    color: Color = Color.DarkGray,
    modifier: Modifier = Modifier
) {
    Column(
        modifier,
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = logoPainter,
            contentDescription = "Logo",
            modifier = Modifier
                .scale(0.8f)
                .clip(shape = CircleShape)
                .padding(bottom = 4.dp)
        )
        Text(
            text = fullName,
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            color = color,
            modifier = Modifier.padding(bottom = 4.dp),
        )
        Text(
            text = title,
            textAlign = TextAlign.Center,
            color = color,
            modifier = Modifier.align(alignment = CenterHorizontally),
        )
    }
}

@Composable
@Preview(showBackground = true)
fun HeroSectionPreview() {
    BusinessCardTheme {
        HeroSection(painterResource(R.drawable.sun), "Agent Smith", "Senior Program")
    }
}

@Composable
fun ContactsSection(
    phone: String,
    email: String,
    url: String,
    social: String,
    color: Color = Color.DarkGray,
    modifier: Modifier = Modifier
) {
    val rowModifier = Modifier.padding(4.dp)
    val iconModifier = Modifier.padding(end = 4.dp)

    Column(modifier = modifier, verticalArrangement = Arrangement.Center) {
        Row(modifier = rowModifier) {
            Icon(
                Icons.Rounded.Call,
                contentDescription = "Localized description",
                modifier = iconModifier,
                tint = color
            )
            Text(
                text = phone,
                textAlign = TextAlign.Center,
                color = color
            )
        }
        Row(modifier = rowModifier) {
            Icon(
                Icons.Rounded.Email,
                contentDescription = "Localized description",
                modifier = iconModifier,
                tint = color
            )
            Text(
                text = email,
                textAlign = TextAlign.Center,
                color = color
            )
        }
        Row(modifier = rowModifier) {
            Icon(
                Icons.Rounded.Home,
                contentDescription = "Localized description",
                modifier = iconModifier,
                tint = color
            )
            Text(
                text = url,
                textAlign = TextAlign.Center,
                color = color
            )
        }
        Row(modifier = rowModifier) {
            Icon(
                Icons.Rounded.Share,
                contentDescription = "Localized description",
                modifier = iconModifier,
                tint = color
            )
            Text(
                text = social,
                textAlign = TextAlign.Center,
                color = color
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContactsSectionPreview() {
    BusinessCardTheme {
        ContactsSection(
            phone = "+1 234 567 890",
            email = "agent@example.com",
            url = "https://matrix.com",
            social = "@agent_smith",
        )
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    val mainColor = Color(0xFF01B14F)
    val backgroundColor = mainColor.copy(alpha = 0.1f)
    Column(
        modifier
            .fillMaxSize()
            .background(backgroundColor), horizontalAlignment = CenterHorizontally) {
        HeroSection(
            logoPainter = painterResource(id = R.drawable.sun),
            fullName = "Oleksii Khilkevych",
            title = "Site Reliability Engineer",
            color = mainColor,
            modifier = Modifier
                .padding(16.dp)
                .weight(3f)
        )
        ContactsSection(
            phone = "+49 163 166 96 87",
            email = "info@noroutine.com",
            url = "https://noroutine.com",
            social = "@noroutine",
            color = mainColor,
            modifier = Modifier
                .padding(16.dp)
                .weight(1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}