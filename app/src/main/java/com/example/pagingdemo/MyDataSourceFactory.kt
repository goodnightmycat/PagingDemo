package com.example.pagingdemo

import androidx.paging.DataSource

class MyDataSourceFactory : DataSource.Factory<Int, Student>() {
    override fun create(): DataSource<Int, Student> {
        return DataSource()
    }

    private val CHEESE_DATA = arrayListOf(
        "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
        "Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale",
        "Aisy Cendre", "Allgauer Emmentaler", "Alverca", "Ambert", "American Cheese",
        "Ami du Chambertin", "Anejo Enchilado", "Anneau du Vic-Bilh", "Anthoriro", "Appenzell",
        "Aragon", "Ardi Gasna", "Ardrahan", "Armenian String", "Aromes au Gene de Marc",
        "Asadero", "Asiago", "Aubisque Pyrenees", "Autun", "Avaxtskyr", "Baby Swiss",
        "Babybel", "Baguette Laonnaise", "Bakers", "Baladi", "Balaton", "Bandal", "Banon",
        "Barry's Bay Cheddar", "Basing", "Basket Cheese", "Bath Cheese", "Bavarian Bergkase",
        "Baylough", "Beaufort", "Beauvoorde", "Beenleigh Blue", "Beer Cheese", "Bel Paese",
        "Bergader", "Bergere Bleue", "Berkswell", "Beyaz Peynir", "Bierkase", "Bishop Kennedy",
        "Blarney", "Bleu d'Auvergne", "Bleu de Gex", "Bleu de Laqueuille",
        "Bleu de Septmoncel", "Bleu Des Causses", "Blue", "Blue Castello", "Blue Rathgore",
        "Blue Vein (Australian)", "Blue Vein Cheeses", "Bocconcini", "Bocconcini (Australian)","easae1","reare2",
        "Bocconcini3","Bocconcini5","Bocconcini6","Bocconcini7","Beauvoorde2","Autun2","Autun"
    )

    inner class DataSource<T, U> : androidx.paging.PageKeyedDataSource<Int, Student>() {
        override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Student>) {
            val list = ArrayList<Student>()
            for (i in 0..20) {
                val student = Student()
                student.name = CHEESE_DATA[i]
                list.add(student)
            }
            callback.onResult(list, 0, 1)
        }

        override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Student>) {
            val list = ArrayList<Student>()
            for (i in 21..30) {
                val student = Student()
                student.name = CHEESE_DATA[i]
                list.add(student)
            }
            callback.onResult(list, 1)
        }

        override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Student>) {

        }

    }

}