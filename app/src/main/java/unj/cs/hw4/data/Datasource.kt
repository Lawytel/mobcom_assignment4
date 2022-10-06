package unj.cs.hw4.data

import unj.cs.hw4.R
import unj.cs.hw4.model.Coffee

class Datasource {
    fun loadDataset() : List<Coffee> {
        return listOf<Coffee>(
            Coffee(R.string.coffee1, R.drawable.dice_1, R.string.coffee_desc1),
            Coffee(R.string.coffee2, R.drawable.dice_1, R.string.coffee_desc2),
            Coffee(R.string.coffee3, R.drawable.dice_1, R.string.coffee_desc3),
            Coffee(R.string.coffee4, R.drawable.dice_1, R.string.coffee_desc4),
            Coffee(R.string.coffee5, R.drawable.dice_1, R.string.coffee_desc5),
            Coffee(R.string.coffee6, R.drawable.dice_1, R.string.coffee_desc6),
            Coffee(R.string.coffee7, R.drawable.dice_1, R.string.coffee_desc7),
            Coffee(R.string.coffee8, R.drawable.dice_1, R.string.coffee_desc8),
            Coffee(R.string.coffee9, R.drawable.dice_1, R.string.coffee_desc9),
            Coffee(R.string.coffee10, R.drawable.dice_1, R.string.coffee_desc10)
        )
    }
}