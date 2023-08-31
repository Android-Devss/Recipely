package com.example.recipely.ui

import android .os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recipely.data.source.DataSourceImp
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.databinding.FragmentRecipeDetailsBinding
import com.example.recipely.domain.Repository
import com.example.recipely.ui.base.BaseFragment
import com.example.recipely.util.CsvParser

class RecipeDetailsFragment : BaseFragment<FragmentRecipeDetailsBinding>() {
    private val dataSourceImp by lazy { DataSourceImp(requireContext(), CsvParser()) }
//    private lateinit var repository: Repository
//    private lateinit var recipe: Recipe
//    private val recipeList = dataSourceImp.getAllRecipes()


    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) ->
    FragmentRecipeDetailsBinding =  FragmentRecipeDetailsBinding::inflate
    override val logTag : String = this::class.java.simpleName

    override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    override fun initialize() {
//        val recipeId = getRecipeId() ?: return
//        recipe = getRecipeById(recipeId) ?: return
//        recipeList.filter { recipeId==it.id }
//       binding?.apply {
//           val textIngredients=";3 tablespoon Gram flour (besan);2 teaspoons Cumin seeds (Jeera);1 tablespoon Coriander Powder (Dhania);2 teaspoons Turmeric powder (Haldi);Salt - to taste;1 tablespoon Amchur (Dry Mango Powder);6 Karela (Bitter Gourd/ Pavakkai) - deseeded;Sunflower Oil - as required;1 Onion - thinly sliced"
//           val healthIngredients="salt;amchur (dry mango powder);karela (bitter gourd pavakkai);red chilli powder;gram flour (besan);onion;cumin seeds (jeera);coriander powder;turmeric powder;sunflower oil"
//           val textInstructions =";To begin making the Masala Karela Recipe;de-seed the karela and slice.Do not remove the skin as the skin has all the nutrients.Add the karela to the pressure cooker with 3 tablespoon of water; salt and turmeric powder and pressure cook for three whistles.Release the pressure immediately and open the lids.Keep aside.Heat oil in a heavy bottomed pan or a kadhai.Add cumin seeds and let it sizzle.Once the cumin seeds have sizzled; add onions and saute them till it turns golden brown in color.Add the karela; red chilli powder; amchur powder; coriander powder and besan.Stir to combine the masalas into the karela.Drizzle a little extra oil on the top and mix again.Cover the pan and simmer Masala Karela stirring occasionally until everything comes together well.Turn off the heat.Transfer Masala Karela into a serving bowl and serve.Serve Masala Karela along with Panchmel Dal and Phulka for a weekday meal with your family"
//           recipeDetailsIngredients.text=textIngredients.replace(";", "\n• ")
//           recipeDetailsHealthIngredients.text=healthIngredients.replace(";", "\n• ")
//           recipeDetailsInstructions.text=textInstructions.replace(";", "\n✓ ")
//        }
    }

    override fun addCallbacks() {
        }

//    private fun getRecipeById(recipeId: Int): Recipe? {
//        return repository.getAllRecipes().find { it.id == recipeId }
//    }
//
//    private fun getRecipeId(): Int? {
//        return arguments?.getInt(ID)
//    }
//
//    companion object {
//        private const val ID = "id"
//        fun newInstance(id: Int) = RecipeDetailsFragment().apply {
//            arguments = Bundle().apply {
//                putInt(ID, id)
//            }
//        }
//    }
}

