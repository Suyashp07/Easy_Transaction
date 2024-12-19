package com.example.bankingappupi



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingappupi.data.Cards
import com.example.bankingappupi.ui.theme.BlueEnd
import com.example.bankingappupi.ui.theme.BlueStart
import com.example.bankingappupi.ui.theme.GreenEnd
import com.example.bankingappupi.ui.theme.GreenStart
import com.example.bankingappupi.ui.theme.OrangeEnd
import com.example.bankingappupi.ui.theme.OrangeStart
import com.example.bankingappupi.ui.theme.PurpleEnd
import com.example.bankingappupi.ui.theme.PurpleStart


val cards = listOf(
    Cards(
        cardType = "Visa",
        cardNumber = "3644 333 444 55556",
        cardName = "Business",
        balance = 46.467 ,
        color = getGradient(PurpleStart, PurpleEnd)
    ),
    Cards(
        cardType = "Master Card",
        cardNumber = "5456 3453 434 7556",
        cardName = "Savings",
        balance = 33.54 ,
        color = getGradient(BlueStart, BlueEnd)
    ),
    Cards(
        cardType = "Visa",
        cardNumber = "2222 3333 4444 5555",
        cardName = "School",
        balance = 34.567 ,
        color = getGradient(OrangeStart, OrangeEnd)
    ),
    Cards(
        cardType = "Master Card",
        cardNumber = "5555 3333 4444 5555",
        cardName = "Trips",
        balance = 74.567 ,
        color = getGradient(GreenStart, GreenEnd)
    )
)

fun getGradient(
    startColor: Color,
    endColor: Color
): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}
@Preview
@Composable
fun CardsSection(){
    LazyRow {
        items(cards.size){ index ->
            CardsItem(index)
        }
    }
}


@Composable
fun CardsItem(
    index: Int
){
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if(index == cards.size - 1 )
        lastItemPaddingEnd = 16.dp

    var image = painterResource(id = R.drawable.ic_visa)
    if (card.cardType == "Master Card") {
        image = painterResource(id = R.drawable.ic_mastercard)
    }

    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastItemPaddingEnd)
    ){
        Column (
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable {  }
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier.width(60.dp)
                )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "$ {card.balance}",
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

        }


    }
}