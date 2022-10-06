package unj.cs.hw4.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Coffee(@StringRes val titleResourceId : Int, @DrawableRes val imageResourceId : Int, @StringRes val descResourceId : Int)