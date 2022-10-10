package unj.cs.hw4.data

import unj.cs.hw4.model.Coffee

class FavoriteCoffee {
    private val favoriteCoffee : MutableList<Coffee> = mutableListOf()

    fun getFavoriteCoffee() : MutableList<Coffee> {
        return this.favoriteCoffee
    }

    fun addFavoriteCoffee(c : Coffee) {
        this.favoriteCoffee.add(c)
    }

    fun removeFavoriteCoffee(c : Coffee) {
        this.favoriteCoffee.remove(c)
    }
}